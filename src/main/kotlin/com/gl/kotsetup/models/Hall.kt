package com.gl.kotsetup.models

data class Hall(val id : Int, val seats: List<HallSeat> = emptyList() ){
    constructor() : this(1, emptyList())
}
data class HallSeat(val seatNumber : Int, val seatType : SeatType, val hall : Hall){
    constructor(): this(1, SeatType.GOLD, Hall()){}
}

enum class SeatType { VIP, PLATINUM, GOLD}