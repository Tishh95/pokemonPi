package com.projet.poke

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.projet.poke.Common.Common
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {

    public interface SharedPreferences

    private val showDetail = object:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent!!.action!!.toString() ==  Common.KEY_ENABLE_HOME)
            {
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)

                val detailFragment = PokemonDetail.getInstance()
                val position = intent.getIntExtra("position", -1)
                val bundle = Bundle()

                bundle.putInt("position", position)
                detailFragment.arguments = bundle

                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.list_pokmeon_fragment, detailFragment )
                fragmentTransaction.addToBackStack("detail")

                fragmentTransaction.commit()


            }
        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showDetail, IntentFilter(Common.KEY_ENABLE_HOME))
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            android.R.id.home  -> {
                

                supportFragmentManager.popBackStack("detail" , FragmentManager.POP_BACK_STACK_INCLUSIVE)


                supportActionBar!!.setDisplayShowHomeEnabled(false)
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
        return true
    }

}