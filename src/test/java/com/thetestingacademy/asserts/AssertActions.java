package com.thetestingacademy.asserts;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import static org.assertj.core.api.Assertions.*;

public class AssertActions {
    //Common assertions

    public void verifyResponse(String actual, String expected, String description){
        assertEquals(actual,expected,description);
    }

    public void verifyResponse(int actual, int expected, String description){
        assertEquals(actual,expected,description);
    }

    public void verifyStatusCode(Response response, Integer expected){
        assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStringKey(String expectKey,String actualKey){
        assertThat(expectKey).isEqualTo(actualKey);
    }
}
