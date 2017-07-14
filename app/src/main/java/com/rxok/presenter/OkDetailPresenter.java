package com.rxok.presenter;

import com.rxok.api.OkApi;
import com.rxok.api.RxService;
import com.rxok.model.OkDetailEntity;
import com.rxok.ui.view.OkDetailView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.rxok.model.OkDetailEntity.TngouBean;

/**
 * description ：
 * project name：RxOk
 * author : Zachary
 * creation date: 2017/7/7
 * @version 1.0
 */
public class OkDetailPresenter extends BasePresenter<OkDetailView> {
	@Override
	public void attachView(OkDetailView mvpView) {
		super.attachView(mvpView);
	}

	@Override
	public void detachView() {
		super.detachView();
	}

	public void loadBeautyDetail(int id, final int page, int rows){
		RxService.createApi(OkApi.class)
				.getBeautyDetail(id,page,rows)
				.subscribeOn(Schedulers.io())
				.map(new Func1<OkDetailEntity, List<OkDetailEntity.TngouBean>>() {
					@Override
					public List<TngouBean> call(OkDetailEntity okDetailEntity) {
						return okDetailEntity.getTngou();
					}
				}).observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<List<OkDetailEntity.TngouBean>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {
						getMvpView().showError(e.toString(), null);
					}

					@Override
					public void onNext(List<OkDetailEntity.TngouBean> tngouBeen) {
						if(page==1){
							getMvpView().refresh(tngouBeen);
						}else {
							getMvpView().loadMore(tngouBeen);
						}
					}
				});
	}
}
