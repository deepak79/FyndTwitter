package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class EntitiesXXX(
    @SerializedName("url")
    val url: UrlXXXX = UrlXXXX(),
    @SerializedName("description")
    val description: DescriptionX = DescriptionX()
)