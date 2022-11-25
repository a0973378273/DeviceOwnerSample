package bean.sample.deviceownersample

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestDeviceAdmin()
    }

    private fun requestDeviceAdmin(){
        val deviceAdminComponent = ComponentName(this, DeviceAdminSample::class.java)
        Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
            putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, deviceAdminComponent)
            putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "DEVICE_ADMIN_ADD_EXPLANATION")
        }.run {
            startActivity(this)
        }
    }
}