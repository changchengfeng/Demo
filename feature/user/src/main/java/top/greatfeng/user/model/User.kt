package top.greatfeng.user.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(

    @SerialName("gists_url")
    val gistsUrl: String? = null,

    @SerialName("repos_url")
    val reposUrl: String? = null,

    @SerialName("user_view_type")
    val userViewType: String? = null,

    @SerialName("following_url")
    val followingUrl: String? = null,
    @Contextual
    @SerialName("twitter_username")
    val twitterUsername: Any? = null,
    @Contextual
    @SerialName("bio")
    val bio: Any? = null,

    @SerialName("created_at")
    val createdAt: String? = null,

    @SerialName("login")
    val login: String? = null,

    @SerialName("type")
    val type: String? = null,

    @SerialName("blog")
    val blog: String? = null,

    @SerialName("subscriptions_url")
    val subscriptionsUrl: String? = null,

    @SerialName("updated_at")
    val updatedAt: String? = null,

    @SerialName("site_admin")
    val siteAdmin: Boolean? = null,

    @Contextual
    @SerialName("company")
    val company: Any? = null,

    @SerialName("id")
    val id: Int? = null,

    @SerialName("public_repos")
    val publicRepos: Int? = null,

    @SerialName("gravatar_id")
    val gravatarId: String? = null,

    @Contextual
    @SerialName("email")
    val email: Any? = null,

    @SerialName("organizations_url")
    val organizationsUrl: String? = null,

    @Contextual
    @SerialName("hireable")
    val hireable: Any? = null,

    @SerialName("starred_url")
    val starredUrl: String? = null,

    @SerialName("followers_url")
    val followersUrl: String? = null,

    @SerialName("public_gists")
    val publicGists: Int? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("received_events_url")
    val receivedEventsUrl: String? = null,

    @SerialName("followers")
    val followers: Int? = null,

    @SerialName("avatar_url")
    val avatarUrl: String? = null,

    @SerialName("events_url")
    val eventsUrl: String? = null,

    @SerialName("html_url")
    val htmlUrl: String? = null,

    @SerialName("following")
    val following: Int? = null,

    @Contextual
    @SerialName("name")
    val name: Any? = null,

    @Contextual
    @SerialName("location")
    val location: Any? = null,

    @SerialName("node_id")
    val nodeId: String? = null
)
