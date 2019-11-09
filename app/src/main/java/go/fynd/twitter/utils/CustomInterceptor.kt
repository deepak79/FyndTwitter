package go.fynd.twitter.utils

import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.SigningInterceptor

class CustomInterceptor {
    companion object {
        lateinit var mSingInterceptor: SigningInterceptor

        fun setSignInterceptor(
            consumerKey: String,
            consumerSecret: String,
            accessToken: String,
            userSecret: String
        ) {
            val consumer = OkHttpOAuthConsumer(consumerKey, consumerSecret)
            consumer.setTokenWithSecret(accessToken, userSecret)
            mSingInterceptor = SigningInterceptor(consumer)
        }
    }
}