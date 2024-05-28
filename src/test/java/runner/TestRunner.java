package runner;

import org.testng.annotations.BeforeClass;

import config.PropertiesLoader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/resources/features"},
    glue = {"steps"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void init() {
        PropertiesLoader.loadProperties("config.properties");
    }
    
}

