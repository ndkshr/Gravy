package com.instance.gravy.di

import androidx.lifecycle.ViewModel
import com.instance.gravy.utils.ViewModelKey
import com.instance.gravy.view.GravyMainActivity
import com.instance.gravy.viewmodel.GravyMainActivityVM
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class GravyModule {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): GravyMainActivity

    @Binds
    @IntoMap
    @ViewModelKey(GravyMainActivityVM::class)
    abstract fun providesMainActivityViewModel(gravyMainActivityVM: GravyMainActivityVM): ViewModel
}
