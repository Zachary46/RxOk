package com.rxok.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rxok.R;
import com.rxok.adapter.OkDetailAdapter;
import com.rxok.model.OkDetailEntity;
import com.rxok.presenter.OkDetailPresenter;
import com.rxok.ui.view.OkDetailView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * description ：
 * project name：RxOk
 * author : Zachary
 * creation date: 2017/7/7
 * @version 1.0
 */
public class OkDetailActivity extends BaseActivity<OkDetailPresenter> implements OkDetailView, SwipeRefreshLayout.OnRefreshListener {

	OkDetailPresenter mOkDetailPresenter;
	OkDetailAdapter mOkDetailAdapter;
	private int page = 1;
	private int id = 1;
	List<OkDetailEntity.TngouBean> mBeautyDetailEntityList;
	@BindView(R.id.rv_beauty_detail)
	RecyclerView mRvBeautyDetail;
	@BindView(R.id.layout_swipe_refresh)
	SwipeRefreshLayout mRefreshLayout;

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
		return R.layout.activity_ok_detail;
	}

	@Override
	protected void initData() {
		id = getIntent().getIntExtra("id", 1);
		mBeautyDetailEntityList = new ArrayList<>();
		mOkDetailAdapter = new OkDetailAdapter(R.layout.item_ok_detail_list, mBeautyDetailEntityList);
		mRvBeautyDetail.setLayoutManager(new GridLayoutManager(this, 2));
		mRvBeautyDetail.setAdapter(mOkDetailAdapter);
		mOkDetailPresenter.attachView(this);
		mOkDetailAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
		loadData(true);

	}

	private void loadData(boolean isRefresh) {
		if(isRefresh){
			page=1;
		}
		mOkDetailPresenter.loadBeautyDetail(id, page, 6);
	}

	@Override
	protected OkDetailPresenter getPresenter() {
		mOkDetailPresenter = new OkDetailPresenter();
		return mOkDetailPresenter;
	}

	@Override
	protected void initEvent() {
		mRefreshLayout.setOnRefreshListener(this);

	}


	@Override
	public void refresh(List<OkDetailEntity.TngouBean> datas) {
		Log.e("refresh加载成功", datas.toString());
		mRefreshLayout.setRefreshing(false);
		mBeautyDetailEntityList.clear();
		mBeautyDetailEntityList.addAll(datas);
		mOkDetailAdapter.notifyDataSetChanged();
	}

	@Override
	public void loadMore(List<OkDetailEntity.TngouBean> datas) {
		Log.e("loadMore加载成功", datas.toString());
		mBeautyDetailEntityList.addAll(datas);
		mOkDetailAdapter.notifyDataSetChanged();
	}


	@Override
	public void onRefresh() {
		loadData(true);
	}
}
