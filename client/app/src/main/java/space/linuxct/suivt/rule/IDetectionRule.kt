package space.linuxct.suivt.rule

import space.linuxct.suivt.model.*

interface IDetectionRule {
    fun configureRule(ruleConfigurationModel: RuleConfigurationModel)
    fun isMatch(packageName: String): List<MatchStatusEnum>
    fun getSeverityResult(): SeverityResultEnum
}