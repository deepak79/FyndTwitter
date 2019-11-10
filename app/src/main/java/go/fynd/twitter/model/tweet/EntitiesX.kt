package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class EntitiesX(
    @SerializedName("url")
    val url: UrlX = UrlX(),
    @SerializedName("description")
    val description: Description = Description()
)