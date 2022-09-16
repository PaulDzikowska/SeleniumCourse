package myStore;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/address-add.feature",
        plugin = {"pretty","html:out"})

public class Zad1Cucumber {
}
