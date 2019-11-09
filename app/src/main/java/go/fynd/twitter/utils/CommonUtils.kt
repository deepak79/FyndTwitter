package go.fynd.twitter.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.PermissionChecker.checkSelfPermission
import org.apache.commons.codec.binary.Base64
import java.io.UnsupportedEncodingException
import java.security.GeneralSecurityException
import javax.crypto.Mac
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec


object CommonUtils {

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun canAccessBluetooth(context: Context?): Boolean {
        return if (context == null) {
            false
        } else hasPermission(context, Manifest.permission.BLUETOOTH) && hasPermission(
            context,
            Manifest.permission.BLUETOOTH_ADMIN
        )
    }

    private fun hasPermission(context: Context?, perm: String): Boolean {
        return if (context == null) {
            false
        } else PackageManager.PERMISSION_GRANTED == checkSelfPermission(context, perm)
    }

    fun makeText(context: Context?, message: String) {
        if (context == null) {
            return
        }
        if (context is Activity) {
            if (context.isFinishing) {
                return
            }
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @Throws(GeneralSecurityException::class, UnsupportedEncodingException::class)
    fun computeSignature(baseString: String, keyString: String): String {

        var secretKey: SecretKey? = null

        val keyBytes = keyString.toByteArray()
        secretKey = SecretKeySpec(keyBytes, "HmacSHA1")

        val mac = Mac.getInstance("HmacSHA1")

        mac.init(secretKey)

        val text = baseString.toByteArray()

        return String(Base64.encodeBase64(mac.doFinal(text))).trim { it <= ' ' }
    }

}
