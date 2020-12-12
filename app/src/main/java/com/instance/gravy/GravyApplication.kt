package com.instance.gravy

import android.app.Activity
import android.app.Application
import com.instance.gravy.di.AppComponent
import com.instance.gravy.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class GravyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    private lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        getComponent().inject(this)
    }

    open fun getComponent(): AppComponent {
        if (!this::applicationComponent.isInitialized) {
            applicationComponent = DaggerAppComponent.builder()
                .application(this)
                .baseUrl("https://api.apixu.com")
                .build()
        }
        return applicationComponent
    }
}
