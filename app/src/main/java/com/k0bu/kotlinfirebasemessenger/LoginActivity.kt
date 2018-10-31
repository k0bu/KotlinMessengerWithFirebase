package com.k0bu.kotlinfirebasemessenger

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener{
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()

            Log.d("Login","Attempt login with email/pw: $email/***")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{
                    if(!it.isSuccessful) return@addOnCompleteListener
                    //if successful
                    Log.d("Login","Successfully logged in with uid: ${it.result.user.uid}")
                    val intent = Intent(this, LatestMessagesActivity::class.java)
                    startActivity(intent)
                }.addOnFailureListener{
                    Log.d("Login","Failed to log in: ${it.message}")
                }

        }


        back_to_register_text_view.setOnClickListener {
            finish()
        }

    }
}