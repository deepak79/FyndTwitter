package go.fynd.twitter.ui.main

import go.fynd.twitter.model.UserBean

interface MainNavigator {
    fun onHandleError(error: String)

    fun loadAllUsers()

    fun onAddUserClick()

    fun onAddUser(userBean: UserBean)
}
