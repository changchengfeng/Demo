package top.greatfeng.user.data

import kotlinx.coroutines.flow.Flow
import top.greatfeng.user.model.User

class LocalUserDataSource : UserRepository{
    override suspend fun getUser(username: String):User {
        TODO("Not yet implemented")
    }
}