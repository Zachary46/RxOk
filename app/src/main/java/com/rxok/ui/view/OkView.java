package com.rxok.ui.view;

import com.rxok.model.OkEntity;

import java.util.List;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:13
 *
 * @version 1.0
 */
public interface OkView extends MvpView {

	void loadComplete(List<OkEntity.TngouBean>  data);
}
