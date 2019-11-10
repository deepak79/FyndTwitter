package go.fynd.twitter.model.tweet


import com.google.gson.annotations.SerializedName

data class Features(
    @SerializedName("all")
    val all: All = All(),
    @SerializedName("large")
    val large: LargeX = LargeX(),
    @SerializedName("medium")
    val medium: MediumX = MediumX(),
    @SerializedName("small")
    val small: SmallX = SmallX(),
    @SerializedName("orig")
    val orig: Orig = Orig()
)