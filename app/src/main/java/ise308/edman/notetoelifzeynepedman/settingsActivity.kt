package ise308.edman.notetoelifzeynepedman

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences

class settingsActivity : AppCompatActivity() {
    private var showDividers: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val prefs= getSharedPreferences("Note to self", Context.MODE_PRIVATE)

        showDividers=prefs.getBoolean("dividers",true)
        switch1.isChecked= showDividers // could not find the error 

        switch1.setOnCheckedChangeListener{
            buttonView, isChecked ->
            showDividers=isChecked
        }

        override fun onPause(){
            super.onPause()
            val prefs = getSharedPreferences("Note to self", Context.MODE_PRIVATE)
            val editor =prefs.edit()
            editor.putBoolean("dividers",showDividers)
            editor.apply()
        }
    }
}





















































