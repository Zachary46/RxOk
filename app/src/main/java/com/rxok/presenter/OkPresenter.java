package com.rxok.presenter;

import com.rxok.api.OkApi;
import com.rxok.api.RxService;
import com.rxok.model.OkEntity;
import com.rxok.ui.view.OkView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 10:18
 *
 * @version 1.0
 */
public class OkPresenter extends BasePresenter<OkView> {
	@Override
	public void attachView(OkView mvpView) {
		super.attachView(mvpView);
	}

	@Override
	public void detachView() {
		super.detachView();
	}

	public void loadBeauty() {
		RxService.createApi(OkApi.class)
				.getBeauty()
				.subscribeOn(Schedulers.io())
				.map(new Func1<OkEntity, List<OkEntity.TngouBean>>() {

					@Override
					public List<OkEntity.TngouBean> call(OkEntity okEntity) {
						return okEntity.getTngou();
					}
				})
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<List<OkEntity.TngouBean>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {
						getMvpView().showError(e.toString(), null);
					}

					@Override
					public void onNext(List<OkEntity.TngouBean> tngouBeen) {
						getMvpView().loadComplete(tngouBeen);
					}
				});
	}
}
