package com.gl.kotsetup.models
data class Booking(
    val customer: Customer,
    val show : Show,
    val status : BookingStatus = BookingStatus.PENDING
){
    constructor():this(Customer("default","default@email.com"),Show())
}

