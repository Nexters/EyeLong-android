package com.teamnexters.eyelong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.RoomDatabase
import com.teamnexters.eyelong.db.AppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val userDao = AppDatabase.getAppDatabase(applicationContext)!!.userDao()

    }
}
