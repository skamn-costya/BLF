package vwg.skoda.bf.holders

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import vwg.skoda.bf.SysSet
import vwg.skoda.bf.SysProp

object SysSetHolder {
    var sysset by mutableStateOf(SysSet())

    fun init() {
        val sysprop = SysProp()
        var value: String = sysprop.getSysProp("persist.blfsettings.enable")
        if (value.isNotEmpty())
            setEnable(value.toBoolean())
        value = sysprop.getSysProp("persist.blfsettings.mode")
        if (value.isNotEmpty())
            setMode(value.toInt())
        value = sysprop.getSysProp("persist.blfsettings.preset")
        if (value.isNotEmpty())
            setPreset(value.toInt())
        value = sysprop.getSysProp("persist.blfsettings.matrix")
    }

    fun writePropMatrix(value: Int) {
        val sysprop = SysProp()
        var matrixStr = "1,0,0,0,1,0,0,0,1"
        if (sysset.enable) {
            when (value) {
                0 -> matrixStr = "0.8,0.1,0.1,0,0.05,0,0,0,0.05"
                1 -> matrixStr = "0.8,0.05,0.05,0,0,0,0,0,0"
                2 -> matrixStr = "0.8,0.025,0.025,0,0,0,0,0,0"
                3 -> matrixStr = "0.75,0.025,0.025,0,0,0,0,0,0"
                4 -> matrixStr = "0.7,0.02,0.02,0,0,0,0,0,0"
                5 -> matrixStr = "0.65,0,0,0,0,0,0,0,0"
                6 -> matrixStr = "0.5,0,0,0,0,0,0,0,0"
                else -> { // Note the block
                    println("blfsettings: call writePropMatrix with wrong preset index")
                }
            }
        }
        if (sysprop.setSysProp("persist.system.skoda_blf_matrix", matrixStr))
            println("blfsettings: persist.system.skoda_blf_matrix is set")
        else
            println("blfsettings: persist.system.skoda_blf_matrix is FAILED")
    }

    fun setEnable(value: Boolean) {
        sysset = sysset.copy(enable = value)
        val sysprop = SysProp()
        writePropMatrix(sysset.preset)
        if (sysprop.setSysProp("persist.blfsettings.enable", value.toString()))
            println("blfsettings: persist.blfsettings.enable is set")
        else
            println("blfsettings: set persist.blfsettings.enable is FAILED")

//        if (sysprop.refresh())
//            println("blfsettings: refresh - OK")
//        else
//            println("blfsettings: refresh - FAIL")
    }

    fun getEnable(): Boolean {
        return sysset.enable
    }

    fun setMode(value: Int) {
        sysset = sysset.copy(mode = value)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.blfsettings.mode", value.toString()))
            println("blfsettings: set persist.blfsettings.mode is ok")
        else
            println("blfsettings: set persist.blfsettings.mode is FAILED")
    }

    fun getMode(): Int {
        return sysset.mode
    }

    fun setFrom(value: String) {
        sysset = sysset.copy(from = value)
    }

    fun getFrom(): String {
        return sysset.from
    }

    fun setTill(value: String) {
        sysset = sysset.copy(till = value)
    }

    fun getTill(): String {
        return sysset.till
    }

    fun setPreset(value: Int) {
        sysset = sysset.copy(preset = value)
        writePropMatrix(sysset.preset)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.blfsettings.preset", value.toString()))
            println("blfsettings: set persist.blfsettings.preset is ok")
        else
            println("blfsettings: set persist.blfsettings.preset is FAILED")
    }

    fun getPreset(): Int {
        return sysset.preset
    }
}
