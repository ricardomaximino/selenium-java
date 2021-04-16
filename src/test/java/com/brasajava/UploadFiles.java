package com.brasajava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UploadFiles {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x969");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("https://amazon.es");
    }

    @Test
    public void test() throws InterruptedException {
        String url = "http://nervgh.github.io/pages/angular-file-upload/examples/simple/";

        driver.navigate().to(url);

        WebElement inputFile = driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div/div[2]/div[1]/input[1]"));
        System.out.println(inputFile.isDisplayed());
        System.out.println(inputFile.isEnabled());
        System.out.println(inputFile.isSelected());
        inputFile.sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
        Thread.sleep(50000);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
