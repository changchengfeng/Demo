package top.greatfeng.user.data

import top.greatfeng.network.NetworkStatusUtil
import top.greatfeng.user.model.User


class UserRepositoryImpl(val localUserDataSource: LocalUserDataSource ,val remoteUserDataSource: RemoteUserDataSource):UserRepository {
    override suspend fun getUser(username: String): User {
        TODO("Not yet implemented")
    }

}