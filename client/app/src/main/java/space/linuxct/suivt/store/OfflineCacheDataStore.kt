package space.linuxct.suivt.store

import android.content.Context
import android.util.Log
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.IOException

class OfflineCacheDataStore(private val context: Context) : IDataStore {
    override fun init(): OfflineCacheDataStore {
        TODO("Not yet implemented")
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun <T: Serializable> getFromStore(name: String, default: T): T {
        val modelAsString: String
        try {
            val inputStream = context.assets.open(name)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            modelAsString = String(buffer)
        } catch (e:Exception) {
            Log.d(this.javaClass.simpleName, "getFromStore: Impossible to get asset file")
            return default
        }

        //serializer(default.javaClass::class.javaObjectType)
        //var result = Json.decodeFromString<T>(serializer(default.javaClass::class.javaObjectType), modelAsString)

        return default
    }

    override fun <T: Serializable> setToStore(name: String, value: T, location: DataLocationEnum) {
        throw IOException("Impossible to write to Offline Cache!")
    }

    override fun preferenceStoreDefinedBy() = DataLocationEnum.OFFLINE_CACHE
}