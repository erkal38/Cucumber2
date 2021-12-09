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
    BasePage sendEl=new BasePage();
    BasePage viewEl=new BasePage();
    BasePage checkBox=new BasePage();
    BasePage checkedEl=new BasePage();

    @Given("Empty ToDo list")
    public void empty_ToDo_list() {
        Driver.get().get(ConfigurationReader.get("url"));
        BasePage emptyPage=new BasePage();
        emptyPage.emptyList();
    }
    @When("I write {string} to text box and press enter")
    public void i_write_to_text_box_and_press_enter(String string) {
        sendEl.sendByObject(string);
    }
    @Then("I should see {string} item in ToDo list")
    public void i_should_see_item_in_ToDo_list(String string) {
        Assert.assertEquals(string,viewEl.viewElement().get(0).getText());

    }
    @Given("ToDo list with {string} item")
    public void todo_list_with_item(String string) {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);
        sendEl.sendByObject(string);
    }
    @Then("I should see {string} item inserted to ToDo list below {string}")
    public void i_should_see_item_inserted_to_ToDo_list_below(String string, String string2) {
        System.out.println("0.index "+ string2);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(string,viewEl.viewElement().get(1).getText());
        System.out.println("1.index "+string);
    }
    @When("I click on checkbox next to {string} item")
    public void i_click_on_checkbox_next_to_item(String string) {
        checkBox.setCheckboxElement();
        System.out.println(string+" is clicked");
    }
    @Then("I should see {string} item marked as DONE")
    public void i_should_see_item_marked_as_DONE(String string) {
        Assert.assertEquals("todo completed",checkedEl.checkedElementDone());
        Assert.assertEquals(string,checkedEl.checkedElement.getText());
    }
}
