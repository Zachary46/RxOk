package com.rxok.ui.view;

import android.view.View;

/**
 * description ：
 * project name：RxOk
 * author : Zachary
 * creation date: 2017/7/7
 * @version 1.0
 */
public interface MvpView {

	void showLoading(String msg);

	void hideLoading();

	void showError(String msg, View.OnClickListener onClickListener);

	void showNetError(View.OnClickListener onClickListener);

}
