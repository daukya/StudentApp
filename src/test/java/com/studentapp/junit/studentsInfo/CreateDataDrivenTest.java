package com.studentapp.junit.studentsInfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@UseTestDataFrom("testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateDataDrivenTest extends TestBase {

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    private String firstname;
    private String lastname;
    private String email;
    private String program;
    private String course;


    @Steps
    StudentSerenitySteps steps;

    @WithTags({
            @WithTag("Student feature: Smoke test"),
            @WithTag("Student feature: POSITIVE")
    })
    @Title("Datadriven test for create multiple student at the same time.")
    @Test
    public void createMultipleStudents (){
        ArrayList<String> courses = new ArrayList<>();
        courses.add(course);
        steps.CreateStudent(firstname, lastname, email, program, courses)
                .statusCode(201);
    }
}
