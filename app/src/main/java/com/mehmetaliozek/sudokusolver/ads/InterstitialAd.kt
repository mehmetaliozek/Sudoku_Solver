package com.mehmetaliozek.sudokusolver.ads

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

object InterstitialAdManager {
    private var interstitialAd: InterstitialAd? = null
    private var isAdLoaded = false

    fun loadAd(context: Context) {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            context,
            AdUnitId.INTERSTITIAL_AD,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    isAdLoaded = true

                    // Reklamın kapanıp kapanmadığını dinleyen FullScreenContentCallback ekleniyor
                    interstitialAd?.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                isAdLoaded = false
                                loadAd(context)
                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                                isAdLoaded = false
                            }

                            override fun onAdShowedFullScreenContent() {
                                interstitialAd = null
                            }
                        }

                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    interstitialAd = null
                    isAdLoaded = false
                }
            }
        )
    }

    fun showAd(context: Context) {
        if (isAdLoaded && interstitialAd != null) {
            interstitialAd?.show(context as Activity)
        }
    }
}