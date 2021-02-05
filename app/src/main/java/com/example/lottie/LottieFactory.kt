package com.example.lottie

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieListener

class LottieFactory {
    companion object {
        interface LottieFactoryCallback {
            fun lottieUpdateListener(valueAnimator: ValueAnimator?)
            fun lottieAnimationStartListener(animation: Animator?)
            fun lottieAnimationEndListener(animation: Animator?)
            fun lottieAnimationCancelListener(animation: Animator?)
            fun lottieAnimationRepeatListener(animation: Animator?)

        }

        fun from(
            lottieAnimationView: LottieAnimationView,
            fileName: String,
            context: Context,
            lottieFaceCallback: LottieFactoryCallback
        ): LottieAnimationView {
            LottieCompositionFactory.fromAsset(context, fileName).addListener(LottieListener {
                lottieAnimationView.setComposition(it)
            })
            lottieAnimationView.addAnimatorUpdateListener {
                lottieFaceCallback.lottieUpdateListener(it)
            }
            lottieAnimationView.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                    lottieFaceCallback.lottieAnimationStartListener(animation)
                }

                override fun onAnimationEnd(animation: Animator?) {
                    lottieFaceCallback.lottieAnimationEndListener(animation)
                }

                override fun onAnimationCancel(animation: Animator?) {
                    lottieFaceCallback.lottieAnimationCancelListener(animation)
                }

                override fun onAnimationRepeat(animation: Animator?) {
                    lottieFaceCallback.lottieAnimationRepeatListener(animation)
                }
            })
            return lottieAnimationView
        }
    }
}