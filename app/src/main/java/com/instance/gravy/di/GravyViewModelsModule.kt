package com.instance.gravy.di

import androidx.lifecycle.ViewModel
import com.instance.gravy.utils.ViewModelKey
import com.instance.gravy.viewmodel.AddTaskViewModel
import com.instance.gravy.viewmodel.GravyMainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GravyViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(GravyMainViewModel::class)
    abstract fun providesMainActivityViewModel(viewModel: GravyMainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddTaskViewModel::class)
    abstract fun providesAddNotesViewModel(viewModel: AddTaskViewModel): ViewModel
}