package top.greatfeng.user.data

import top.greatfeng.user.model.User


interface UserRepository {
    suspend fun getUser(username: String): User
}