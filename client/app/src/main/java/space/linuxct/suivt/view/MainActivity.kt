package space.linuxct.suivt.view

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import space.linuxct.suivt.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ip = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
        for (item in ip){
            // This application follows 5 simple rules
            // 1. If the application has been installed as a user application, it is considered for the next step
            item.applicationInfo.flags // https://stackoverflow.com/a/23599701
            // 2. If the package is signed by one of the known leaked certificate hashes, the package is considered for flagging purposes

            // 3. If the shared user id starts with "android.uid.", the package is considered for flagging purposes
            var res = if (item.sharedUserId == "" || item.sharedUserId == null) "none reported" else item.sharedUserId
            // 4. If the package is not installed from a trustable source (com.android.vending or Samsung Galaxy Store), it is flagged as possible malware

            // 5. If the downloaded application is not an update to an already existing system application, it is flagged as possible malware with high risk

            Log.i("LINUXCT", res)
            Log.i("LINUXCT", "item.applicationInfo.flags")
        }
    }
}