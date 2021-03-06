package io.github.koss.mammut.dagger.application

import dagger.Component
import io.github.koss.mammut.MammutApplication
import io.github.koss.mammut.base.dagger.scope.ApplicationScope
import io.github.koss.mammut.dagger.module.ApplicationModule
import io.github.koss.mammut.dagger.module.NetworkModule
import io.github.koss.mammut.dagger.module.RepositoryModule
import io.github.koss.mammut.dagger.module.WorkerModule
import io.github.koss.mammut.feature.multiinstance.MultiInstanceActivity
import io.github.koss.mammut.feature.multiinstance.MultiInstanceFragment
import io.github.koss.mammut.feature.instance.dagger.InstanceComponent
import io.github.koss.mammut.feature.instance.dagger.InstanceModule
import io.github.koss.mammut.feature.joininstance.dagger.JoinInstanceComponent
import io.github.koss.mammut.feature.joininstance.dagger.JoinInstanceModule
import io.github.koss.mammut.feature.pending.PendingWorkFragment
import io.github.koss.mammut.feature.settings.dagger.SettingsComponent
import io.github.koss.mammut.feature.settings.dagger.SettingsModule
import io.github.koss.mammut.feature.splash.SplashActivity
import io.github.koss.mammut.toot.dagger.ComposeTootComponent
import io.github.koss.mammut.toot.dagger.ComposeTootModule

@ApplicationScope
@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    WorkerModule::class
])
interface ApplicationComponent {

    fun inject(application: MammutApplication)

    fun inject(activity: SplashActivity)

    fun inject(activity: MultiInstanceActivity)

    fun inject(fragment: MultiInstanceFragment)

    fun inject(fragment: PendingWorkFragment)

    fun plus(joinInstanceModule: JoinInstanceModule): JoinInstanceComponent

    fun plus(instanceModule: InstanceModule): InstanceComponent

    fun plus(settingsModule: SettingsModule): SettingsComponent

    fun plus(composeTootModule: ComposeTootModule): ComposeTootComponent
}