package space.linuxct.suivt.rule

import org.jetbrains.annotations.TestOnly
import org.koin.java.KoinJavaComponent.getKoin
import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.model.RuleConfigurationModel
import space.linuxct.suivt.model.SeverityResultEnum
import space.linuxct.suivt.rule.type.BaseRule
import space.linuxct.suivt.rule.type.PackageIsUserOrSystemRule

class RuleEngine {
    fun warmUp(config: List<RuleConfigurationModel>){
        val ruleList = getKoin().getAll<BaseRule>()

        for (rule in ruleList){
            if (!rule.isConfigurationModelInitialized()){
                config.find { it.ruleName == rule.javaClass.simpleName }.run {
                    this?.let { it -> rule.configureRule(it) }
                }
            }
        }
    }

    @TestOnly
    fun testFirstRule(){
        warmUp(listOf(RuleConfigurationModel(
            order = 1,
            ruleName = "PackageIsUserOrSystemRule",
            actions = listOf(MatchStatusEnum.PASS_TO_NEXT_STAGE),
            severity = SeverityResultEnum.LOW
        )))

        val instance = getKoin().get<PackageIsUserOrSystemRule>()
        instance.configureRule(RuleConfigurationModel(
            order = 1,
            ruleName = "PackageIsUserOrSystemRule",
            actions = listOf(MatchStatusEnum.PASS_TO_NEXT_STAGE),
            severity = SeverityResultEnum.LOW
        ))
        assert(instance.isMatch("com.android.settings").contains(MatchStatusEnum.NOT_MATCH))
        assert(!instance.isMatch("space.linuxct.suivt").contains(MatchStatusEnum.NOT_MATCH))
        assert(instance.isMatch("space.linuxct.suivt").contains(MatchStatusEnum.PASS_TO_NEXT_STAGE))
    }

    @TestOnly
    fun testAgainFirstRule(){
        val instance = getKoin().get<PackageIsUserOrSystemRule>()
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