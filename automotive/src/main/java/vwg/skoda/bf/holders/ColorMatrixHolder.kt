package vwg.skoda.bf.holders

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.ColorMatrix
import vwg.skoda.bf.SysProp
import vwg.skoda.bf.MatrixString

object ColorMatrixHolder {
    val matrixValues: SnapshotStateList<Float> = mutableStateListOf<Float>().apply {
        addAll(List(20) { if (it % 6 == 0) 1f else 0f })
    }

    fun init() {
        val sysprop = SysProp()
        val value: String = sysprop.getSysProp("persist.system.skoda_blf_matrix") // "0.1,0.0,0.0,0.0,0.1,0.0,0.0,0.0,1.0"
        if (value.isNotEmpty()) {
            val typedArray = value.split(",").toTypedArray()
            for (index in typedArray.indices) {
                val row = index / 3;
                val column = index % 3;
                setElement(row, column, typedArray[index].toFloat())
            }
        }
    }

    fun setElement (index: Int, value: Float) {
        if (index in 0 until matrixValues.size) {
            matrixValues[index] = value
        }
    }

    fun setElement (row: Int, column: Int, value: Float) {
        val index = row * 5 + column
        if (index in 0 until matrixValues.size) {
            matrixValues[index] = value
        }
    }

    fun getElement (index: Int): Float {
        if (index in 0 until matrixValues.size) {
            return matrixValues[index]
        }
        return -1f
    }

    fun getElement (row: Int, column: Int): Float {
        val index = row * 5 + column
        if (index in 0 until matrixValues.size) {
            return matrixValues[index]
        }
        return -1f
    }

    fun asColorMatrix(): ColorMatrix {
        return ColorMatrix(matrixValues.toFloatArray())
    }

    fun setToSaturation(value: Float) {
        val temp = ColorMatrix()
        temp.setToSaturation(value)
        for (i in 0 until 20)
            matrixValues[i] = temp[i / 5, i % 5]
    }

    fun clear() {
        setToSaturation(1f)
        setElement(0, 0, 0f)
        setElement(1, 1, 0f)
        setElement(2, 2, 0f)
    }

    fun preSet(value: Int) {
        when (value) {
            0 -> {
                setToSaturation(1f)
            }
            1 -> {
                // 1.320845,0.544390,0.052764,-0.026570,0.823644,0.010785,-0.020285,-0.060307,0.279651
                clear()
                setElement(0, 0, 1.320845f)
                setElement(0, 1, 0.544390f)
                setElement(0, 2, 0.052764f)
                setElement(1, 0, -0.026570f)
                setElement(1, 1, 0.823644f)
                setElement(1, 2, 0.010785f)
                setElement(2, 0, -0.020285f)
                setElement(2, 1, -0.060307f)
                setElement(2, 2, 0.279651f)
            }
            2 -> {
                // 1.204193,0.336086,0.037139,-0.016328,0.897744,0.009205,-0.015060,-0.047647,0.445055
                clear()
                setElement(0, 0, 1.204193f)
                setElement(0, 1, 0.336086f)
                setElement(0, 2, 0.037139f)
                setElement(1, 0, -0.016328f)
                setElement(1, 1, 0.897744f)
                setElement(1, 2, 0.009205f)
                setElement(2, 0, -0.015060f)
                setElement(2, 1, -0.047647f)
                setElement(2, 2, 0.445055f)
            }
            3 -> {
                // 1.105672,0.158764,0.024404,-0.007599,0.961665,0.008176,-0.010927,-0.038161,0.572205
                clear()
                setElement(0, 0, 1.105672f)
                setElement(0, 1, 0.158764f)
                setElement(0, 2, 0.024404f)
                setElement(1, 0, -0.007599f)
                setElement(1, 1, 0.961665f)
                setElement(1, 2, 0.008176f)
                setElement(2, 0, -0.010927f)
                setElement(2, 1, -0.038161f)
                setElement(2, 2, 0.572205f)
            }
            4 -> {
                clear()
                setElement(0, 0, .8f)
                setElement(0, 1, .25f)
                setElement(0, 2, .25f)
                setElement(1, 1, .1f)
                setElement(2, 2, .1f)
            }
            5 -> {
                clear()
                setElement(0, 0, .8f)
                setElement(0, 1, .1f)
                setElement(0, 2, .1f)
                setElement(1, 1, .05f)
                setElement(2, 2, .05f)
            }
            6 -> {
                clear()
                setElement(0, 0, .8f)
                setElement(0, 1, .075f)
                setElement(0, 2, .075f)
            }
            7 -> {
                SysSetHolder.Disabel_BLF_NS()
                val matrixStr = MatrixString.getStr(matrixValues)
                val sysprop = SysProp()
                if (sysprop.setSysProp("persist.system.skoda_blf_matrix", matrixStr))
                    println("ns_blf_settings: persist.system.skoda_blf_matrix is set (${matrixStr})")
                else
                    println("ns_blf_settings: persist.system.skoda_blf_matrix is FAILED (${matrixStr})")
            }
            else -> {
                setToSaturation(1f)
            }
        }
    }
}
