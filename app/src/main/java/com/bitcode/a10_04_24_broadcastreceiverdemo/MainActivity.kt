package com.bitcode.a10_04_24_broadcastreceiverdemo

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bitcode.a10_04_24_broadcastreceiverdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var myBroadcastReceiver: MyBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.registerBroadcastRx.setOnClickListener {
            Toast.makeText(this,"Register rx", Toast.LENGTH_LONG).show()
            myBroadcastReceiver = MyBroadcastReceiver()
            var intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
            registerReceiver(myBroadcastReceiver,intentFilter)
        }

        activityMainBinding.unregisterBroadcastRx.setOnClickListener {
            Toast.makeText(this,"UnRegister rx", Toast.LENGTH_LONG).show()
            unregisterReceiver(myBroadcastReceiver)
        }
    }
}