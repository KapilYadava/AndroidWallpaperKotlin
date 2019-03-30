package com.example.androidwallpaperkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setWallpaper.setOnClickListener(View.OnClickListener {
            var intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 100)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100){

            if (data != null){
                var contentUri = data.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, contentUri)
                    imageView.setImageBitmap(bitmap)
                }catch (e: IOException){

                }
            }
        }
    }
}
