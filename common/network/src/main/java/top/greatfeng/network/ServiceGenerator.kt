package top.greatfeng.network


import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


object ServiceGenerator {
    const val API_BASE_URL: String = "https://api.github.com"

    private val okHttpClient: OkHttpClient

    private val retrofit: Retrofit

    init {
        okHttpClient = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory("application/json; charset=UTF8".toMediaType())
            )
            .client(okHttpClient)
            .build()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create<S>(serviceClass)
    }
}