package space.linuxct.suivt.store

import kotlinx.serialization.*

interface IDataStore {
    fun init(): IDataStore
    fun <T:Serializable> getFromStore(name: String, default: T): T
    fun <T:Serializable> setToStore(name: String, value: T, location: DataLocationEnum)
    fun preferenceStoreDefinedBy(): DataLocationEnum
}