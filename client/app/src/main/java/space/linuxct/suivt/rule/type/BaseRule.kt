package space.linuxct.suivt.rule.type

import android.content.pm.PackageManager
import space.linuxct.suivt.SuivtApplication
import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.model.RuleConfigurationModel
import space.linuxct.suivt.model.SeverityResultEnum
import space.linuxct.suivt.rule.IDetectionRule

abstract class BaseRule : IDetectionRule {
    override fun configureRule(ruleConfigurationModel: RuleConfigurationModel) {
        configurationModel = ruleConfigurationModel
    }

    override fun getSeverityResult(): SeverityResultEnum {
        return configurationModel.severity
    }

    companion object {
        @JvmStatic var packageManager: PackageManager = SuivtApplication.instance.packageManager
        internal lateinit var configurationModel: RuleConfigurationModel
    }
}