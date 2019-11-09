package go.fynd.twitter.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class UserBean(
    @PrimaryKey(autoGenerate = true)
    var pId: Int? = null,
    @SerializedName("user_id")
    var mUserId: String? = null,
    @SerializedName("access_token")
    var mAccessToken: String? = null,
    @SerializedName("secret_key")
    var mSecretKey: String? = null,
    @SerializedName("name")
    var mName: String? = null,
    @SerializedName("screen_name")
    var mScreenName: String? = null,
    @SerializedName("email")
    var mEmail: String? = null,
    @SerializedName("profile_image")
    var mProfileImage: String? = null,
    @SerializedName("followers_count")
    var mFollowersCount: Int? = null
) : Parcelable