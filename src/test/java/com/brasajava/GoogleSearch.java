package com.brasajava;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
    public void test(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        String text = "Ricardo Maximino Gonçalves de Moraes";
        searchBox.sendKeys(text);
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(text + " - Buscar con Google",driver.getTitle());
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
