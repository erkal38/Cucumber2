package com.modaNisaTask.pages;

import com.modaNisaTask.utilities.BrowserUtils;
import com.modaNisaTask.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class  BasePage {

    @FindBy(xpath = "//span/strong")
    public WebElement anyItemList;

    @FindBy(xpath = "//header/input[1]")
    public WebElement sendElementToList;

    @FindBy(xpath = "//input[@class='toggle']")
    public WebElement checkboxElement;

    @FindBy(xpath = "//ul[@class='todo-list']//li")
    public WebElement checkedElement;

    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
    }
    public void emptyList() {
        Dimension actualResult=anyItemList.getSize();
        Dimension expectedResult=new Dimension(0,0);
        Assert.assertEquals(expectedResult,actualResult);
    }
    public void sendByObject(String string){
        sendElementToList.click();
        sendElementToList.sendKeys(string);
        sendElementToList.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);
    }
    public List<WebElement> viewElement() {
        return Driver.get().findElements(By.xpath("//li/div/label"));
    }
    public void setCheckboxElement(){
       checkboxElement.click();
        BrowserUtils.waitFor(3);
    }
    public String checkedElementDone(){
        return checkedElement.getAttribute("class");
    }
}
