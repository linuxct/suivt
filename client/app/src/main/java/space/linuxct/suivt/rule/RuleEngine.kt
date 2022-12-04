package space.linuxct.suivt.rule

import org.jetbrains.annotations.TestOnly
import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.model.RuleConfigurationModel
import space.linuxct.suivt.model.SeverityResultEnum
import space.linuxct.suivt.rule.type.PackageIsUserOrSystemRule

class RuleEngine {
    @TestOnly
    fun testFirstRule(){
        val instance = PackageIsUserOrSystemRule()
        instance.configureRule(RuleConfigurationModel(
            order = 1,
            ruleName = "PackageIsUserOrSystemRule",
            actions = listOf(MatchStatusEnum.PASS_TO_NEXT_STAGE),
            severity = SeverityResultEnum.LOW
        ))
        assert(instance.isMatch("com.android.settings").contains(MatchStatusEnum.NOT_MATCH))
        assert(!instance.isMatch("space.linuxct.suivt").contains(MatchStatusEnum.NOT_MATCH))
        assert(instance.isMatch("space.linuxct.suivt").contains(MatchStatusEnum.PASS_TO_NEXT_STAGE))
        return
    }
}