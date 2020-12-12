package com.instance.gravy.di

import androidx.lifecycle.ViewModelProvider
import com.instance.gravy.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}