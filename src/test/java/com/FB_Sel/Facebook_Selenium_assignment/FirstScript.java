package com.FB_Sel.Facebook_Selenium_assignment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("pass"));
        WebElement login = driver.findElement(By.name("login"));
        Thread.sleep(2000);
        email.sendKeys("abcxyz123@gmail.com");
        pass.sendKeys("12345");
               
        Thread.sleep(2000);
        
        login.click();

       // WebElement message = driver.findElement(By.id("message"));
       // message.getText();
       
        //capture screenshot
        
        TakesScreenshot scrShot =  ((TakesScreenshot)driver);
        
        File srcFile = scrShot. getScreenshotAs(OutputType.FILE);
        
        File destFile = new File("fb-sel-test-report.jpg");
        
        FileUtils.copyFile(srcFile, destFile); 
        driver.quit();
    }
}