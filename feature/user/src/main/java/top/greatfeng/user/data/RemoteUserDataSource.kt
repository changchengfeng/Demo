package top.greatfeng.user.data

import top.greatfeng.user.model.User
import top.greatfeng.user.service.GitHubUser


class RemoteUserDataSource(
    private val service: GitHubUser
) : UserRepository {
    override suspend fun getUser(username: String): User {
        return service.getUserInfo(username)
    }
}