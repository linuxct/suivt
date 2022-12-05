package space.linuxct.suivt.store

import android.content.Context
import kotlinx.serialization.*

class MemoryDataStore(private val context: Context) : IDataStore {
    override fun init(): IDataStore {
        TODO("Not yet implemented")
    }

    override fun <T: Serializable> getFromStore(name: String, default: T): T {
        TODO("Not yet implemented")
    }

    override fun <T: Serializable> setToStore(name: String, value: T, location: DataLocationEnum) {
        TODO("Not yet implemented")
    }

    override fun preferenceStoreDefinedBy() = DataLocationEnum.IN_MEMORY
}