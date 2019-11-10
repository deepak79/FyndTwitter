package go.fynd.twitter.model.tweet


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class TweetsBean(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("pId")
    var pId: Int? = null,
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("id")
    val id: Long? = 0,
    @SerializedName("id_str")
    val idStr: String? = "",
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("truncated")
    val truncated: Boolean? = false,
    @SerializedName("entities")
    val entities: Entities? = Entities(),
    @SerializedName("source")
    val source: String? = "",
    @SerializedName("user")
    val user: User? = User(),
    @SerializedName("is_quote_status")
    val isQuoteStatus: Boolean? = false,
    @SerializedName("quoted_status_id")
    val quotedStatusId: Long? = 0,
    @SerializedName("quoted_status_id_str")
    val quotedStatusIdStr: String? = "",
    @SerializedName("quoted_status")
    val quotedStatus: QuotedStatus? = QuotedStatus(),
    @SerializedName("retweet_count")
    val retweetCount: Int? = 0,
    @SerializedName("favorite_count")
    val favoriteCount: Int?= 0,
    @SerializedName("favorited")
    val favorited: Boolean? = false,
    @SerializedName("retweeted")
    val retweeted: Boolean? = false,
    @SerializedName("possibly_sensitive")
    val possiblySensitive: Boolean? = false,
    @SerializedName("possibly_sensitive_appealable")
    val possiblySensitiveAppealable: Boolean? = false,
    @SerializedName("lang")
    val lang: String? = "",
    @SerializedName("extended_entities")
    val extendedEntities: ExtendedEntities? = ExtendedEntities(),
    @SerializedName("in_reply_to_status_id")
    val inReplyToStatusId: Any? = Any(),
    @SerializedName("in_reply_to_status_id_str")
    val inReplyToStatusIdStr: Any? = Any(),
    @SerializedName("in_reply_to_user_id")
    val inReplyToUserId: Any? = Any(),
    @SerializedName("in_reply_to_user_id_str")
    val inReplyToUserIdStr: Any? = Any(),
    @SerializedName("in_reply_to_screen_name")
    val inReplyToScreenName: Any? = Any(),
    @SerializedName("geo")
    val geo: Any? = Any(),
    @SerializedName("coordinates")
    val coordinates: Any? = Any(),
    @SerializedName("place")
    val place: Any? = Any(),
    @SerializedName("contributors")
    val contributors: Any? = Any()
)