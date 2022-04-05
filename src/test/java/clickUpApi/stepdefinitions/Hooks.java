package clickUpApi.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import clickUpApi.helpers.TestCaseContext;


public class Hooks {

    @Before
    public void beforeEveryScenario(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("Test is being executed");
    }

    @After
    public void afterEveryScenario(){

        System.out.println("Scenario is being finished");
    }
}