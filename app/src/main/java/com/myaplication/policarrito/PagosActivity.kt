package com.myaplication.policarrito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.paypal.android.sdk.payments.PayPalConfiguration


class PagosActivity : AppCompatActivity() {

    val clientId = "Ad_6ZowlQp3Hk6958jRiC4bbD1MTGwd8YHnvvMTiuiw81X7_uApbUakrHIZT2JguGD92QGKkZJpFIxuC"

    val PAYPAL_REQUEST_CODE = 123

    var configuration: PayPalConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagos)

        configuration = PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(clientId)

        //val edtAmount = findViewById<TextView>(R.id.TeVi_MontoPago)


    }
}