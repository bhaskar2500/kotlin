package com.gl.kotsetup.models

import java.sql.Timestamp

data class Show (
    val id: Int,
    val hall : Hall ,
    val seat : Seat,
    val startTime: String,
    val endTime: String
    ){
    constructor(): this(1,Hall(),Seat(1), "",""){}
}
