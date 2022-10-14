package com.gl.kotsetup.models

data class Seat( val id : Int, val hallSeat: HallSeat, val show: Show, val booking : Booking, val occupied: Boolean){
    constructor(id : Int) : this(1, HallSeat(), Show(), Booking(), false){}
}