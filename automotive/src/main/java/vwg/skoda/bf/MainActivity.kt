package vwg.skoda.bf

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.graphics.Paint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.content.Context
import android.provider.Settings
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import vwg.skoda.bf.holders.ColorMatrixHolder
import vwg.skoda.bf.screen.RootScreen
import vwg.skoda.bf.holders.SysSetHolder

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "BFSettings")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        CMHolder.matrix.setToSaturation(1F)
        SysSetHolder.init()
        ColorMatrixHolder.preSet(SysSetHolder.getPreset())
        ColorMatrixHolder.init()


//        if (!Settings.canDrawOverlays(this)) {
//
//            AlertDialog.Builder(this)
//                .setTitle("Overlay Permission")
//                .setMessage("Overlay permission not granted")
//                .setPositiveButton("OK", null)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show()
//            startActivity(intent)
//        } else {
//            AlertDialog.Builder(this)
//                .setTitle("Overlay Permission")
//                .setMessage("Overlay permission is granted")
//                .setPositiveButton("OK", null)
//                .setIcon(android.R.drawable.ic_dialog_info)
//                .show()
//        }
        setContent {
            RootScreen()
        }
    }

    private fun applyGlobalCM (root: View) {
        val paint = Paint()
//        paint.colorFilter = ColorMatrixColorFilter(CMHolder.matrix)
    }
}