package robothack.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, glue = "robothack.feature.ui")
public class UiLayerFeatureTest {
}
