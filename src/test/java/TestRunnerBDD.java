import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java",
        glue = {"stepDefinitionBDD"},
        plugin = {"pretty","html:target/CucumberReport.html","json:target/report.json"}
)
public class TestRunnerBDD extends AbstractTestNGCucumberTests {

}
