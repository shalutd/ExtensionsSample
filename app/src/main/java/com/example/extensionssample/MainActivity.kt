package com.example.extensionssample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.extensionssample.ExtensionUtil.setBackgroundColorRes
import com.example.extensionssample.ExtensionUtil.setClickableSpan
import com.example.extensionssample.ExtensionUtil.setMarginStart
import com.example.extensionssample.ExtensionUtil.setViewHeight
import com.example.extensionssample.ExtensionUtil.setViewWidth
import com.example.extensionssample.ExtensionUtil.showDialog
import com.example.extensionssample.ExtensionUtil.showShortToast
import com.example.extensionssample.ExtensionUtil.toGone
import com.example.extensionssample.ExtensionUtil.toVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Un comment each one and test*/

        // val txtView: TextView = findViewById(R.id.txtView)
        //txtView.text = "Hello how are you"

        //txtView.toGone()
        //txtView.toVisible()


        //txtView.setViewWidth(300)
        //txtView.setViewHeight(400)

        //txtView.setMarginStart(200)
        //txtView.setBackgroundColorRes(R.color.colorAccent)

        /*txtView.setClickableSpan("Hello how are you? click here", "click here", {
            showShortToast("Hello")
        }, R.color.green)*/

        //showDialog("Hello", "Are you sure?", { showShortToast("Yes Clicked") }, { showShortToast("No Clicked") })
    }
}