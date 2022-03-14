package com.studentapp.junit.studentsInfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReUseableSpecfications;
import com.studentapp.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) //phải đặt bên ngoài class
@RunWith(SerenityRunner.class)
public class StudentsCRUDTest extends TestBase {
    //khai báo biến ở đây để gán cho giá trị tham chiếu
    static String firstname = "Tuyen" + TestUtils.getRandomValue();
    static String lastname = "Le";
    static String program = "Financial Analysis";
    static String email = TestUtils.getRandomValue() + "lenguyenthanhtuyen97@gmail.com";
    static String studentID = "100";

    @Steps
    StudentSerenitySteps steps;
    @Title("This test will create new student")
    @Test //create student
    public void tc01() {
        //create array
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Accounting");
        courses.add("Statistics");
        System.out.println(courses);

        steps.CreateStudent(firstname,lastname,email,program,courses)
                .statusCode(201) //status add thành công là 201
                .spec(ReUseableSpecfications.getGenericResponseSpec());

    }

    @WithTags({
            @WithTag("Student feature: Smoke test"),
            @WithTag("Student feature: NEGATIVE")
    })
    @Title("Verify that updating user successfully")
    @Test
    public void tc03() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Accounting");
        courses.add("Statistics");
        System.out.println(courses);
       steps.UpdateStudent("tran huu thanh","huu",email,"toan hoc",courses)
                        .statusCode(200);


    }

    @Title("Verify that delete student and if student was delete successfully")
    @Test
    public void deleteStudent(){
        SerenityRest.rest().given()
        .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .delete("/"+studentID)
                .then()
                .log()
                .all()
                .statusCode(204);
        SerenityRest.rest().given()
                .log()
                .all()
                .when()
                .get("/"+100)
                .then()
                .log()
                .all()
                .statusCode(404);

    }


}
