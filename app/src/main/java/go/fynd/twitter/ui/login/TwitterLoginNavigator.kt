package go.fynd.twitter.ui.login

import go.fynd.twitter.model.UserBean

interface TwitterLoginNavigator {
    fun onHandleError(error: String)
}
