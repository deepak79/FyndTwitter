package go.fynd.twitter.utils

import android.Manifest

class AppConstants {
    companion object {
        const val DB_NAME = "FYNDTWITTER.db"
        const val NULL_INDEX = -1L
        const val IMAGE_PLACEHOLDER = "https://via.placeholder.com/30"
        val PERMISSIONS = arrayOf(
            Manifest.permission.INTERNET
        )
    }
}
