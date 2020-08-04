package com.teamnexters.eyelong

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.teamnexters.eyelong.db.AppDatabase
import com.teamnexters.eyelong.db.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppDatabase.getAppDatabase(applicationContext)?.run {
            Thread {
                with(userDao()) {
                    insertUser(User(name = "민식"))

                    GlobalScope.launch(Dispatchers.Main) {
                        getAllUser().observe(this@MainActivity, Observer<List<User>> {

                            it.forEach {
                                Log.i(
                                    MainActivity::class.simpleName,
                                    "registered user name: ${it.name}"
                                )
                            }
                        })
                    }
                }
            }.start()
        }
    }
}
