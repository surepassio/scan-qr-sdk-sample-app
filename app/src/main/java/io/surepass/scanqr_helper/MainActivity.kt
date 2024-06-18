package io.surepass.scanqr_helper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.surepass.scanqr.api.InitScan
import io.surepass.scanqr.interfaces.QRCodeCallback
import io.surepass.scanqr_helper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetStarted.setOnClickListener {
            InitScan.startQRScan(this, object : QRCodeCallback {
                override fun onQRCodeScanned(result: String) {

                    // Handle the scanned QR code result
                    // You can implement `upload-qr` API wrapper here

                    Log.d("QRScanner", "Scanned QR Code: $result")
//                    binding.etResponse.visibility = View.VISIBLE
                    binding.etResponse.setText(result)
                }
            })
        }
    }

}