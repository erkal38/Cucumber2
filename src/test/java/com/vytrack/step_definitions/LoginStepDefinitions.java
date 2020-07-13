package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("I open browser and navigate login page");
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user enter the driver information")
    public void the_user_enter_the_driver_information() {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertEquals("Verify is Title","Dashboard",Driver.get().getTitle());
    }

    @When("the user enter the sales manager information")
    public void the_user_enter_the_sales_manager_information() {
       new LoginPage().login(ConfigurationReader.get("sales_manager_username"),ConfigurationReader.get("sales_manager_password"));
    }
    @When("the user enter the store manager information")
    public void the_user_enter_the_store_manager_information() {
      new LoginPage().login(ConfigurationReader.get("store_manager_username"),ConfigurationReader.get("store_manager_password"));
        BrowserUtils.waitFor(3);
    }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        new LoginPage().login(username,password);
        BrowserUtils.waitFor(3);
    }
    @Then("the title contains {string}")
    public void the_title_contains(String string) {
        new DashboardPage().waitUntilLoaderScreenDisappear();
       Assert.assertEquals(string,Driver.get().getTitle());

    }
 }
