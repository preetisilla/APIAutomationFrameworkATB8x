package com.thetestingacademy.tests.integration.crud;

import com.google.gson.Gson;
import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestIntegrationFlow extends BaseTest {

    @Test(groups = "integration",priority=1)
    @Owner("Preeti Silla")
    @Description("Create Booking")
    public void testCreateBooking(ITestContext iTestContest){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //RestAssured validation
        validatableResponse.body("booking.firstname", Matchers.equalTo("Jim"));

        BookingResponse bookingResponse = payloadManager.getBookingResponseJson(response.asString());
        iTestContest.setAttribute("bookingid",bookingResponse.getBookingid());
    }

    @Test(groups = "integration", priority=2)
    @Owner("Preeti Silla")
    @Description("Get Booking by Id")
    public void testVerifyBooking(ITestContext iTestContest){
        Integer bookingId = (Integer) iTestContest.getAttribute("bookingid");
        String basePathGet = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingId;

        requestSpecification.basePath(basePathGet);
        response = RestAssured
                .given(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJson(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isEqualTo("Jim");
    }

    @Test(groups = "integration",priority=3)
    @Owner("Preeti Silla")
    @Description("Update Booking")
    public void testUpdateBooking(ITestContext iTestContest){
        Integer bookingId = (Integer) iTestContest.getAttribute("bookingid");
        String token = getToken();
        iTestContest.setAttribute("token",token);
        String basePathUpdate = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingId;
        String updatePayloadString = payloadManager.fullUpdatePayloadAsString();

        requestSpecification.basePath(basePathUpdate);

        response = RestAssured.given(requestSpecification)
                .cookie("token",token)
                .when().body(updatePayloadString).put();

        //response = requestSpecification.when().log().all().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJson(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isEqualTo("Preeti");

    }
    @Test(groups = "integration",priority=4)
    @Owner("Preeti Silla")
    @Description("Delete Booking")
    public void testDeleteBooking(ITestContext iTestContest) {
        String token = (String) iTestContest.getAttribute("token");
        Integer bookingId = (Integer) iTestContest.getAttribute("bookingid");

        String basePathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingId;

        requestSpecification.basePath(basePathDelete);
        response = RestAssured
                .given(requestSpecification)
                .cookie("token",token)
                .when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }

}
