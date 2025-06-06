package top.greatfeng.user.data

import top.greatfeng.network.annotations.Local
import top.greatfeng.network.annotations.Remoter
import top.greatfeng.user.model.User


class UserRepositoryImpl constructor(
    @Local val localUserDataSource: UserRepository,
    @Remoter val remoteUserDataSource: UserRepository
) : UserRepository {
    override suspend fun getUser(username: String): User {
        return remoteUserDataSource.getUser(username)
    }

}