package com.instance.gravy

import com.instance.gravy.di.AppComponent
import com.instance.gravy.di.DaggerAppComponent

class GravyTestApplication : GravyApplication() {

    override fun getComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .application(this)
            .baseUrl("http://localhost:8080/")
            .build()
    }
}
