package vwg.skoda.bf

data class SysSet(
    val enable: Boolean = false,
    val preset: Int = 6,
    val mode: Int = 0, // 0 - Always; 1 - Sunset/Sunrise; 2 - Manual set
    val from: String = "20:24",
    val till: String = "06:42",
)