package space.linuxct.suivt.preference

import android.content.Context

class MemoryPreferenceStore : IPreferenceStore {
    override fun init(context: Context): IPreferenceStore {
        TODO("Not yet implemented")
    }

    override fun <T> getFromStore(name: String, default: T): T {
        TODO("Not yet implemented")
    }

    override fun <T> setToStore(name: String, value: T, location: PreferenceLocationEnum) {
        TODO("Not yet implemented")
    }
}