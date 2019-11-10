package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Medium(
    @SerializedName("w")
    val w: Int = 0,
    @SerializedName("h")
    val h: Int = 0,
    @SerializedName("resize")
    val resize: String = ""
)