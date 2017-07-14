package com.rxok.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rxok.R;
import com.rxok.model.OkEntity;

import java.util.List;

/**
 * description ：
 * project name：RxOk
 * author : Zachary
 * creation date: 2017/7/7
 * @version 1.0
 */
public class OkAdapter extends BaseQuickAdapter<OkEntity.TngouBean> {

	public OkAdapter(int layoutResId, List<OkEntity.TngouBean> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder baseViewHolder, OkEntity.TngouBean tngouBean) {
		baseViewHolder.setText(R.id.keyword,tngouBean.getKeywords()+"");
		baseViewHolder.setOnClickListener(R.id.cardView, new OnItemChildClickListener());
	}
}
