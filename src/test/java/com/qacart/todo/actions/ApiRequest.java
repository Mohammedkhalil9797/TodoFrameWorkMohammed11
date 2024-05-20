package com.qacart.todo.actions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.concurrent.TimeUnit;

public class ApiRequest {
    public static boolean waitForApiSuccess(String url) {
        long startTime = System.currentTimeMillis();
        long timeoutMillis = TimeUnit.SECONDS.toMillis(5); // 30 seconds timeout
        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            if (isApiRequestSuccessful(url)) {
                return true;
            }
            // Sleep for a short interval before checking again
            try {
                Thread.sleep(1000); // Check every 1 second
            } catch (InterruptedException e) {
                // Handle interruption
                Thread.currentThread().interrupt();
            }
        }
        return false; // Timeout reached
    }

    // Method to check if the API request returns status code 200
    public static boolean isApiRequestSuccessful(String url) {
        RequestSpecification request = RestAssured.given();
        Response response = request.get(url);
        return response.getStatusCode() == 200;
    }
}
