package vwg.skoda.bf

data class SysSet(
    val enable_ns: Boolean = false,
    val preset_ns: Int = 0,
    val mode_ns: Int = 0, // 0 - Always; 1 - Sunset/Sunrise; 2 - Manual set
    val from_ns: String = "20:24",
    val till_ns: String = "06:42",
    val preset_00_ns: String = "1.320845,0.544390,0.052764,-0.026570,0.823644,0.010785,-0.020285,-0.060307,0.279651",
    val preset_01_ns: String = "1.204193,0.336086,0.037139,-0.016328,0.897744,0.009205,-0.015060,-0.047647,0.445055",
    val preset_02_ns: String = "1.105672,0.158764,0.024404,-0.007599,0.961665,0.008176,-0.010927,-0.038161,0.572205",
    val preset_03_ns: String = "1.066964,0.104910,0.013993,-0.005057,0.971570,0.004212,-0.006035,-0.020349,0.768831",

    val enable_blf: Boolean = false,
    val preset_blf: Int = 1,
    val mode_blf: Int = 0, // 0 - Always; 1 - Sunset/Sunrise; 2 - Manual set
    val from_blf: String = "21:42",
    val till_blf: String = "05:32",
    val preset_00_blf: String = "0.8,0.1,0.1,0,0.05,0,0,0,0.05",
    val preset_01_blf: String = "0.8,0.05,0.05,0,0,0,0,0,0",
    val preset_02_blf: String = "0.8,0.025,0.025,0,0,0,0,0,0",
    val preset_03_blf: String = "0.75,0.02,0.02,0,0,0,0,0,0",
    val preset_04_blf: String = "0.7,0.015,0.015,0,0,0,0,0,0",
    val preset_05_blf: String = "0.65,0,0,0,0,0,0,0,0",
    val preset_06_blf: String = "0.55,0,0,0,0,0,0,0,0",
)