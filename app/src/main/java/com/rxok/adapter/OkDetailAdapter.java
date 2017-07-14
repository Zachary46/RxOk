package com.rxok.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rxok.R;
import com.rxok.model.OkDetailEntity;

import java.util.List;

/**
 * description ：
 * project name：RxOk
 * author : Zachary
 * creation date: 2017/7/7
 * @version 1.0
 */
public class OkDetailAdapter extends BaseQuickAdapter<OkDetailEntity.TngouBean> {


	public OkDetailAdapter(int layoutResId, List<OkDetailEntity.TngouBean> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder baseViewHolder, OkDetailEntity.TngouBean tngouBean) {
		baseViewHolder.setText(R.id.tv_title,tngouBean.getTitle());
		Log.e("OkDetailEntity","http://tnfs.tngou.net/image"+tngouBean.getImg()+"_180x120");
		Glide.with(baseViewHolder.getConvertView().getContext())
				.load("http://tnfs.tngou.net/image"+tngouBean.getImg())
		        .placeholder(R.mipmap.loading)
				.error(R.mipmap.failed)
				.into((ImageView) baseViewHolder.getView(R.id.iv_img));
	}
}
