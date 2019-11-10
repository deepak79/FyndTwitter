package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("id")
    val id: Long? = 0,
    @SerializedName("id_str")
    val idStr: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("screen_name")
    val screenName: String? = "",
    @SerializedName("location")
    val location: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("entities")
    val entities: EntitiesXXX? = EntitiesXXX(),
    @SerializedName("protected")
    val `protected`: Boolean? = false,
    @SerializedName("followers_count")
    val followersCount: Int? = 0,
    @SerializedName("friends_count")
    val friendsCount: Int? = 0,
    @SerializedName("listed_count")
    val listedCount: Int? = 0,
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("favourites_count")
    val favouritesCount: Int? = 0,
    @SerializedName("utc_offset")
    val utcOffset: Any? = Any(),
    @SerializedName("time_zone")
    val timeZone: Any? = Any(),
    @SerializedName("geo_enabled")
    val geoEnabled: Boolean? = false,
    @SerializedName("verified")
    val verified: Boolean? = false,
    @SerializedName("statuses_count")
    val statusesCount: Int? = 0,
    @SerializedName("lang")
    val lang: Any? = Any(),
    @SerializedName("contributors_enabled")
    val contributorsEnabled: Boolean? = false,
    @SerializedName("is_translator")
    val isTranslator: Boolean? = false,
    @SerializedName("is_translation_enabled")
    val isTranslationEnabled: Boolean? = false,
    @SerializedName("profile_background_color")
    val profileBackgroundColor: String? = "",
    @SerializedName("profile_background_image_url")
    val profileBackgroundImageUrl: String? = "",
    @SerializedName("profile_background_image_url_https")
    val profileBackgroundImageUrlHttps: String? = "",
    @SerializedName("profile_background_tile")
    val profileBackgroundTile: Boolean? = false,
    @SerializedName("profile_image_url")
    val profileImageUrl: String? = "",
    @SerializedName("profile_image_url_https")
    val profileImageUrlHttps: String? = "",
    @SerializedName("profile_banner_url")
    val profileBannerUrl: String? = "",
    @SerializedName("profile_link_color")
    val profileLinkColor: String? = "",
    @SerializedName("profile_sidebar_border_color")
    val profileSidebarBorderColor: String? = "",
    @SerializedName("profile_sidebar_fill_color")
    val profileSidebarFillColor: String? = "",
    @SerializedName("profile_text_color")
    val profileTextColor: String? = "",
    @SerializedName("profile_use_background_image")
    val profileUseBackgroundImage: Boolean? = false,
    @SerializedName("has_extended_profile")
    val hasExtendedProfile: Boolean? = false,
    @SerializedName("default_profile")
    val defaultProfile: Boolean? = false,
    @SerializedName("default_profile_image")
    val defaultProfileImage: Boolean? = false,
    @SerializedName("can_media_tag")
    val canMediaTag: Boolean? = false,
    @SerializedName("followed_by")
    val followedBy: Boolean? = false,
    @SerializedName("following")
    val following: Boolean? = false,
    @SerializedName("follow_request_sent")
    val followRequestSent: Boolean? = false,
    @SerializedName("notifications")
    val notifications: Boolean? = false,
    @SerializedName("translator_type")
    val translatorType: String? = ""
)