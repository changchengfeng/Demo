package top.greatfeng.user.service

import retrofit2.http.GET
import retrofit2.http.Path
import top.greatfeng.user.model.User

interface GitHubUser {
    @GET("users/{username}")
    suspend fun getUserInfo(@Path("username") username: String): User
}