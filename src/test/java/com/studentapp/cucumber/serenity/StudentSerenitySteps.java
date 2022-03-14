package com.studentapp.cucumber.serenity;

import com.restassured.model.StudentClass;
import com.studentapp.utils.ReUseableSpecfications;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

import java.util.List;

public class StudentSerenitySteps {

    @WithTags({
            @WithTag("Student feature: Smoke test 2"),
            @WithTag("Student feature: POSITIVE")
    })
    @Title("Create new users")
    @Step("This test will create new student with Firstname: {0} into the list")
    public ValidatableResponse CreateStudent(String Firstname, String lastname, String email, String program, List<String> courses){
        StudentClass student = new StudentClass();
        student.setFirstName(Firstname);
        student.setLastName(lastname);
        student.setProgramme(program);
        student.setEmail(email);
        student.setCourses(courses);

        return SerenityRest.rest().given()
                .spec(ReUseableSpecfications.getGenericRequestSpec())
                .log()
                .all()
                .when()
                .body(student)
                .post()
                .then()
                .log()
                .all();
    }

    @Step("This test will be update with firstname: {0} and lastname: {1} into the list")
    public ValidatableResponse UpdateStudent(String firstname, String lastname, String email, String program, List<String> courses){
        int studentID = 99;
        StudentClass student = new StudentClass();
        student.setFirstName(firstname);
        student.setLastName(lastname);
        student.setProgramme(program);
        student.setEmail(email);
        student.setCourses(courses);
        return   SerenityRest.rest().given()
                //.contentType(ContentType.JSON)==
                .spec(ReUseableSpecfications.getGenericRequestSpec())
                .log()
                .all()
                .when()
                .body(student)
                .put("/" + studentID)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
