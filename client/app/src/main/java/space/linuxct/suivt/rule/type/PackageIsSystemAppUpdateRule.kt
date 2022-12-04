package space.linuxct.suivt.rule.type

import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.rule.IDetectionRule

class PackageIsSystemAppUpdateRule : BaseRule(), IDetectionRule {
    override fun isMatch(packageName: String): List<MatchStatusEnum> {
        TODO("Not yet implemented")
    }
}