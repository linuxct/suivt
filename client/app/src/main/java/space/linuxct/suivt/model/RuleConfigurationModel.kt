package space.linuxct.suivt.model

data class RuleConfigurationModel(
    var order: Int,
    var ruleName: String,
    var actions: List<MatchStatusEnum>,
    var severity: SeverityResultEnum
)