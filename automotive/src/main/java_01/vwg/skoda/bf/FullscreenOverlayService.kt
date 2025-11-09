package vwg.skoda.bf

import android.accessibilityservice.AccessibilityService
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout

// accessibility_enabled=1
// enabled_accessibility_services=com.android.car.rotary/.RotaryService:com.android.car/.pm.CarSafetyAccessibilityService
// settings put secure enabled_accessibility_services com.android.car.rotary/.RotaryService:com.android.car/.pm.CarSafetyAccessibilityService:vwg.skoda.bf/.FullscreenOverlayService
// settings put secure enabled_accessibility_services vwg.skoda.bf/.FullscreenOverlayService
// settings put secure accessibility_enabled 0

class FullscreenOverlayService  : AccessibilityService() {

    private var overlayView: FrameLayout? = null

    override fun onServiceConnected() {
        super.onServiceConnected()

        overlayView = FrameLayout(this).apply {
            setBackgroundColor(Color.TRANSPARENT)
//            setBackgroundColor(Color.parseColor("#90FF0000"))
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            android.graphics.PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
        }

        val matrix = ColorMatrix()
        matrix.setSaturation(0f) // Пример: черно-белый экран
        val paint = Paint()
        paint.colorFilter = ColorMatrixColorFilter(matrix)
//        overlayView?.setLayerType(View.LAYER_TYPE_HARDWARE, paint)
        overlayView?.setLayerType(View.LAYER_TYPE_SOFTWARE, paint)
        val wm = getSystemService(WINDOW_SERVICE) as WindowManager
        wm.addView(overlayView, params)
    }

    override fun onDestroy() {
        overlayView?.let {
            val wm = getSystemService(WINDOW_SERVICE) as WindowManager
            wm.removeView(it)
        }
        overlayView = null
        super.onDestroy()
    }

    override fun onAccessibilityEvent(event: android.view.accessibility.AccessibilityEvent?) {
        // не нужен, но обязателен
    }

    override fun onInterrupt() {
        // не нужен, но обязателен
    }
}

/* 1
val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

val layoutParams = WindowManager.LayoutParams(
    WindowManager.LayoutParams.MATCH_PARENT,
    WindowManager.LayoutParams.MATCH_PARENT,
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
    else
        WindowManager.LayoutParams.TYPE_PHONE,
    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
    PixelFormat.TRANSLUCENT
)

val overlayView = View(this)
overlayView.setBackgroundColor(Color.TRANSPARENT)

// Применение ColorMatrix
val matrix = ColorMatrix()
matrix.setSaturation(0f) // Пример: черно-белый экран
val paint = Paint()
paint.colorFilter = ColorMatrixColorFilter(matrix)

overlayView.setLayerType(View.LAYER_TYPE_HARDWARE, paint)

windowManager.addView(overlayView, layoutParams)
 */

/* 2
class MyAccessibilityService : AccessibilityService() {

    private lateinit var windowManager: WindowManager
    private lateinit var overlayView: View

    override fun onServiceConnected() {
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val layoutParams = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            PixelFormat.TRANSLUCENT
        )

        overlayView = View(this)
        overlayView.setBackgroundColor(Color.TRANSPARENT)

        val matrix = ColorMatrix()
        matrix.setSaturation(0f) // Пример: черно-белый экран

        val paint = Paint()
        paint.colorFilter = ColorMatrixColorFilter(matrix)

        overlayView.setLayerType(View.LAYER_TYPE_HARDWARE, paint)

        windowManager.addView(overlayView, layoutParams)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}
}
 */

/* 3
val layoutParams = WindowManager.LayoutParams(
    WindowManager.LayoutParams.MATCH_PARENT,
    WindowManager.LayoutParams.MATCH_PARENT,
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
    else
        WindowManager.LayoutParams.TYPE_PHONE,
    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
    PixelFormat.TRANSLUCENT
)

val overlayView = View(context)
overlayView.setBackgroundColor(Color.TRANSPARENT)

val matrix = ColorMatrix()
matrix.setSaturation(0f) // Пример: черно-белый экран

val paint = Paint()
paint.colorFilter = ColorMatrixColorFilter(matrix)
overlayView.setLayerType(View.LAYER_TYPE_HARDWARE, paint)

val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
windowManager.addView(overlayView, layoutParams)
 */