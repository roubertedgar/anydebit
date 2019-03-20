package com.anydebit

import android.accounts.Account
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException

const val LOGIN_ACTIVITY_REQUEST_CODE = 123

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val googleLogin = GoogleLogin(this)
        googleLogin.login()
    }


    fun logged(account: Account?) {
        account?.also {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun userNotLogged(signInIntent: Intent) {
        startActivityForResult(signInIntent, LOGIN_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == LOGIN_ACTIVITY_REQUEST_CODE) {
            try {
                val account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException::class.java)?.account
                logged(account)
            } catch (e: ApiException) {
                Log.w("MyActivity", "signInResult: failed code=" + e.statusCode + ", reason: " + GoogleSignInStatusCodes.getStatusCodeString(e.statusCode), e)
            }
        }
    }

}
