package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

       driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);
      //close the currentTab
     //   driver.close();

        //giving new browser tab
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);
      // close all tabs
        driver.close();



    }
}
