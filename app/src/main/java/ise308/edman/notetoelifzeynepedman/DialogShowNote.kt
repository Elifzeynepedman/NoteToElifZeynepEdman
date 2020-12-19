package ise308.edman.notetoelifzeynepedman

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import android.view.View
import android.view.LayoutInflater
import android.widget.Button


class DialogShowNote :DialogFragment(){

    private var note: Note?= null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(this.activity!!)
        val inflater = activity!!.layoutInflater
        val dialogView=inflater.inflate(R.layout.dialog_show_note, null)
        val txtTitle=dialogView.findViewById(R.id.txtTitle) as TextView
        val txtDescription=dialogView.findViewById(R.id.txtDescription) as TextView

        txtTitle.text=note!!.title
        txtDescription.text=note!!.description

        val txtImportant=dialogView.findViewById(R.id.textViewImportant) as TextView
        val txtTodo=dialogView.findViewById(R.id.textViewTodo) as TextView
        val txtIdea=dialogView.findViewById(R.id.textViewIdea) as TextView

        if(!note!!.important)
        {
            txtImportant.visibility=View.GONE
        }

        if(!note!!.todo)
        {
            txtTodo.visibility=View.GONE
        }

        if(!note!!.idea){
            txtIdea.visibility=View.GONE
        }

        val btnOk= dialogView.findViewById(R.id.btnOK) as Button
        builder.setView(dialogView).setMessage("Your Note")
        btnOk.setOnClickListener({
            dismiss()
        })

        return builder.create()
    }

    fun sendNoteSelected(noteSelected: Note)
    {
        note=noteSelected
    }

}