package com.studentapp.cucumber;


import com.studentapp.testbase.TestBase;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Student.feature", tags = "@two")
public class StudentRunnerTest extends TestBase {

}
