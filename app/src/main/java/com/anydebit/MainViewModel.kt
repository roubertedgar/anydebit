package com.anydebit

import android.accounts.Account
import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.model.ValueRange
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//class MainViewModel constructor(val context: Context) {
//
//    @SuppressLint("CheckResult")
//    private fun openSheets(account: Account?): LiveData<Balance> {
//
//        val credentials = GoogleAccountCredential.usingOAuth2(context, listOf("https://www.googleapis.com/auth/spreadsheets"))
//        credentials.selectedAccount = account
//        val sheetsService = Sheets.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), credentials).build()
//        Observable.create<ValueRange> {
//            val values = sheetsService.spreadsheets()
//                    .values()
//                    .get("1acB5YdQ0IncHrGMTjpirAboEVaY_VTSMi9GoATuWJd4", "B15").execute()
//
//            it.onNext(values)
//        }.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    if (it.isEmpty()) {
//                        System.out.println("No data found.")
//                    } else {
//                        System.out.println("Name, Major")
//                        it.forEach { entry ->
//                            print(entry.value)
//                        }
//                    }
//                }
//}