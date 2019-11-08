package go.fynd.twitter.ui.detail

import go.fynd.twitter.model.UserBean

interface DetailNavigator {
    fun onHandleError(error: String)

    fun onDeleteClicked()

    fun onDelete(mUserBean: UserBean)

    fun onDeleted()
}
