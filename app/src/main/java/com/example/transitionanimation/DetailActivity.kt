package com.example.transitionanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        back.setOnClickListener{
          //  finish()
            finishAfterTransition()
           // overridePendingTransition(R.anim.right_enter_anim,R.anim.right_exit_anim)
           // overridePendingTransition(R.anim.alpha_enter_anim,R.anim.alpha_exit_anim)

        }
    }
}
