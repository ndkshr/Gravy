package com.instance.gravy.di

import com.instance.gravy.view.AddNotesActivity
import com.instance.gravy.view.GravyMainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GravyActivitiesModule {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): GravyMainActivity

    @ContributesAndroidInjector()
    abstract fun contributeAddNotesActivity(): AddNotesActivity
}
