package top.greatfeng.network.annotations

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Local

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Remoter

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl
