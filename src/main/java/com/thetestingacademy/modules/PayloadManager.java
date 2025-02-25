package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.*;

import java.awt.print.Book;

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

    public Booking getResponseFromJson(String responseString){
        Booking booking = gson.fromJson(responseString,Booking.class);
        return booking;
    }

    public String createTokenPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken();
    }

    public String fullUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Preeti");
        booking.setLastname("Silla");
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

}
