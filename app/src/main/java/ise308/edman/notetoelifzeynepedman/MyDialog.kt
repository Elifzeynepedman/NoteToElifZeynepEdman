package ise308.edman.notetoelifzeynepedman

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
class MyDialog : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity!!)
        builder.setMessage("Make a selection")//Dialog will have the string "Make a selection" as the title
            .setPositiveButton("Ok", { dialog, id -> // ok button
                //nothing happens
            })
            .setNegativeButton("Cancel", {dialog, id->// Cancel button
                // nothing happens here
            })

        return builder.create()
    }
}