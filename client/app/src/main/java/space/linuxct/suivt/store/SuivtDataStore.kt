package space.linuxct.suivt.store

import kotlinx.serialization.*
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin

class SuivtDataStore : IDataStore {
    private lateinit var dataStoreScope: Scope
    override fun init(): SuivtDataStore {
        dataStoreScope = getKoin().createScope<SuivtDataStore>()
        val dataStores = dataStoreScope.getAll<IDataStore>()
        for (dataStore in dataStores){
            dataStore.init()
        }
        return this
    }

    override fun <T: Serializable> getFromStore(name: String, default: T): T {
        TODO("Not yet implemented")
    }

    override fun <T: Serializable> setToStore(name: String, value: T, location: DataLocationEnum) {
        TODO("Not yet implemented")
    }

    override fun preferenceStoreDefinedBy() = DataLocationEnum.NONE
}