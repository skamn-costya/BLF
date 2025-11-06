package vwg.skoda.bf.holders

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.ColorMatrix
import vwg.skoda.bf.SysProp
import vwg.skoda.bf.holders.SysSetHolder.setEnable

object ColorMatrixHolder {
    val matrixValues: SnapshotStateList<Float> = mutableStateListOf<Float>().apply {
        addAll(List(20) { if (it % 6 == 0) 1f else 0f })
    }

    fun init() {
        clear()
        val sysprop = SysProp()
        val value: String = sysprop.getSysProp("persist.blfsettings.vector") // "0.1,0.0,0.0,0.0,0.1,0.0,0.0,0.0,1.0"
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
        clear()
        when (value) {
            0 -> {
                setToSaturation(1f)
            }
            1 -> {
                setElement(0, 0, 1f)
            }
            2 -> {
                setElement(0, 0, .8f)
                setElement(0, 1, .1f)
                setElement(0, 2, .1f)
                setElement(1, 1, .05f)
                setElement(2, 2, .05f)
            }
            3 -> {
                setElement(0, 0, .8f)
                setElement(0, 1, .05f)
                setElement(0, 2, .05f)
            }
            4 -> {
                setElement(0, 0, .8f)
                setElement(0, 1, .025f)
                setElement(0, 2, .025f)
            }
            5 -> {
                setElement(0, 0, .75f)
                setElement(0, 1, .025f)
                setElement(0, 2, .025f)
            }
            6 -> {
                setElement(0, 0, .7f)
                setElement(0, 1, .02f)
                setElement(0, 2, .02f)
            }
            7 -> {
                setElement(0, 0, .65f)
            }
            else -> {
                setToSaturation(0f)
            }
        }
    }
}
