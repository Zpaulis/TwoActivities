package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.twoactivities.MainActivity.Companion.EXTRA_MESSAGE
import com.example.twoactivities.MainActivity.Companion.EXTRA_REPLAY
import kotlinx.android.synthetic.main.activity_detail.*
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inputMessage = intent.getStringExtra(EXTRA_MESSAGE)
        Log.i(MainActivity.TAG, "$inputMessage")
        setContentView(R.layout.activity_detail)
        detail_message_display.text = inputMessage
        detail_replay_button.text = getString(R.string.detail_replay)
        detail_replay_button.setOnClickListener {
            Log.i(MainActivity.TAG, getString(R.string.detail_log_message_1))
            val replayMessage = detail_edit_text.text.toString()
            val result = Intent().apply{
                putExtra(EXTRA_REPLAY,replayMessage)
            }
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
    }
