package space.linuxct.suivt.rule.type

import android.content.pm.PackageManager
import space.linuxct.suivt.SuivtApplication
import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.rule.IDetectionRule

abstract class BaseRule : IDetectionRule {
    companion object {
        @JvmStatic var packageManager: PackageManager = SuivtApplication.instance.packageManager
    }
}