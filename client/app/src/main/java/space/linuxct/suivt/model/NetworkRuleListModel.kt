package space.linuxct.suivt.model

import kotlinx.serialization.*

@Serializable
data class NetworkRuleListModel(var rulesConfiguration: List<NetworkRuleConfigurationModel>)