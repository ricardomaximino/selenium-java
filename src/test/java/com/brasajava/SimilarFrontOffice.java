package com.brasajava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class SimilarFrontOffice {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920x969");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void upload() throws InterruptedException {
        String filePath = "C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf";
        String url = "https://convertio.co/es/";

        driver.navigate().to(url);

        WebElement inputFile = driver.findElement(By.id("pc-upload-add"));
        System.out.println(inputFile.getAttribute("type"));
        System.out.println(inputFile.getAttribute("value"));
        System.out.println(inputFile.getAttribute("title"));
        System.out.println(inputFile.getAttribute("id"));
        System.out.println(inputFile.isDisplayed());
        System.out.println(inputFile.isEnabled());
        System.out.println(inputFile.isSelected());
        System.out.println(inputFile.toString());
        inputFile.sendKeys(filePath);

        Thread.sleep(50000);


    }

    @After
    public void teardown(){
        driver.quit();
    }
}
