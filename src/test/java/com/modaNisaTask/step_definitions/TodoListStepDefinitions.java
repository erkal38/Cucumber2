package com.modaNisaTask.step_definitions;

import com.modaNisaTask.pages.BasePage;
import com.modaNisaTask.utilities.BrowserUtils;
import com.modaNisaTask.utilities.ConfigurationReader;
import com.modaNisaTask.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TodoListStepDefinitions {
    @Given("Empty ToDo list")
    public void empty_ToDo_list() {
        Driver.get().get(ConfigurationReader.get("url"));
        BasePage emptyPage=new BasePage();
        emptyPage.emptyList();
    }
    @When("I write {string} to <text box> and press <enter>")
    public void i_write_to_text_box_and_press_enter(String string) {
        BasePage sendEl=new BasePage();
        sendEl.sendByObject(string);
        sendEl.sendElementToList.click();
    }
    @Then("I should see {string} item in ToDo list")
    public void i_should_see_item_in_ToDo_list(String string) {
        BasePage viewEl=new BasePage();
        Assert.assertEquals(viewEl.viewElement(),string);
    }
    @Given("ToDo list with {string} item")
    public void todo_list_with_item(String string) {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(4);
        BasePage viewEl=new BasePage();
        Assert.assertEquals(viewEl.viewElement(),string);
    }
 }
