package com.yash.mycover.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.Header
import retrofit2.http.POST


private const val BASEURL = "https://www.driver007.com/admin/app_api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val logging = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY)

private val retrofit = Retrofit.Builder()
    .client(OkHttpClient.Builder().addInterceptor(logging).build())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASEURL)
    .build()


interface CoverApiService {

    @POST("job/list_coverjob")
    fun getCoverJobDetails(
        @Header("Content-Type") authorization: String,
        @Header("Apikey") apiKey: String
    ): Deferred<CoverJob>

}


object CoverApi {
    val retrofitService: CoverApiService by lazy {
        retrofit.create(CoverApiService::class.java)
    }
}
