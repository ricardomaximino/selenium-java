package com.brasajava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FrontOfficeChrome {


    private WebDriver driver;

    @Before
    public void setupChrome(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920x969");
        options.addArguments("user-data-dir=C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testChrome() throws InterruptedException {
        String url = "https://ccvld-apt701:8443/sp-ui-tmefiling/oneform.htm";

        driver.navigate().to(url);

        Thread.sleep(1000);
        WebElement cookies = driver.findElement(By.id("policyModalOk"));
        cookies.click();
        Thread.sleep(1000);

        WebElement representative = driver.findElement(By.id("representativeTrigger"));

        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView(true);", representative);

        representative.click();

        Thread.sleep(1000);
        WebElement representativeType = driver.findElement(By.id("reptype"));

        Select select = new Select(representativeType);
        select.selectByValue("EMPLOYEE_REPRESENTATIVE");
        Thread.sleep(1000);

        WebElement optionSection = driver.findElement(By.id("fileDocumentAttachment"));
        WebElement option = driver.findElement(By.id("copy-upload-representativeAttachment"));
        j.executeScript("arguments[0].scrollIntoView(true);", optionSection);
        Thread.sleep(1000);
        j.executeScript("document.querySelector('input[id=copy-upload-representativeAttachment]').click()");

        WebElement btn = driver.findElement(By.cssSelector("span.btn.btn-default.fileinput-button"));
        btn.click();

        Thread.sleep(1000);
        WebElement fileInput = driver.findElement(By.name("fileWrapper.pathFilename"));
//        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"fileUpload\"]"));
        System.out.println(fileInput.isDisplayed());
        System.out.println(fileInput.isEnabled());
        System.out.println(fileInput.isSelected());
//        j.executeScript("arguments[0].setAttribute('style.display','block')");
        fileInput.clear();
//        j.executeScript("arguments[0].setAttribute('value', 'C:\\\\Users\\\\ricardomaximino\\\\work\\\\git\\\\src\\\\main\\\\resources\\\\files\\\\preview.pdf')", fileInput);
//        j.executeScript("arguments[0].setAttribute('value', 'C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf')", fileInput);
        fileInput.sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
//
        System.out.println(fileInput.getAttribute("type"));
        System.out.println(fileInput.getAttribute("value"));
        System.out.println(fileInput.getAttribute("title"));
        System.out.println(fileInput.getAttribute("id"));
        Thread.sleep(100000);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
