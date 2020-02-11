package ru.handsapp.template.data.network

import retrofit2.Call
import retrofit2.http.GET
import ru.handsapp.template.data.network.responses.AuthProfileResult

interface RetrofitQuery {

    /*Получение профиля*/
    @GET("api/template/user")
    fun getUserProfile(): Call<AuthProfileResult>
}


