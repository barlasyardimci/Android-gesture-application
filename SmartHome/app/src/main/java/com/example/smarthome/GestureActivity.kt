package com.example.smarthome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class GestureActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture)

        val gesture = getGestureCode(intent.extras!!.getString("GESTURE"))
        val videoResource = resources.getIdentifier(gesture, "raw", packageName)
        val gestureVideoView = findViewById<View>(R.id.gesture_videoView) as VideoView
        val mediaControls = MediaController(this)
        mediaControls.setAnchorView(gestureVideoView)
        gestureVideoView.setMediaController(mediaControls)
        gestureVideoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + videoResource))
        gestureVideoView.requestFocus()
        gestureVideoView.start()
        gestureVideoView.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video completed",
                Toast.LENGTH_LONG).show()
        }

        gestureVideoView.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }

        val practiceButton = findViewById<Button>(R.id.practice_button)
        practiceButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(this@GestureActivity, CameraActivity::class.java)
                intent.putExtra("GESTURE", gesture)
                startActivity(intent)
            }
        })


    }

    private fun getGestureCode(gesture: String?): String {
        val gestures = resources.getStringArray(R.array.Gestures)
        when(gesture){
            gestures[0] -> return "lighton"
            gestures[1] -> return "lightoff"
            gestures[2] -> return "fanon"
            gestures[3] -> return "fanoff"
            gestures[4] -> return "fanup"
            gestures[5] -> return "fandown"
            gestures[6] -> return "setthermo"
            gestures[7] -> return "num0"
            gestures[8] -> return "num1"
            gestures[9] -> return "num2"
            gestures[10] -> return "num3"
            gestures[11] -> return "num4"
            gestures[12] -> return "num5"
            gestures[13] -> return "num6"
            gestures[14] -> return "num7"
            gestures[15] -> return "num8"
            gestures[16] -> return "num9"
            else -> {return " "}

        }
    }

}