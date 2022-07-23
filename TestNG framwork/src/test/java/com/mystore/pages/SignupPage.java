package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {


    WebDriver driver;

    By SignUplink = By.xpath("//*[@id=\"anonSignup\"]/a");
    By PhoneNumber = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/input");
    By Fullnametxt = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[2]/div[1]/input");
    By Passwordtxt = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[3]/input");
    By Gendertxt = By.xpath("//*[@id=\"gender\"]/span/span");
    By Monthtxt = By.id("month");
    By monthselect = By.xpath("/html/body/div[7]/div/div/ul/li[7]");
    By Daytxt = By.id("day");
    By daySelect = By.xpath("/html/body/div[7]/div/div/ul/li[6]");
    By Yeartxt = By.id("year");
    By LgnBtn = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[2]/div[3]/button");


    public SignupPage(WebDriver driver) {

        this.driver = driver;
    }


    public String getTitle() {

        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickSignUplink() {
        driver.findElement(SignUplink).click();
    }

    public void EnterPhoneNumber(String txt) {
        driver.findElement(PhoneNumber).sendKeys(txt);
    }

    public void EnterFullName(String fname) {
        driver.findElement(Fullnametxt).sendKeys(fname);
    }

    public void Enterpassword(String passw) {
        driver.findElement(Passwordtxt).sendKeys(passw);
    }

    public void Month() {
        driver.findElement(Monthtxt).click();


    }

    public void MonthSelect()  {

        driver.findElement(monthselect).click();
    }

    public void Day()  {

        driver.findElement(Daytxt).click();

    }

    public void DaySelect() {
        driver.findElement(daySelect).click();


    }
//        WebElement dropdown = driver.findElement(Daytxt);
//        dropdown.click();
//        Select selectObj = new Select(dropdown);
//        selectObj.selectByValue(Day);

//        driver.findElement(By.xpath("//*[text()[contains(., '"+Day+"')]]")).click();


    //}

    public void Year() throws InterruptedException {

        driver.findElement(Yeartxt).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[7]/div/div/ul/li[18]")).click();

    }

    public void Gender() throws InterruptedException {
        driver.findElement(Gendertxt).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[7]/div/div/ul/li[1]")).click();

    }

    public void lgnBtn()
    {
        driver.findElement(LgnBtn).click();
    }

}
        //}





