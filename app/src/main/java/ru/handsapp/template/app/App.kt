package ru.handsapp.template.app

import android.app.Application
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.handsapp.template.BuildConfig
import ru.handsapp.template.data.network.RetrofitQuery

class App : Application() {

    private lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()

        // Gson init
        val gson = GsonBuilder()
            .setLenient()
            .create()

        // Retrofit init
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(getSafeOkHttpClient())
            .build()
        api = retrofit.create(RetrofitQuery::class.java)
    }

    companion object {
        var api: RetrofitQuery? = null
            private set

        const val BASE_URL = "https://template.handsapp.ru/"
    }

    private fun getSafeOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            //Для дебага запросов App GET/POST
            val httpInterceptor = HttpLoggingInterceptor()
            httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(httpInterceptor)
        }
        return builder
            .build()
    }
}