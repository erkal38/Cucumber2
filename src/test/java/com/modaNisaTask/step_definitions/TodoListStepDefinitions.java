package com.modaNisaTask.step_definitions;

import com.modaNisaTask.pages.BasePage;
import com.modaNisaTask.utilities.BrowserUtils;
import com.modaNisaTask.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class TodoListStepDefinitions {
    BasePage sendEl = new BasePage();
    BasePage viewEl = new BasePage();
    BasePage checkBox = new BasePage();
    BasePage checkedEl = new BasePage();
    BasePage deleteEl = new BasePage();
    BasePage stringEl = new BasePage();
    BasePage emptyEl = new BasePage();
    BasePage emptyPage = new BasePage();

    @Given("Empty ToDo list")
    public void empty_ToDo_list() {

        emptyPage.emptyList();
    }

    @When("I write to {string} and press enter")
    public void i_write_to_and_press_enter(String string) {

        sendEl.sendByObject(string);
    }

    @Then("I should see {string} item in ToDo list")
    public void i_should_see_item_in_ToDo_list(String string) {

        Assert.assertEquals(string, viewEl.viewElement().get(0).getText());
    }

    @Given("ToDo list with {string} item")
    public void todo_list_with_item(String string) {

        BrowserUtils.waitFor(2);
        sendEl.sendByObject(string);
    }

    @Then("I should see {string} item inserted to ToDo list below {string}")
    public void i_should_see_item_inserted_to_ToDo_list_below(String string, String string2) {

        System.out.println("0.index " + string2);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(string, viewEl.viewElement().get(1).getText());
        System.out.println("1.index " + string);
    }

    @When("I click on checkbox next to {string} item")
    public void i_click_on_checkbox_next_to_item(String string) {

        checkBox.setCheckboxElement();
        System.out.println(string + " is clicked");
    }

    @Then("I should see {string} item marked as DONE")
    public void i_should_see_item_marked_as_DONE(String string) {

        Assert.assertEquals("todo completed", checkedEl.checkedElementDone());
        Assert.assertEquals(string, checkedEl.checkedElement.getText());
    }

    @Given("ToDo list with marked item")
    public void todo_list_with_marked_item() {

        BrowserUtils.waitFor(2);
        sendEl.sendByObject("buy some milk");
        checkBox.setCheckboxElement();
        Assert.assertEquals("todo completed", checkedEl.checkedElementDone());
    }

    @When("I click on checkbox next to item")
    public void i_click_on_checkbox_next_to_item() {

        checkBox.setCheckboxElement();
        BrowserUtils.waitFor(2);
    }

    @Then("I should see {string} item marked as UNDONE")
    public void i_should_see_item_marked_as_UNDONE(String string) {
        Assert.assertEquals("todo", checkedEl.checkedElementDone());
        Assert.assertEquals(string, checkedEl.checkedElement.getText());
    }

    @When("I click on delete button next to {string} item")
    public void i_click_on_delete_button_next_to_item(String string) {
        Actions action = new Actions(Driver.get());
        action.moveToElement(stringEl.deleteElement).perform();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(stringEl.deleteElement.getText(), string);
        deleteEl.deleteButton();
    }

    @Then("List should be empty")
    public void list_should_be_empty() {

        emptyEl.setEmptyListElement();
    }

    @Given("ToDo list with following items in order")
    public void todo_list_with_following_items_in_order(List<String> string) {
        sendEl.sendEleList(string);
        List<String> terms = new ArrayList<>();
        for (int i = 0; i < string.size(); i++) {
            String str1 = sendEl.viewElement().get(i).getText();
            terms.add(str1);
        }
        Assert.assertEquals(string, terms);
    }
}
