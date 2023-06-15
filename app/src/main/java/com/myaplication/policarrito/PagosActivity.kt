package com.myaplication.policarrito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paypal.checkout.PayPalCheckout
import com.paypal.checkout.config.CheckoutConfig
import com.paypal.checkout.config.Environment
import com.paypal.checkout.config.SettingsConfig
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.UserAction
import com.paypal.pyplcheckout.BuildConfig

class PagosActivity : AppCompatActivity() {


    paypalbutton Btn_Paypal


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagos)


        val YOUR_CLIENT_ID = ""

        val config = CheckoutConfig(
            application = application,
            clientId = YOUR_CLIENT_ID,
            environment = Environment.SANDBOX,
            returnUrl = "${"com.myaplication.policarrito"}://paypalpay",
            currencyCode = CurrencyCode.USD,
            userAction = UserAction.PAY_NOW,
            settingsConfig = SettingsConfig(
                loggingEnabled = true,
                showWebCheckout = false
            )
        )
        PayPalCheckout.setConfig(config)
    }
}