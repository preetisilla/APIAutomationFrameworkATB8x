package com.thetestingacademy.tests.integration.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class TestIntegrationSample {
    @Test(groups = "qa",priority = 1)
    @Owner("Preeti Silla")
    @Description("Test to Create Booking")
    public void test_create_booking(){
        System.out.println("Create booking");
    }


    @Test(groups = "qa",priority = 2)
    @Owner("Preeti Silla")
    @Description("Test to Get Booking")
    public void test_get_booking(){
        System.out.println("Get booking");
    }

    @Test(groups = "qa",priority = 3)
    @Owner("Preeti Silla")
    @Description("Test to Update Booking")
    public void test_update_booking(){
        System.out.println("Update booking");
    }

    @Test(groups = "qa",priority = 4)
    @Owner("Preeti Silla")
    @Description("Test to Delete Booking")
    public void test_delete_booking(){
        System.out.println("Delete booking");
    }
}
