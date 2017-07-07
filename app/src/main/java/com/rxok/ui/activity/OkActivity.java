package com.rxok.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rxok.R;
import com.rxok.adapter.OkAdapter;
import com.rxok.model.OkEntity;
import com.rxok.presenter.OkPresenter;
import com.rxok.ui.view.OkView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:51
 *
 * @version 1.0
 */
public class OkActivity extends BaseActivity<OkPresenter> implements OkView, BaseQuickAdapter.OnRecyclerViewItemChildClickListener {

	@BindView(R.id.rv_beauty)
	RecyclerView mRvBeauty;
	private OkPresenter okPresenter;
	private List<OkEntity.TngouBean> mTngouBeanList;
	OkAdapter mOkAdapter;

	@Override
	public void showLoading(String msg) {

	}

	@Override
	public void hideLoading() {

	}

	@Override
	public void showError(String msg, View.OnClickListener onClickListener) {

	}


	@Override
	public void showNetError(View.OnClickListener onClickListener) {

	}

	@Override
	protected int getLayout() {
		return R.layout.activity_ok;
	}


	@Override
	protected void initData() {
		mTngouBeanList = new ArrayList<>();
		mOkAdapter = new OkAdapter(R.layout.item_ok_list, mTngouBeanList);
		mOkAdapter.openLoadAnimation();
		mRvBeauty.setLayoutManager(new GridLayoutManager(this, 1));
		okPresenter.attachView(this);
		okPresenter.loadBeauty();
		mRvBeauty.setAdapter(mOkAdapter);
	}

	@Override
	protected OkPresenter getPresenter() {
		okPresenter = new OkPresenter();
		return okPresenter;
	}

	@Override
	protected void initEvent() {
		mOkAdapter.setOnRecyclerViewItemChildClickListener(this);

	}


	@Override
	public void loadComplete(List<OkEntity.TngouBean> datas) {
		mTngouBeanList.clear();
		mTngouBeanList.addAll(datas);
		mOkAdapter.notifyDataSetChanged();

	}


	@Override
	public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
		startActivity(new Intent(this,OkDetailActivity.class).putExtra("id",i+1%7));
	}
}
