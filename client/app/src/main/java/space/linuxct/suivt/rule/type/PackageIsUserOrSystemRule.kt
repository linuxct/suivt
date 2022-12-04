package space.linuxct.suivt.rule.type

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import space.linuxct.suivt.model.MatchStatusEnum
import space.linuxct.suivt.rule.IDetectionRule

class PackageIsUserOrSystemRule : BaseRule(), IDetectionRule {
    override fun isMatch(packageName: String): List<MatchStatusEnum> {
        var result = true
        val packages = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
        val appInfo = packages.first {
            it.packageName == packageName
        }.applicationInfo

        // If the application is a system application, skip it...
        if ((appInfo.flags and ApplicationInfo.FLAG_SYSTEM) > 0){
            result = false
        }

        // ... unless it has been installed as an updated system application
        if (appInfo.flags and ApplicationInfo.FLAG_UPDATED_SYSTEM_APP > 0){
            result = true
        }

        return if (result){
            configurationModel.actions
        } else {
            listOf(MatchStatusEnum.NOT_MATCH)
        }
    }
}