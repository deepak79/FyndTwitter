package go.fynd.twitter.model


import com.google.gson.annotations.SerializedName

data class TweetBean(
    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("id_str")
    val idStr: String = "",
    @SerializedName("text")
    val text: String = "",
    @SerializedName("truncated")
    val truncated: Boolean = false,
    @SerializedName("entities")
    val entities: Entities = Entities(),
    @SerializedName("source")
    val source: String = "",
    @SerializedName("user")
    val user: User = User(),
    @SerializedName("is_quote_status")
    val isQuoteStatus: Boolean = false,
    @SerializedName("retweet_count")
    val retweetCount: Int = 0,
    @SerializedName("favorite_count")
    val favoriteCount: Int = 0,
    @SerializedName("favorited")
    val favorited: Boolean = false,
    @SerializedName("retweeted")
    val retweeted: Boolean = false,
    @SerializedName("lang")
    val lang: String = "",
    @SerializedName("possibly_sensitive")
    val possiblySensitive: Boolean = false,
    @SerializedName("possibly_sensitive_appealable")
    val possiblySensitiveAppealable: Boolean = false,
    @SerializedName("quoted_status_id")
    val quotedStatusId: Long = 0,
    @SerializedName("quoted_status_id_str")
    val quotedStatusIdStr: String = "",
    @SerializedName("quoted_status")
    val quotedStatus: QuotedStatus = QuotedStatus(),
    @SerializedName("extended_entities")
    val extendedEntities: ExtendedEntities = ExtendedEntities(),
    @SerializedName("in_reply_to_status_id")
    val inReplyToStatusId: Any = Any(),
    @SerializedName("in_reply_to_status_id_str")
    val inReplyToStatusIdStr: Any = Any(),
    @SerializedName("in_reply_to_user_id")
    val inReplyToUserId: Any = Any(),
    @SerializedName("in_reply_to_user_id_str")
    val inReplyToUserIdStr: Any = Any(),
    @SerializedName("in_reply_to_screen_name")
    val inReplyToScreenName: Any = Any(),
    @SerializedName("geo")
    val geo: Any = Any(),
    @SerializedName("coordinates")
    val coordinates: Any = Any(),
    @SerializedName("place")
    val place: Any = Any(),
    @SerializedName("contributors")
    val contributors: Any = Any()
) {
    data class Entities(
        @SerializedName("hashtags")
        val hashtags: List<Any> = listOf(),
        @SerializedName("symbols")
        val symbols: List<Any> = listOf(),
        @SerializedName("user_mentions")
        val userMentions: List<Any> = listOf(),
        @SerializedName("urls")
        val urls: List<Url> = listOf()
    ) {
        data class Url(
            @SerializedName("url")
            val url: String = "",
            @SerializedName("expanded_url")
            val expandedUrl: String = "",
            @SerializedName("display_url")
            val displayUrl: String = "",
            @SerializedName("indices")
            val indices: List<Int> = listOf()
        )
    }

    data class User(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("id_str")
        val idStr: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("screen_name")
        val screenName: String = "",
        @SerializedName("location")
        val location: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("url")
        val url: String = "",
        @SerializedName("entities")
        val entities: Entities = Entities(),
        @SerializedName("protected")
        val `protected`: Boolean = false,
        @SerializedName("followers_count")
        val followersCount: Int = 0,
        @SerializedName("friends_count")
        val friendsCount: Int = 0,
        @SerializedName("listed_count")
        val listedCount: Int = 0,
        @SerializedName("created_at")
        val createdAt: String = "",
        @SerializedName("favourites_count")
        val favouritesCount: Int = 0,
        @SerializedName("utc_offset")
        val utcOffset: Any = Any(),
        @SerializedName("time_zone")
        val timeZone: Any = Any(),
        @SerializedName("geo_enabled")
        val geoEnabled: Boolean = false,
        @SerializedName("verified")
        val verified: Boolean = false,
        @SerializedName("statuses_count")
        val statusesCount: Int = 0,
        @SerializedName("lang")
        val lang: Any = Any(),
        @SerializedName("contributors_enabled")
        val contributorsEnabled: Boolean = false,
        @SerializedName("is_translator")
        val isTranslator: Boolean = false,
        @SerializedName("is_translation_enabled")
        val isTranslationEnabled: Boolean = false,
        @SerializedName("profile_background_color")
        val profileBackgroundColor: String = "",
        @SerializedName("profile_background_image_url")
        val profileBackgroundImageUrl: String = "",
        @SerializedName("profile_background_image_url_https")
        val profileBackgroundImageUrlHttps: String = "",
        @SerializedName("profile_background_tile")
        val profileBackgroundTile: Boolean = false,
        @SerializedName("profile_image_url")
        val profileImageUrl: String = "",
        @SerializedName("profile_image_url_https")
        val profileImageUrlHttps: String = "",
        @SerializedName("profile_banner_url")
        val profileBannerUrl: String = "",
        @SerializedName("profile_link_color")
        val profileLinkColor: String = "",
        @SerializedName("profile_sidebar_border_color")
        val profileSidebarBorderColor: String = "",
        @SerializedName("profile_sidebar_fill_color")
        val profileSidebarFillColor: String = "",
        @SerializedName("profile_text_color")
        val profileTextColor: String = "",
        @SerializedName("profile_use_background_image")
        val profileUseBackgroundImage: Boolean = false,
        @SerializedName("has_extended_profile")
        val hasExtendedProfile: Boolean = false,
        @SerializedName("default_profile")
        val defaultProfile: Boolean = false,
        @SerializedName("default_profile_image")
        val defaultProfileImage: Boolean = false,
        @SerializedName("can_media_tag")
        val canMediaTag: Boolean = false,
        @SerializedName("followed_by")
        val followedBy: Boolean = false,
        @SerializedName("following")
        val following: Boolean = false,
        @SerializedName("follow_request_sent")
        val followRequestSent: Boolean = false,
        @SerializedName("notifications")
        val notifications: Boolean = false,
        @SerializedName("translator_type")
        val translatorType: String = ""
    ) {
        data class Entities(
            @SerializedName("description")
            val description: Description = Description()
        ) {
            data class Description(
                @SerializedName("urls")
                val urls: List<Any> = listOf()
            )
        }
    }

    data class QuotedStatus(
        @SerializedName("created_at")
        val createdAt: String = "",
        @SerializedName("id")
        val id: Long = 0,
        @SerializedName("id_str")
        val idStr: String = "",
        @SerializedName("text")
        val text: String = "",
        @SerializedName("truncated")
        val truncated: Boolean = false,
        @SerializedName("entities")
        val entities: Entities = Entities(),
        @SerializedName("source")
        val source: String = "",
        @SerializedName("in_reply_to_status_id")
        val inReplyToStatusId: Any = Any(),
        @SerializedName("in_reply_to_status_id_str")
        val inReplyToStatusIdStr: Any = Any(),
        @SerializedName("in_reply_to_user_id")
        val inReplyToUserId: Any = Any(),
        @SerializedName("in_reply_to_user_id_str")
        val inReplyToUserIdStr: Any = Any(),
        @SerializedName("in_reply_to_screen_name")
        val inReplyToScreenName: Any = Any(),
        @SerializedName("user")
        val user: User = User(),
        @SerializedName("geo")
        val geo: Any = Any(),
        @SerializedName("coordinates")
        val coordinates: Any = Any(),
        @SerializedName("place")
        val place: Any = Any(),
        @SerializedName("contributors")
        val contributors: Any = Any(),
        @SerializedName("is_quote_status")
        val isQuoteStatus: Boolean = false,
        @SerializedName("retweet_count")
        val retweetCount: Int = 0,
        @SerializedName("favorite_count")
        val favoriteCount: Int = 0,
        @SerializedName("favorited")
        val favorited: Boolean = false,
        @SerializedName("retweeted")
        val retweeted: Boolean = false,
        @SerializedName("possibly_sensitive")
        val possiblySensitive: Boolean = false,
        @SerializedName("possibly_sensitive_appealable")
        val possiblySensitiveAppealable: Boolean = false,
        @SerializedName("lang")
        val lang: String = ""
    ) {
        data class Entities(
            @SerializedName("hashtags")
            val hashtags: List<Any> = listOf(),
            @SerializedName("symbols")
            val symbols: List<Any> = listOf(),
            @SerializedName("user_mentions")
            val userMentions: List<Any> = listOf(),
            @SerializedName("urls")
            val urls: List<Url> = listOf()
        ) {
            data class Url(
                @SerializedName("url")
                val url: String = "",
                @SerializedName("expanded_url")
                val expandedUrl: String = "",
                @SerializedName("display_url")
                val displayUrl: String = "",
                @SerializedName("indices")
                val indices: List<Int> = listOf()
            )
        }

        data class User(
            @SerializedName("id")
            val id: Long = 0,
            @SerializedName("id_str")
            val idStr: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("screen_name")
            val screenName: String = "",
            @SerializedName("location")
            val location: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("url")
            val url: String = "",
            @SerializedName("entities")
            val entities: Entities = Entities(),
            @SerializedName("protected")
            val `protected`: Boolean = false,
            @SerializedName("followers_count")
            val followersCount: Int = 0,
            @SerializedName("friends_count")
            val friendsCount: Int = 0,
            @SerializedName("listed_count")
            val listedCount: Int = 0,
            @SerializedName("created_at")
            val createdAt: String = "",
            @SerializedName("favourites_count")
            val favouritesCount: Int = 0,
            @SerializedName("utc_offset")
            val utcOffset: Any = Any(),
            @SerializedName("time_zone")
            val timeZone: Any = Any(),
            @SerializedName("geo_enabled")
            val geoEnabled: Boolean = false,
            @SerializedName("verified")
            val verified: Boolean = false,
            @SerializedName("statuses_count")
            val statusesCount: Int = 0,
            @SerializedName("lang")
            val lang: Any = Any(),
            @SerializedName("contributors_enabled")
            val contributorsEnabled: Boolean = false,
            @SerializedName("is_translator")
            val isTranslator: Boolean = false,
            @SerializedName("is_translation_enabled")
            val isTranslationEnabled: Boolean = false,
            @SerializedName("profile_background_color")
            val profileBackgroundColor: String = "",
            @SerializedName("profile_background_image_url")
            val profileBackgroundImageUrl: String = "",
            @SerializedName("profile_background_image_url_https")
            val profileBackgroundImageUrlHttps: String = "",
            @SerializedName("profile_background_tile")
            val profileBackgroundTile: Boolean = false,
            @SerializedName("profile_image_url")
            val profileImageUrl: String = "",
            @SerializedName("profile_image_url_https")
            val profileImageUrlHttps: String = "",
            @SerializedName("profile_banner_url")
            val profileBannerUrl: String = "",
            @SerializedName("profile_link_color")
            val profileLinkColor: String = "",
            @SerializedName("profile_sidebar_border_color")
            val profileSidebarBorderColor: String = "",
            @SerializedName("profile_sidebar_fill_color")
            val profileSidebarFillColor: String = "",
            @SerializedName("profile_text_color")
            val profileTextColor: String = "",
            @SerializedName("profile_use_background_image")
            val profileUseBackgroundImage: Boolean = false,
            @SerializedName("has_extended_profile")
            val hasExtendedProfile: Boolean = false,
            @SerializedName("default_profile")
            val defaultProfile: Boolean = false,
            @SerializedName("default_profile_image")
            val defaultProfileImage: Boolean = false,
            @SerializedName("can_media_tag")
            val canMediaTag: Boolean = false,
            @SerializedName("followed_by")
            val followedBy: Boolean = false,
            @SerializedName("following")
            val following: Boolean = false,
            @SerializedName("follow_request_sent")
            val followRequestSent: Boolean = false,
            @SerializedName("notifications")
            val notifications: Boolean = false,
            @SerializedName("translator_type")
            val translatorType: String = ""
        ) {
            data class Entities(
                @SerializedName("description")
                val description: Description = Description()
            ) {
                data class Description(
                    @SerializedName("urls")
                    val urls: List<Any> = listOf()
                )
            }
        }
    }

    data class ExtendedEntities(
        @SerializedName("media")
        val media: List<Media> = listOf()
    ) {
        data class Media(
            @SerializedName("id")
            val id: Long = 0,
            @SerializedName("id_str")
            val idStr: String = "",
            @SerializedName("indices")
            val indices: List<Int> = listOf(),
            @SerializedName("media_url")
            val mediaUrl: String = "",
            @SerializedName("media_url_https")
            val mediaUrlHttps: String = "",
            @SerializedName("url")
            val url: String = "",
            @SerializedName("display_url")
            val displayUrl: String = "",
            @SerializedName("expanded_url")
            val expandedUrl: String = "",
            @SerializedName("type")
            val type: String = "",
            @SerializedName("sizes")
            val sizes: Sizes = Sizes(),
            @SerializedName("features")
            val features: Features = Features()
        ) {
            data class Sizes(
                @SerializedName("thumb")
                val thumb: Thumb = Thumb(),
                @SerializedName("large")
                val large: Large = Large(),
                @SerializedName("medium")
                val medium: Medium = Medium(),
                @SerializedName("small")
                val small: Small = Small()
            ) {
                data class Thumb(
                    @SerializedName("w")
                    val w: Int = 0,
                    @SerializedName("h")
                    val h: Int = 0,
                    @SerializedName("resize")
                    val resize: String = ""
                )

                data class Large(
                    @SerializedName("w")
                    val w: Int = 0,
                    @SerializedName("h")
                    val h: Int = 0,
                    @SerializedName("resize")
                    val resize: String = ""
                )

                data class Medium(
                    @SerializedName("w")
                    val w: Int = 0,
                    @SerializedName("h")
                    val h: Int = 0,
                    @SerializedName("resize")
                    val resize: String = ""
                )

                data class Small(
                    @SerializedName("w")
                    val w: Int = 0,
                    @SerializedName("h")
                    val h: Int = 0,
                    @SerializedName("resize")
                    val resize: String = ""
                )
            }

            data class Features(
                @SerializedName("all")
                val all: All = All(),
                @SerializedName("large")
                val large: Large = Large(),
                @SerializedName("medium")
                val medium: Medium = Medium(),
                @SerializedName("small")
                val small: Small = Small(),
                @SerializedName("orig")
                val orig: Orig = Orig()
            ) {
                data class All(
                    @SerializedName("tags")
                    val tags: List<Tag> = listOf()
                ) {
                    data class Tag(
                        @SerializedName("type")
                        val type: String = "",
                        @SerializedName("user_id")
                        val userId: String = "",
                        @SerializedName("screen_name")
                        val screenName: String = "",
                        @SerializedName("name")
                        val name: String = ""
                    )
                }

                data class Large(
                    @SerializedName("faces")
                    val faces: List<Any> = listOf()
                )

                data class Medium(
                    @SerializedName("faces")
                    val faces: List<Any> = listOf()
                )

                data class Small(
                    @SerializedName("faces")
                    val faces: List<Any> = listOf()
                )

                data class Orig(
                    @SerializedName("faces")
                    val faces: List<Any> = listOf()
                )
            }
        }
    }
}