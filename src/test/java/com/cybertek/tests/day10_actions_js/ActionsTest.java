package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    /* @AfterMethod
     public void tearDown() throws InterruptedException {
         //Thread.sleep(2000);
         driver.quit();
     }*/
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        //Actions --> class that contains all the user interactions
        //how to create actions object --> passing driver as a constructor

        Actions action=new Actions(driver);

        //perform() --> perform the action, complete the action
        //moveToElement --> move you mouse to webelement(hover over)
        Thread.sleep(2000);
        action.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.xpath("(//a[.='View profile'])[1]"));
        Assert.assertTrue(viewLink.isDisplayed(),"verify viewLink is displayed");
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions action= new Actions(driver);

        /*List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }*/
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

         WebElement source= driver.findElement(By.id("draggable"));
         WebElement target= driver.findElement(By.id("droptarget"));

        Thread.sleep(3000);
        action.dragAndDrop(source,target).perform();

    }
    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions action= new Actions(driver);

        /*List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }*/
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droptarget"));

        action.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();


    }
}
