package space.linuxct.suivt.rule

import space.linuxct.suivt.model.*

interface IDetectionRule {
    fun isMatch(packageName: String): List<MatchStatusEnum>
    fun getSeverityResult(packageName: String): SeverityResultEnum
}