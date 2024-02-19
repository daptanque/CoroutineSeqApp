package com.example.coroutineseqapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val one = doSomeThingUseful1()
            val two = doSomeThingUseful2()

            val result = one + two
            Log.v("TAGY", "The result is: $result ")
        }
    }

    suspend fun doSomeThingUseful1() : Int{
        delay(5000)
        Log.v("TAGY", "Func1 is done")
        return 11
    }

    suspend fun doSomeThingUseful2() : Int{
        delay(7000)
        Log.v("TAGY", "Func2 is done")
        return 8
    }
}