package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class NavigationMenuStepDefs {
    @Then("the user navigates to Fleet Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {

    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {

    }

    @Then("the user navigates Marketing, Campaings")
    public void the_user_navigates_Marketing_Campaings() {

    }

    @Then("the title should be Campaings")
    public void the_title_should_be_Campaings() {

    }

    @Then("the user navigates Activities, Calendar Events")
    public void the_user_navigates_Activities_Calendar_Events() {

    }

    @Then("the title should be Calendars")
    public void the_title_should_be_Calendars() {

    }

    @Then("the user navigates {string}, {string}")
    public void the_user_navigates(String string, String string2) {
     new DashboardPage().navigateToModule(string,string2);
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNumber) {
        new ContactsPage().waitUntilLoaderScreenDisappear();
        Integer actualPageNumber = Integer.parseInt(new ContactsPage().pageNumber.getAttribute("Value"));
        Assert.assertEquals(expectedPageNumber,actualPageNumber);

    }
}
