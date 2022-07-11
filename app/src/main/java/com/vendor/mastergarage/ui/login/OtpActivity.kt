package com.vendor.mastergarage.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.vendor.mastergarage.R
import com.vendor.mastergarage.databinding.ActivityOtpBinding
import com.vendor.mastergarage.networkcall.Response
import com.vendor.mastergarage.ui.mainactivity.MainActivity
import com.vendor.mastergarage.uidesign.AwaitingConfirmationFragment
import com.vendor.mastergarage.uidesign.AwaitingCustomerConfirmationFragment
import dagger.hilt.android.AndroidEntryPoint

//step 7-
@AndroidEntryPoint
class OtpActivity : AppCompatActivity() {

    //step 6
    private val viewModel : LoginViewModel by viewModels()


    private lateinit var binding : ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_otp)
       binding.btnSubmit.setOnClickListener {
           if(binding.phoneNo.text.toString().equals("")){
               LoginActivity.showToast("Please Enter the Phone Number", this)
               return@setOnClickListener
           }else{
         //step 8 ,,, call viewmodel class method
               viewModel.signinotp(
                   intent.getStringExtra("mobile")!!,
                   binding.phoneNo.text.toString()
               )
           }
       }

        //step 9 ..call viewmodel livedata variable
        viewModel.signinotpData.observe(this, Observer {
            when (it) {
                is Response.Success -> {
                    val userItem = it.data
                    if (userItem != null) {
                        if(userItem.success == "success")
                        {
                            Toast.makeText(this , userItem.message , Toast.LENGTH_LONG).show()
                            startActivity(Intent(this , MainActivity::class.java))
                        }
                        else
                        {
                            //otp
                                //if otp is not correct
                            Toast.makeText(this , userItem.message , Toast.LENGTH_LONG).show()
                        }


                    }
                }
                is Response.Failure -> {
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT)
                        .show()
                    Log.e("LoginActivity.TAG", it.errorMessage.toString())
                }
            }
        })


    }
}