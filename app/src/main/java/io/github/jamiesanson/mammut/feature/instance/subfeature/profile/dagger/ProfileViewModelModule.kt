package io.github.jamiesanson.mammut.feature.instance.subfeature.profile.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.jamiesanson.mammut.dagger.MammutViewModelFactory
import io.github.jamiesanson.mammut.dagger.ViewModelKey
import io.github.jamiesanson.mammut.feature.instance.subfeature.feed.FeedViewModel
import io.github.jamiesanson.mammut.feature.instance.subfeature.profile.ProfileViewModel
import io.github.jamiesanson.mammut.feature.instance.subfeature.profile.dagger.ProfileScope

@Module
abstract class ProfileViewModelModule {

    @Binds
    @IntoMap
    @ProfileScope
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @ProfileScope
    abstract fun bindViewModelFactory(factory: MammutViewModelFactory): ViewModelProvider.Factory
}