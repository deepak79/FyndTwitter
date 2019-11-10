package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Sizes(
    @SerializedName("thumb")
    val thumb: Thumb = Thumb(),
    @SerializedName("large")
    val large: Large = Large(),
    @SerializedName("medium")
    val medium: Medium = Medium(),
    @SerializedName("small")
    val small: Small = Small()
)