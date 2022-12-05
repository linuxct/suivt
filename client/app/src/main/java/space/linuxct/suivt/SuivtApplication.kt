package space.linuxct.suivt

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import space.linuxct.suivt.store.*
import space.linuxct.suivt.rule.RuleEngine
import space.linuxct.suivt.rule.type.*

class SuivtApplication : MultiDexApplication() {
    companion object {
        @JvmStatic lateinit var instance: SuivtApplication
    }

    private val appModules = listOf(
        module {
            single { RuleEngine() }
            factory { PackageDeclaresSystemUidRule() } bind BaseRule::class
            factory { PackageIsInstalledFromTrustedSourceRule() } bind BaseRule::class
            factory { PackageIsSignedWithPlatformKeysRule() } bind BaseRule::class
            factory { PackageIsSystemAppUpdateRule() } bind BaseRule::class
            factory { PackageIsUserOrSystemRule() } bind BaseRule::class
        },
        //ToDo: Test if the new module declaration works
        module {
            single { SuivtDataStore() } bind IDataStore::class
            scope<SuivtDataStore> {
                scoped { SharedPreferenceDataStore(get()) } bind IDataStore::class
                scoped { MemoryDataStore(get()) } bind IDataStore::class
                scoped { OfflineCacheDataStore(get()) } bind IDataStore::class
            }
        }
    )

    override fun onCreate() {
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