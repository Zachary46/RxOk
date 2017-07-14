package com.rxok.presenter;

import com.rxok.ui.view.MvpView;

/**
 * description ：
 * project name：RxOk
 * author : Zachary
 * creation date: 2017/7/7
 * @version 1.0
 */
public interface Presenter<V extends MvpView> {

	void attachView(V mvpView);

	void detachView();
}
