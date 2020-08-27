package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DETAIL_REQUEST && resultCode == Activity.RESULT_OK){
            data?.let {
                val replayMessage = data.getStringExtra(EXTRA_REPLAY)
                main_replay_message.text = replayMessage
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_edit_text.hint = getString(R.string.main_send_message)
        main_send_button.text = getString(R.string.main_send)
        main_send_button.setOnClickListener {
            val mainMessage = main_edit_text.text.toString()
            val intent = Intent(this,DetailActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, mainMessage)
                Log.i(TAG, "$mainMessage")
            }
            Log.i(TAG, getString(R.string.main_log_message_1))
            startActivityForResult(intent, DETAIL_REQUEST)
        }
    }

    companion object {
        const val TAG = "MainActivity"
        const val EXTRA_MESSAGE = "mobile.practice.message"
        const val DETAIL_REQUEST = 1234
        const val EXTRA_REPLAY = "mobile.praktice.REPLAY"
    }
}