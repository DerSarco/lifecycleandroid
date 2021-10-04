package com.sarco.lifecycle

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener{
            startActivity(Intent(this, DialogActivity::class.java))
        }


        Log.i("LifeCycle", "On create!")
    }


    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.ai_2)
        //if (mediaPlayet != null) es lo mismo al decir mediaPlayer?.start()
        Log.i("LifeCycle", "On start!")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("LifeCycle", "On Resume!")
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        // con !! indicamos q el valo de media player no va a ser nulo
        if(mediaPlayer != null)
            position = mediaPlayer!!.currentPosition
        super.onDestroy()
        Log.i("LifeCycle", "On pause!")

    }
    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
        Log.i("LifeCycle", "On Stop!")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("LifeCycle", "On Destroy!")

    }
    override fun onRestart() {
        super.onRestart()

        Log.i("LifeCycle", "On Restart!")

    }


}