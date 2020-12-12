package com.instance.gravy.di

import com.instance.gravy.GravyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        GravyModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: GravyApplication): Builder

        @BindsInstance
        fun baseUrl(@Named("baseUrl") baseUrl: String): Builder
    }

    fun inject(application: GravyApplication)
}
