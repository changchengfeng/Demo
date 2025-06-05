package top.greatfeng.user.data

import top.greatfeng.user.model.User


/*
 *Created by greatfeng
 * on 2025/6/5.
*/
class LocalUserDataSource : UserRepository{
    override suspend fun getUser(username: String): User {
        TODO("Not yet implemented")
    }
}