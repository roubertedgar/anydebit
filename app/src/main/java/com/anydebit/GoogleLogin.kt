package com.anydebit

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope

class GoogleLogin(private val activity: LogInActivity) {

    fun login() {
        val signInAccount = getSignInAccount()
        if (signInAccount != null) {
            activity.logged(signInAccount.account)
        } else {
            doLogin()
        }
    }

    private fun doLogin() {
        getClient().silentSignIn().addOnCompleteListener {
            if (it.isSuccessful) {
                activity.logged(it.result?.account)
            } else {
                activity.userNotLogged(getClient().signInIntent)
            }
        }
    }

    private fun getClient(): GoogleSignInClient {
        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(Scope("https://www.googleapis.com/auth/spreadsheets"))
                .requestEmail()
                .build()

        return GoogleSignIn.getClient(activity, signInOptions)
    }

    private fun isLogged() = getSignInAccount() != null

    private fun getSignInAccount() = GoogleSignIn.getLastSignedInAccount(activity)
}
