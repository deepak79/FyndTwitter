package go.fynd.twitter.model.tweet


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class TweetsBean(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("pId")
    var pId: Int? = null,
    @SerializedName("id")
    val id: Long? = 0,
    @SerializedName("id_str")
    val idStr: String? = "",
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("user")
    val user: User? = User(),
    @SerializedName("retweet_count")
    val retweetCount: Int? = 0,
    @SerializedName("favorite_count")
    val favoriteCount: Int?= 0
)