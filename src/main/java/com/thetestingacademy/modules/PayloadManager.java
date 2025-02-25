package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingResponse;
import com.thetestingacademy.pojos.Bookingdates;

public class PayloadManager {

    Gson gson;

    public String createPayloadBookingAsString(){

        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;
    }

    public BookingResponse getBookingResponseJson(String responseString){

        gson = new Gson();
        BookingResponse br = gson.fromJson(responseString,BookingResponse.class);
        return br;
    }

}
