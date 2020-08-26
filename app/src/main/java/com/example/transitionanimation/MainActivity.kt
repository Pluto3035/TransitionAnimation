package com.example.transitionanimation

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import android.util.Pair
import android.view.Gravity
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Explode Slide Fade  伴随共享元素一起使用
        //window设置的是除了共享元素之外的所有控件的动画
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.exitTransition = Slide(Gravity.END).setDuration(1000)
        window.enterTransition= Slide(Gravity.END).setDuration(1000)

        setContentView(R.layout.activity_main)

        next.setOnClickListener {
            //A  从右边移动到最左边 然后消失
            //B  从右边出现 移动到最左边
          //  startActivity(Intent(this,DetailActivity::class.java))
            //添加切换的动画
           // overridePendingTransition(R.anim.left_enter_anim,R.anim.left_exit_anim)
           // overridePendingTransition(R.anim.botton_enter_anim,R.anim.top_exit_anim)
           // overridePendingTransition(R.anim.alpha_enter_anim,R.anim.alpha_exit_anim)

            /**
             界面切换时  需要有共享元素切换效果
             1.在界面A和B中 为共享控件设置相同的transitionName
             2.创建ActivityOptions对象
             3.启动界面
             */
          val options=
                ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair<View,String>(imageView,"picture1"),
                    Pair<View,String>(imageView2,"picture2")
                    )

        /**
            val options = ActivityOptions.makeScaleUpAnimation(
            imageView,0,0,imageView.width,imageView.height
        )
            */
            startActivity(Intent(this,DetailActivity::class.java),options.toBundle())

        }
    }
}
