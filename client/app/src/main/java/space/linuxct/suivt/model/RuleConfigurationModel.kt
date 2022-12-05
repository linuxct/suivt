package space.linuxct.suivt.model

import kotlinx.serialization.*

@Serializable
data class RuleConfigurationModel(
    var order: Int,
    var ruleName: String,
    var actions: List<MatchStatusEnum>,
    var severity: SeverityResultEnum
)