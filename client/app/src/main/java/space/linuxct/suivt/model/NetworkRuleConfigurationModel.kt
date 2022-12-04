package space.linuxct.suivt.model

data class NetworkRuleConfigurationModel (
    var order: Int,
    var ruleName: String,
    var actions: List<String>,
    var severity: String
)