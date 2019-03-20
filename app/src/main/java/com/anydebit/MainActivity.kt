package com.anydebit

import android.accounts.Account
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.model.Spreadsheet
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.balance_card_view.*
import java.io.IOException
import java.util.concurrent.Executor


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }




//        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestScopes(Scope("https://www.googleapis.com/auth/spreadsheets"))
//                .requestEmail()
//                .build()
//
//        val client = GoogleSignIn.getClient(this, signInOptions)
//
//        if (GoogleSignIn.getLastSignedInAccount(this) == null) {
//            startActivityForResult(client.signInIntent, 204)
//        } else {
//            val account = GoogleSignIn.getLastSignedInAccount(this)?.account
//            openSheets(account)
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 204) {
//            try {
//                val account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException::class.java)?.account
//                openSheets(account)
//            } catch (e: ApiException) {
//                Log.w("MyActivity", "signInResult: failed code=" + e.statusCode + ", reason: " + GoogleSignInStatusCodes.getStatusCodeString(e.statusCode), e)
//            }
//
//        }
//    }
//
//    @SuppressLint("CheckResult")
//    private fun openSheets(account: Account?) {
//        val credentials = GoogleAccountCredential.usingOAuth2(baseContext, listOf("https://www.googleapis.com/auth/spreadsheets"))
//        credentials.selectedAccount = account
//        val sheetsService = Sheets.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), credentials).build()
//        try {
//
//            Observable.create<Spreadsheet> {
//                val spreadsheet=sheetsService.spreadsheets().get("1acB5YdQ0IncHrGMTjpirAboEVaY_VTSMi9GoATuWJd4").setRanges(listOf("B15")).execute()
//                it.onNext(spreadsheet)
//            }.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                       List<List<Object>> values = response.getValues();
//        if (values == null || values.isEmpty()) {
//            System.out.println("No data found.");
//        } else {
//            System.out.println("Name, Major");
//            for (List row : values) {
//                // Print columns A and E, which correspond to indices 0 and 4.
//                System.out.printf("%s, %s\n", row.get(0), row.get(4));
//            }
//        }
//                    }
//
//
//
//        } catch (ex: UserRecoverableAuthIOException) {
//            startActivity(ex.intent)
//        } catch (e: IOException) {
//            Log.e("Main Activity", "failure to get spreadsheet: " + e.message, e)
//        }
//    }

}
