package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class DescriptionX(
    @SerializedName("urls")
    val urls: List<Any> = listOf()
)