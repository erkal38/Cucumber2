package com.modaNisaTask.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //it is for run files with Junit.
@CucumberOptions(
        plugin = {"json:target/cucumber.json","html:target/default-html-reports","rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue= "com/modaNisaTask/step_definitions",  //to look for the step_definitions
        dryRun = false,
        strict = true,
        tags = "@add"

)
public class CukesRunner {

}
