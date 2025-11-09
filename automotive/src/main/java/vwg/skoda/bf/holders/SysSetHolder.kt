package vwg.skoda.bf.holders

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vwg.skoda.bf.SysSet
import vwg.skoda.bf.SysProp

object SysSetHolder {
    var sysset by mutableStateOf(SysSet())

    fun init() {
        val sysprop = SysProp()
        var value: String

        for (idx in 0..3) {
            value = sysprop.getSysProp("persist.ns_blf_settings.preset_0${idx}_ns")
            if (value.isNotEmpty())
                setPresetMatrixNS(idx, value)
        }
        value = sysprop.getSysProp("persist.ns_blf_settings.enable_ns")
        if (value.isNotEmpty())
            setEnableNS(value.toBoolean())
        value = sysprop.getSysProp("persist.ns_blf_settings.mode_ns")
        if (value.isNotEmpty())
            setModeNS(value.toInt())
        value = sysprop.getSysProp("persist.ns_blf_settings.preset_ns")
        if (value.isNotEmpty())
            setPresetNS(value.toInt())

        for (idx in 0..6) {
            value = sysprop.getSysProp("persist.ns_blf_settings.preset_0${idx}_blf")
            if (value.isNotEmpty())
                setPresetMatrixBLF(idx, value)
        }
        value = sysprop.getSysProp("persist.ns_blf_settings.enable_blf")
        if (value.isNotEmpty())
            setEnableBLF(value.toBoolean())
        value = sysprop.getSysProp("persist.ns_blf_settings.mode_blf")
        if (value.isNotEmpty())
            setModeBLF(value.toInt())
        value = sysprop.getSysProp("persist.ns_blf_settings.preset_blf")
        if (value.isNotEmpty())
            setPresetBLF(value.toInt())
    }

    fun writePropMatrix(value: Int) {
        val sysprop = SysProp()
        var matrixStr = "1,0,0,0,1,0,0,0,1"
        if (sysset.enable_blf) {
            when (value) {
                0 -> matrixStr = sysset.preset_00_blf
                1 -> matrixStr = sysset.preset_01_blf
                2 -> matrixStr = sysset.preset_02_blf
                3 -> matrixStr = sysset.preset_03_blf
                4 -> matrixStr = sysset.preset_04_blf
                5 -> matrixStr = sysset.preset_05_blf
                6 -> matrixStr = sysset.preset_06_blf
                else -> { // Note the block
                    println("ns_blf_settings: call writePropMatrix with wrong preset index")
                }
            }
        } else if (sysset.enable_ns) {
            when (value) {
                0 -> matrixStr = sysset.preset_00_ns
                1 -> matrixStr = sysset.preset_01_ns
                2 -> matrixStr = sysset.preset_02_ns
                3 -> matrixStr = sysset.preset_03_ns
                else -> { // Note the block
                    println("ns_blf_settings: call writePropMatrix with wrong preset index")
                }
            }
        }
        if (sysprop.setSysProp("persist.system.skoda_blf_matrix", matrixStr))
            println("ns_blf_settings: persist.system.skoda_blf_matrix is set (${matrixStr})")
        else
            println("ns_blf_settings: persist.system.skoda_blf_matrix is FAILED (${matrixStr})")
    }

    fun Disabel_BLF_NS() {
        sysset = sysset.copy(enable_ns = false, enable_blf = false)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.ns_blf_settings.enable_ns", false.toString()))
            println("ns_blf_settings: persist.ns_blf_settings.enable_ns is set")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.enable_ns is FAILED")
        if (sysprop.setSysProp("persist.ns_blf_settings.enable_blf", false.toString()))
            println("ns_blf_settings: persist.ns_blf_settings.enable_blf is set")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.enable_blf is FAILED")
    }

///////////////////////////////////////////////// Night Shift /////////////////////////////////////////////////
    fun setPresetMatrixNS(idx: Int, value: String) {
        val sysprop = SysProp()
        when (idx) {
            0 -> sysset = sysset.copy(preset_00_ns = value)
            1 -> sysset = sysset.copy(preset_01_ns = value)
            2 -> sysset = sysset.copy(preset_02_ns = value)
            3 -> sysset = sysset.copy(preset_03_ns = value)
        }
        if (sysprop.setSysProp("persist.ns_blf_settings.preset_0${idx}_ns", value))
            println("ns_blf_settings: persist.ns_blf_settings.preset_0${idx}_ns is set")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.preset_0${idx}_ns is FAILED")
    }

    fun setEnableNS(value: Boolean) {
        sysset = sysset.copy(enable_ns = value)
        if (value)
            setEnableBLF(false)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.ns_blf_settings.enable_ns", value.toString()))
            println("ns_blf_settings: persist.ns_blf_settings.enable_ns is set")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.enable_ns is FAILED")
        writePropMatrix(sysset.preset_ns)
    }

    fun getEnableNS(): Boolean {
        return sysset.enable_ns
    }

    fun setModeNS(value: Int) {
        sysset = sysset.copy(mode_ns = value)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.ns_blf_settings.mode_ns", value.toString()))
            println("ns_blf_settings: set persist.ns_blf_settings.mode_ns is ok")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.mode_ns is FAILED")
    }

    fun getModeNS(): Int {
        return sysset.mode_ns
    }

    fun setFromNS(value: String) {
        sysset = sysset.copy(from_ns = value)
    }

    fun getFromNS(): String {
        return sysset.from_ns
    }

    fun setTillNS(value: String) {
        sysset = sysset.copy(till_ns = value)
    }

    fun getTillNS(): String {
        return sysset.till_ns
    }

    fun setPresetNS(value: Int) {
        sysset = sysset.copy(preset_ns = value)
        if(sysset.enable_ns)
            writePropMatrix(sysset.preset_ns)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.ns_blf_settings.preset_ns", value.toString()))
            println("ns_blf_settings: set persist.ns_blf_settings.preset_ns is ok")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.preset_ns is FAILED")
    }

    fun getPresetNS(): Int {
        return sysset.preset_ns
    }

///////////////////////////////////////////////// Blue Light Filter /////////////////////////////////////////////////

    fun setPresetMatrixBLF(idx: Int, value: String) {
        val sysprop = SysProp()
        var setresult = false
        when (idx) {
            0 -> { sysset = sysset.copy(preset_00_blf = value)
                setresult = sysprop.setSysProp("persist.ns_blf_settings.preset_00_blf", value) }
            1 -> { sysset = sysset.copy(preset_01_blf = value)
                setresult = sysprop.setSysProp("persist.ns_blf_settings.preset_01_blf", value) }
            2 -> { sysset = sysset.copy(preset_02_blf = value)
                setresult = sysprop.setSysProp("persist.ns_blf_settings.preset_02_blf", value) }
            3 -> { sysset = sysset.copy(preset_03_blf = value)
                setresult = sysprop.setSysProp("persist.ns_blf_settings.preset_03_blf", value) }
            4 -> { sysset = sysset.copy(preset_04_blf = value)
                setresult = sysprop.setSysProp("persist.ns_blf_settings.preset_04_blf", value) }
            5 -> { sysset = sysset.copy(preset_05_blf = value)
                setresult = sysprop.setSysProp("persist.ns_blf_settings.preset_05_blf", value) }
            6 -> { sysset = sysset.copy(preset_06_blf = value)
                setresult = sysprop.setSysProp("persist.ns_blf_settings.preset_06_blf", value) }
        }
        if (setresult)
            println("ns_blf_settings: persist.ns_blf_settings.preset_0${idx}_blf is set")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.preset_0${idx}_blf is FAILED")
    }

    fun setEnableBLF(value: Boolean) {
        sysset = sysset.copy(enable_blf = value)
        if (value)
            setEnableNS(false)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.ns_blf_settings.enable_blf", value.toString()))
            println("ns_blf_settings: persist.ns_blf_settings.enable_blf is set")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.enable_blf is FAILED")
        writePropMatrix(sysset.preset_blf)
    }

    fun getEnableBLF(): Boolean {
        return sysset.enable_blf
    }

    fun setModeBLF(value: Int) {
        sysset = sysset.copy(mode_blf = value)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.ns_blf_settings.mode_blf", value.toString()))
            println("ns_blf_settings: set persist.ns_blf_settings.mode_blf is ok")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.mode_blf is FAILED")
    }

    fun getModeBLF(): Int {
        return sysset.mode_blf
    }

    fun setFromBLF(value: String) {
        sysset = sysset.copy(from_blf = value)
    }

    fun getFromBLF(): String {
        return sysset.from_blf
    }

    fun setTillBLF(value: String) {
        sysset = sysset.copy(till_blf = value)
    }

    fun getTillBLF(): String {
        return sysset.till_blf
    }

    fun setPresetBLF(value: Int) {
        sysset = sysset.copy(preset_blf = value)
        if (sysset.enable_blf)
            writePropMatrix(sysset.preset_blf)
        val sysprop = SysProp()
        if (sysprop.setSysProp("persist.ns_blf_settings.preset_blf", value.toString()))
            println("ns_blf_settings: set persist.ns_blf_settings.preset_blf is ok")
        else
            println("ns_blf_settings: set persist.ns_blf_settings.preset_blf is FAILED")
    }

    fun getPresetBLF(): Int {
        return sysset.preset_blf
    }
}
