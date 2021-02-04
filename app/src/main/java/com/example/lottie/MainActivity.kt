package com.example.lottie

import android.animation.Animator
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieListener
import com.airbnb.lottie.OnCompositionLoadedListener

class MainActivity : AppCompatActivity() {
    var lottieAnimationView:LottieAnimationView?=null
    var heart:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lottieAnimationView = findViewById(R.id.lottie_layer_animation)

        //给lottie设置json动画文件
        LottieCompositionFactory.fromAsset(this,"love.json").addListener(LottieListener {
            lottieAnimationView?.setComposition(it)
        })
        //给lottie设置各种监听
        lottieAnimationView?.addAnimatorUpdateListener {
        }
        lottieAnimationView?.addAnimatorListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

        })
        //初始化lottie的各种参数
        lottieAnimationView?.progress=0f
        lottieAnimationView?.visibility=View.VISIBLE
        lottieAnimationView?.frame=100//默认放在最后一帧
        lottieAnimationView?.speed=3f
        //给lottie设置监听
        lottieAnimationView?.setOnClickListener(View.OnClickListener {
            lottieAnimationView?.playAnimation()
        })
    }
}