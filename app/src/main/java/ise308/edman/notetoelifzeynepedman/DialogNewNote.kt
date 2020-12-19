package ise308.edman.notetoelifzeynepedman


import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.view.LayoutInflater
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class DialogNewNote: DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity!!)
        val inflater = activity!!.layoutInflater
        val dialogView=inflater.inflate(R.layout.dialog_new_note,null)

        val editTitle= dialogView.findViewById(R.id.editTitle) as EditText
        val editDescription= dialogView.findViewById(R.id.editDescription) as EditText
        val checkBoxIdea=dialogView.findViewById(R.id.checkBoxIdea) as CheckBox
        val checkBoxTodo=dialogView.findViewById(R.id.checkBoxTodo) as CheckBox
        val checkBoxImportant=dialogView.findViewById(R.id.checkBoxImportant) as CheckBox
        val btnCancel= dialogView.findViewById(R.id.btnCancel) as Button
        val btnOk=dialogView.findViewById(R.id.btnOk) as Button

        builder.setView(dialogView).setMessage("Add a new note")

        btnCancel.setOnClickListener{
            dismiss()
        }

        btnOk.setOnClickListener {

            val newNote= Note()
            newNote.title=editTitle.text.toString()
            newNote.description= editDescription.text.toString()

            newNote.idea=checkBoxIdea.isChecked
            newNote.todo=checkBoxTodo.isChecked
            newNote.important=checkBoxImportant.isChecked

            val callingActivity=activity as MainActivity?

            callingActivity!!.createNewNote(newNote)

            dismiss()
        }
        return builder.create()
    }
}