package com.studentapp.junit.studentsIdInfo;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Ignore
@RunWith(SerenityRunner.class)
public class StudentInforTest {
    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost:8085/student";
    }
    @Test
    public void getAllStudent() {
                SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200);


    }

    @Test
    public void thisIsFail(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(500);

    }
    @Pending
    @Test
    public void thisIsPending(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(500);
    }
    @Ignore
    @Test
    public void thisIsSkip(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(500);
    }
    @Title("This is test case involves error")
    @Test
    public void thisIsError(){
        System.out.println("This is an error: "+(5/0));
    }
    @Test
    public void fileDoesNotExist() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }
    @Manual
    @Test
    public void thisIsManual(){

    }
}
