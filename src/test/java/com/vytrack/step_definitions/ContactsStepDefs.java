package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String string) {
        Driver.get().get(ConfigurationReader.get("url"));
        String username=null;
        String password=null;
        if(string.equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");
        }else if(string.equals("sales manager")){
            username=ConfigurationReader.get("sales_manager_username");
            password=ConfigurationReader.get("sales_manager_password");

        }else if(string.equals("store manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }
        new LoginPage().login(username,password);

    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String>menuOptions) {
        new ContactsPage().waitUntilLoaderScreenDisappear();
        List<String> elementsText = BrowserUtils.getElementsText(new DashboardPage().menuOptions);
        Assert.assertEquals(menuOptions,elementsText);
        System.out.println(menuOptions);


    }
    @Then("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String>userInfo) {
        BrowserUtils.waitFor(3);
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
        String fullname = userInfo.get("firstname") +" "+ userInfo.get("lastname");
        System.out.println(fullname);
        String actualUserName = new DashboardPage().getUserName();
        Assert.assertEquals("username verification is Ok",fullname,actualUserName);
        System.out.println("verify is OK");

    }
}
