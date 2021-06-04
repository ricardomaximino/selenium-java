package com.brasajava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutorialPureSelenium {

    private WebDriver driver;

    @BeforeAll
    public static void beforeAll() throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testOne() {
        driver.get("https://google.com");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("Selenium");


    }
}
