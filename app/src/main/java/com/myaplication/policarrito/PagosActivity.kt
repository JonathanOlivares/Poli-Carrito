package com.myaplication.policarrito

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast
import com.paypal.android.sdk.payments.PayPalConfiguration
import com.paypal.android.sdk.payments.PayPalPayment
import com.paypal.android.sdk.payments.PayPalService
import com.paypal.android.sdk.payments.PaymentActivity
import com.paypal.android.sdk.payments.PaymentActivity.EXTRA_PAYMENT
import com.paypal.android.sdk.payments.PaymentConfirmation
import org.json.JSONException
import org.json.JSONObject
import java.math.BigDecimal


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


        val Correo = findViewById<TextView>(R.id.TeVi_Ac_Mo)

        val montoPago = 100//intent.getStringExtra("monto_pago")

        Correo.setText(montoPago.toString())


        val BotonPago: TextView = findViewById( R.id.paypalButton )

        BotonPago.setOnClickListener {
            getPayment()
        }


    }

    private fun getPayment() {
        val montoPago = intent.getStringExtra("monto_pago")

        val payment = PayPalPayment(
            BigDecimal(montoPago),
            "USD",
            "Code with Arvind",
            PayPalPayment.PAYMENT_INTENT_SALE
        )

        val intent = Intent(this, PaymentActivity::class.java)

        val serviceintent = Intent(this, PayPalService::class.java)
        serviceintent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, configuration)
        startService(serviceintent)


        val paymentIntent = Intent(this, PaymentActivity::class.java)
        paymentIntent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment)

        startActivityForResult(paymentIntent, PAYPAL_REQUEST_CODE)
    }

    override protected fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PAYPAL_REQUEST_CODE) {
            val paymentConfirmation = data?.getParcelableExtra<PaymentConfirmation>(PaymentActivity.EXTRA_RESULT_CONFIRMATION)

            if (paymentConfirmation != null){
                try {
                    val paymentDetails = paymentConfirmation.toJSONObject().toString()
                    val jsonObject = JSONObject(paymentDetails)


                } catch (e: JSONException) {
                    Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            }else if (requestCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }else if (requestCode == PaymentActivity.RESULT_EXTRAS_INVALID){
            Toast.makeText(this, "Invalid Payment", Toast.LENGTH_SHORT).show()
        }
    }
}