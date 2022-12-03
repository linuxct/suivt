package space.linuxct.suivt.preference

import android.content.Context

class SuivtPreferenceStore : IPreferenceStore {
    override fun init(context: Context): SuivtPreferenceStore {
        //TODO initialize MemoryPreferenceStore and SharedPreferenceStore
        return this
    }

    override fun <T> getFromStore(name: String, default: T): T {
        TODO("Not yet implemented")
    }

    override fun <T> setToStore(name: String, value: T, location: PreferenceLocationEnum) {
        TODO("Not yet implemented")
    }
}