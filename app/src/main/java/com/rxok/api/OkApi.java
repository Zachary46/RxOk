package com.rxok.api;

import com.rxok.model.OkDetailEntity;
import com.rxok.model.OkEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface OkApi {
	@GET("/tnfs/api/classify")
	Observable<OkEntity> getBeauty();

	@GET("/tnfs/api/list")
	Observable<OkDetailEntity> getBeautyDetail(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);
}
