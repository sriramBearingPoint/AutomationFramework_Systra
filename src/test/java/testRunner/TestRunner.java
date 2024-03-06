package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/",
        glue={"stepDefinitions","hooks"},
        tags = "@Reg or @SmokeTest",
        publish=true,
        plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/CucumberReports/CucumberReport.html"})


public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
