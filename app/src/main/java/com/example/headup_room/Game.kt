package com.example.headup_room

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.headup_room.data.Celebrity
import com.example.headup_room.data.CelebertyDatabase
import kotlinx.android.synthetic.main.rotate.*
import kotlin.random.Random


class Game : AppCompatActivity() {


   lateinit  var list:List<Celebrity>
    private  var gameActive:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstpageingame)
        list= listOf()
        newTimer()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.rotate)
            getCelebrities()
            gameActive=true
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.firstpageingame)
        }
    }

    private fun newCelebrity(){
        var randomIndex= Random.nextInt(list.size)
            tvShow.text = list[randomIndex].name
            tvTaboo.text = list[randomIndex].taboo1
            tvTaboo2.text = list[randomIndex].taboo2
            tvTaboo3.text = list[randomIndex].taboo3

    }

    fun getCelebrities(){
        val ob= CelebertyDatabase.getinstant(applicationContext)
       list= ob.celebDao().getAllUserInfo()
        println(list)
        newCelebrity()

    }




    private fun newTimer(){
        if(!gameActive){
            gameActive = true
            object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    tvTime.text = "Time: ${millisUntilFinished / 1000}"
                }

                override fun onFinish() {
                    gameActive = false
                    intent=Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                }
            }.start()
        }
    }


}