package go.fynd.twitter.utils

import android.app.Dialog
import go.fynd.twitter.model.UserBean

interface CallBack {
    fun onAdd(dialog : Dialog,UserBean: UserBean)

    fun onCancel(dialog : Dialog)
}