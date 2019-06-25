package com.narara.android_qrcode_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private val viewModel = ViewModelProviders.of(this).get(QrViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)

        bottomNavigationView.setupWithNavController(navController)

    }

    //     Get the results:
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()

            } else {
                val intent = Intent(this, ScanActivity::class.java)
                intent.putExtra("contents", result.contents)
                startActivity(intent)

//                val qrCode = QrCode(result.contents)
//                viewModel.url.value = qrCode

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
