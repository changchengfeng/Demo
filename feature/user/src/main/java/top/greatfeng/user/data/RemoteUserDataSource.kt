package top.greatfeng.user.data

import top.greatfeng.user.model.User


class RemoteUserDataSource : UserRepository {
    override suspend fun getUser(username: String): User {
        TODO("Not yet implemented")
    }
}