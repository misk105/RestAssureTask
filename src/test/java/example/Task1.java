package example;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {

    @Test
    public void testTodosAPI() {
        
        for (int id = 1; id <= 6; id++) {
        	
        	System.out.println("_________________________________________________\n");
        	
            System.out.println("ID: "+id);
            
            Assert.assertEquals(given()
                    .when()
                    .get("https://jsonplaceholder.typicode.com/todos/"+id).getStatusCode(), 200);
            
            System.out.println("Status Code: " + given()
            .when()
            .get("https://jsonplaceholder.typicode.com/todos/"+id).getStatusCode());
            
            Assert.assertFalse(given()
                    .when()
                    .get("https://jsonplaceholder.typicode.com/todos/"+id).asString().isEmpty());
            System.out.println("Response is not empty: true");
            
            System.out.println("userId: " + given()
            .when()
            .get("https://jsonplaceholder.typicode.com/todos/"+id).jsonPath().getInt("userId"));
            
            System.out.println("id: " + given()
            .when()
            .get("https://jsonplaceholder.typicode.com/todos/"+id).jsonPath().getInt("id"));
            
            System.out.println("title: " + given()
            .when()
            .get("https://jsonplaceholder.typicode.com/todos/"+id).jsonPath().getString("title"));
            
        }
        System.out.println("_________________________________________________\n");
    }
}