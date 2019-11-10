package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class LargeX(
    @SerializedName("faces")
    val faces: List<Any>? = listOf()
)