package com.studentapp.cucumber.steps;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

import java.util.ArrayList;

public class StudentSteps {

    @Steps
    StudentSerenitySteps steps;

    @When("The user sent GET request to the list endpoint, then status code return two thousand")
    public void theUserSentGETRequestToTheListEndpointThenStatusCodeReturnTwoThousand() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @When("create Student with some information {string} {string} {string} {string} {string}")
    public void createStudentWithSomeInformation(String firstname, String lastname, String email, String program, String course) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add(course);
        steps.CreateStudent(firstname, lastname, email, program, courses)
                .assertThat()
                .statusCode(201);
    }


    @Then("The student is added with {string}")
    public void theStudentIsAddedWith(String email) {
        System.out.println(email);


    }


}
