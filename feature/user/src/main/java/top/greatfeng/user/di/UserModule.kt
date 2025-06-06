package top.greatfeng.user.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import top.greatfeng.network.annotations.Impl
import top.greatfeng.network.annotations.Local
import top.greatfeng.network.annotations.Remoter
import top.greatfeng.user.data.LocalUserDataSource
import top.greatfeng.user.data.RemoteUserDataSource
import top.greatfeng.user.data.UserRepository
import top.greatfeng.user.data.UserRepositoryImpl
import top.greatfeng.user.service.GitHubUser


@Module
@InstallIn(value = [ViewModelComponent::class])
object UserModule {

    @Provides
    fun provideGitHubUserService(
        retrofit: Retrofit
    ): GitHubUser {
        return retrofit
            .create(GitHubUser::class.java)
    }

    @Impl
    @Provides
    fun provideUserRepositoryImpl(
        @Local localUserDataSource: UserRepository,
        @Remoter remoteUserDataSource: UserRepository
    ): UserRepository {
        return UserRepositoryImpl(localUserDataSource, remoteUserDataSource)
    }


    @Remoter
    @Provides
    fun provideRemoteUserRepository(
        service: GitHubUser
    ): UserRepository {
        return RemoteUserDataSource(service)
    }

    @Local
    @Provides
    fun provideLocalUserRepository(
    ): UserRepository {
        return LocalUserDataSource()
    }
}