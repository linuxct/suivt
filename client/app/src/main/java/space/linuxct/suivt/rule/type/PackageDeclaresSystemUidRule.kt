package space.linuxct.suivt.rule.type

import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.model.SeverityResultEnum
import space.linuxct.suivt.rule.IDetectionRule

class PackageDeclaresSystemUidRule : BaseRule(), IDetectionRule {
    override fun isMatch(packageName: String): List<MatchStatusEnum> {
        TODO("Not yet implemented")
    }

    override fun getSeverityResult(packageName: String): SeverityResultEnum {
        TODO("Not yet implemented")
    }
}