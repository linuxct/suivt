package space.linuxct.suivt

import android.app.Application
import android.content.pm.PackageManager
import space.linuxct.suivt.preference.SuivtPreferenceStore

class SuivtApplication : Application() {
    companion object {
        @JvmStatic lateinit var preferenceStore: SuivtPreferenceStore
        @JvmStatic lateinit var instance: SuivtApplication
    }

    override fun onCreate() {
        preferenceStore = SuivtPreferenceStore().init(context=this)
        instance = this
        super.onCreate()
    }
}