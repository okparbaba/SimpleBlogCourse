package com.example.simpleblog.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitHelper {
    companion object {
        inline fun <reified T> getRetrofit(): T {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val okCli = OkHttpClient.Builder()
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okCli.interceptors().add(interceptor)
            val okclient = okCli.build()

            val ret = Retrofit.Builder()
                .client(okclient)
                .baseUrl("http://172.17.20.67:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(T::class.java)
        return ret
        }

    }
}