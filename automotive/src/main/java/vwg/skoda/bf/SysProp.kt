package vwg.skoda.bf

class SysProp {
    @Suppress ("PrivateApi")
    fun getSysProp (key: String, def: String = ""): String {
        return try {
            val clazz = Class.forName("android.os.SystemProperties")
            val method = clazz.getMethod("get", String::class.java, String::class.java)
            method.invoke(null, key, def) as String
        } catch (e: Exception) {
            def
        }
    }
    @Suppress ("PrivateApi")
    fun setSysProp (key: String, def: String = ""): Boolean {
        return try {
            val clazz = Class.forName("android.os.SystemProperties")
            val method = clazz.getMethod("set", String::class.java, String::class.java)
            method.invoke(null, key, def)
            true
        } catch (e: Exception) {
            false
        }
    }

    @Suppress("PrivateApi")
    fun refresh(): Boolean {
        return try {
            val clazz = Class.forName("android.view.SurfaceControl")
            val method = clazz.getDeclaredMethod("invalidateDisplay", String::class.java)
//            method.isAccessible = true
            method.invoke(null, "default")
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}