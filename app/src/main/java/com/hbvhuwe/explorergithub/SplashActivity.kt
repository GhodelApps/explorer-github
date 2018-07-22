package com.hbvhuwe.explorergithub

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)

        val credentials = (application as App).loadCredentials()

        if (!credentials.isEmpty()) {
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra(Const.USER_KEY, Const.LOGGED_IN_KEY)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
