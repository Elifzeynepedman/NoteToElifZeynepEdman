package ise308.edman.notetoelifzeynepedman

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

import javax.security.auth.login.LoginException

open class MainActivity : AppCompatActivity() {
    private var mSerializer: JSONSerializer?=null
    private var noteList: ArrayList<Note>?=null
   //private val noteList=ArrayList<Note>()
    private var recyclerView: RecyclerView?=null
    private var adapter: NoteAdapter? =null
    private var showDividers:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fab=findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener{view->
            val dialog=DialogNewNote()
            dialog.show(supportFragmentManager,"")
        }
       mSerializer= JSONSerializer("NotetoSelf.json", applicationContext)

        try{
            noteList=mSerializer!!.load()
        }catch(e:Exception){
            noteList= ArrayList()
            Log.e("Error loading notes: ","",e)
        }


        recyclerView=findViewById<View>(R.id.recyclerView) as RecyclerView

        adapter= NoteAdapter(this, this.noteList!!)
        val layoutManager= LinearLayoutManager(applicationContext)

        recyclerView!!.layoutManager= layoutManager
        recyclerView!!.itemAnimator=DefaultItemAnimator()

      //  recyclerView!!.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        if(showDividers)
            recyclerView!!.addItemDecoration(
                DividerItemDecoration(
                    this, LinearLayoutManager.VERTICAL
                )
            )
        else{
            if(recyclerView!!.itemDecorationCount>0)
                recyclerView!!.removeItemDecorationAt(0)
        }

         recyclerView!!.adapter=adapter
        }

    fun createNewNote(n:Note){
        noteList?.add(n)
        adapter!!.notifyDataSetChanged()

    }
    fun showNote(noteToShow: Int){
        val dialog = DialogShowNote()
        dialog.sendNoteSelected(noteList!![noteToShow])
        dialog.show(supportFragmentManager,"")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
           R.id.action_settings-> {
               val intent= Intent(this,settingsActivity::class.java)
               startActivity(intent)
               true
           }
            else -> super.onOptionsItemSelected(item)


        }
    }

    override fun onResume() {
        super.onResume()

        val prefs = getSharedPreferences("Note to self", Context.MODE_PRIVATE)
        showDividers=prefs.getBoolean("dividers", true)

    }

    private fun saveNotes(){
        try{
           mSerializer!!.save(this.noteList!!)
        }catch (e:Exception){
            Log.e("Error Saving Notes","",e)
        }
    }

    override fun onPause() {
        super.onPause()

        saveNotes()
    }
    }

