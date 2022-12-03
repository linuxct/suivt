package space.linuxct.suivt.rule.type

import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.model.SeverityResultEnum
import space.linuxct.suivt.rule.IDetectionRule

class PackageIsInstalledFromTrustedSourceRule : IDetectionRule {
    override fun isMatch(packageName: String): MatchStatusEnum {
        TODO("Not yet implemented")
    }

    override fun getSeverityResult(packageName: String): SeverityResultEnum {
        TODO("Not yet implemented")
    }
}