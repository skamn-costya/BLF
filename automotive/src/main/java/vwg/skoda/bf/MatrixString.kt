package vwg.skoda.bf

import androidx.compose.runtime.snapshots.SnapshotStateList

object MatrixString {
    fun getStr(matrixValues: SnapshotStateList<Float>) : String {
        var str: String = ""
        for (i in 0..12) {
            when (i) {
                3,4,8,9 -> {
                }
                12 -> {
                    str += matrixValues[i].toString()
                }
                else -> {
                    str += matrixValues[i].toString()
                    str += ","
                }
            }
        }
        return str
    }
}

// System.out: ns_blf_settings: persist.system.skoda_blf_matrix is FAILED (0.80.8,0.250.25,0.250.25,0.00.00.00.0,0.10.1,0.00.0,0.00.00.00.0,0.00.0,0.10.10.00.0)
