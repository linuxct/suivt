package space.linuxct.suivt

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import space.linuxct.suivt.preference.SuivtPreferenceStore
import space.linuxct.suivt.rule.RuleEngine
import space.linuxct.suivt.rule.type.BaseRule
import space.linuxct.suivt.rule.type.PackageDeclaresSystemUidRule
import space.linuxct.suivt.rule.type.PackageIsUserOrSystemRule

class SuivtApplication : MultiDexApplication() {
    companion object {
        @JvmStatic lateinit var preferenceStore: SuivtPreferenceStore
        @JvmStatic lateinit var instance: SuivtApplication
    }

    private val appModules = listOf(
        module {
            single { RuleEngine() }
            factoryOf<PackageIsUserOrSystemRule> {
                PackageIsUserOrSystemRule()
            } bind BaseRule::class
            factoryOf<PackageDeclaresSystemUidRule> {
                PackageDeclaresSystemUidRule()
            } bind BaseRule::class
        }
    )

    override fun onCreate() {
        preferenceStore = SuivtPreferenceStore().init(context=this)
        instance = this
        super.onCreate()

        startKoin {
            androidLogger()
            // Reference Android context
            androidContext(this@SuivtApplication)
            // Load modules
            modules(appModules)
        }
    }
}