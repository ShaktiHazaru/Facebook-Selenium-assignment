package com.FB_Sel.Facebook_Selenium_assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello World!");
        
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); 
        WebDriver driver = new ChromeDriver(options);

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
