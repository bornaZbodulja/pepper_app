package com.ruazosa.pepperapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity
import com.ruazosa.pepperapp.R
import com.ruazosa.pepperapp.bt_tree.talkCBuilding
import com.ruazosa.pepperapp.bt_tree.talkTesla
import com.ruazosa.pepperapp.bt_tree.talkingBookshop
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RobotActivity(), RobotLifecycleCallbacks {

    private lateinit var qiContext: QiContext

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        QiSDK.register(this, this)
        setContentView(R.layout.activity_main)

        teslaChoiceButton.setOnClickListener {
            talkTesla(qiContext)
        }

        bookshopChoiceButton.setOnClickListener {
            talkingBookshop(qiContext)
        }

        cBuildingChoiceButton.setOnClickListener {
            talkCBuilding(qiContext)
        }
    }


    override fun onDestroy() {
        QiSDK.unregister(this, this)
        super.onDestroy()
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        if (qiContext != null) {
            this.qiContext = qiContext
        }
    }

    override fun onRobotFocusLost() {

    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
}