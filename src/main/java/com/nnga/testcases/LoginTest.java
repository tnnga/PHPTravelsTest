package com.nnga.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Watchable;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Setup(){
        driver.get("https://phptravels.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test (priority = 0)
    public void ElementTest(){
        WebElement elements = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]"));
        ScrollAndClick(elements);

        CheckHeader("Elements");
    }

    public void ScrollAndClick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");

        webElement.click();
    }
    public void SendKey(WebElement element, String text){
        Assert.assertTrue(element.isDisplayed() && element.isEnabled());
        element.clear();
        element.sendKeys(text);
    }
    public void Click(WebElement element){
        Assert.assertTrue(element.isDisplayed() && element.isEnabled());
        element.click();
    }
    public void CheckHeader(String text){
        String header = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
        Assert.assertEquals(header, text, "Khong phai trang " + text);

    }
    @AfterTest
    public void End(){
        Sleep(3000);
        //driver.close();
    }
    public void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
