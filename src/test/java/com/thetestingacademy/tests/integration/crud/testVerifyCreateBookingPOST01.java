package com.thetestingacademy.tests.integration.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class testVerifyCreateBookingPOST01 extends BaseTest {

    @Owner("Preeti Silla")
    @TmsLink("")
    @Link(name = "Link to TC", url = "")
    @Issue("JIRA_RBT-4")
    @Test
    public void testVerifyCreateBookingPOST01(){

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured
                    .given(requestSpecification)
                    .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //RestAssured validation
        validatableResponse.body("booking.firstname", Matchers.equalTo("Jim"));

        BookingResponse bookingResponse = payloadManager.getBookingResponseJson(response.asString());

        //AssertJ
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Jim");
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotBlank().isEqualTo("Jim");

        //TestNG Assertions
        assertActions.verifyStatusCode(response,200);
        assertActions.verifyResponse(bookingResponse.getBooking().getFirstname(),"Jim","Verify Firrstname");

    }
}
