package com.rxok.ui.view;

import com.rxok.model.OkEntity;

import java.util.List;

/**
 * description ：
 * project name：RxOk
 * author : Zachary
 * creation date: 2017/7/7
 * @version 1.0
 */
public interface OkView extends MvpView {

	void loadComplete(List<OkEntity.TngouBean>  data);
}
