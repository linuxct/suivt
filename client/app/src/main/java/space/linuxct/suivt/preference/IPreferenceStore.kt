package space.linuxct.suivt.preference

import android.content.Context

interface IPreferenceStore {
    fun init(context: Context): IPreferenceStore
    fun <T> getFromStore(name: String, default: T): T
    fun <T> setToStore(name: String, value: T, location: PreferenceLocationEnum)
}