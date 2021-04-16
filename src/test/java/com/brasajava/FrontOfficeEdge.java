package com.brasajava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class FrontOfficeEdge {


    private WebDriver driver;

    @Before
    public void setupEdge(){
//        System.setProperty("webdriver.edge.verboseLogging","true");
        System.setProperty("webdriver.edge.driver","./src/main/resources/webdrivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.setCapability("args","['headless', 'start-maximized','--window-size=1920x969']");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testEdge() throws InterruptedException {
        String url = "https://localhost:8443/sp-ui-tmefiling/oneform.htm";
//        String url = "https://ccvld-apt701:8443/sp-ui-tmefiling/oneform.htm";

        driver.navigate().to(url);

        Thread.sleep(9000);
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
//        WebElement fileInput = driver.findElement(By.name("fileWrapper.pathFilename"));
//        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"fileUpload\"]"));
        WebElement fileInput = driver.findElement(By.id("fileUpload"));
        System.out.println(fileInput.isDisplayed());
        System.out.println(fileInput.isEnabled());
        System.out.println(fileInput.isSelected());
        System.out.println(fileInput.toString());
//        fileInput.clear();
        System.out.println("Waiting...");
        Thread.sleep(10000);
        j.executeScript("FU.functions.enableFileUpload()");
        WebElement currentDocumentId = driver.findElement(By.name("currentDocumentId"));
//        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(fileInput)).sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
        j.executeScript("arguments[0].setAttribute('value', 'C:\\\\Users\\\\ricardomaximino\\\\work\\\\git\\\\src\\\\main\\\\resources\\\\files\\\\preview.pdf')", currentDocumentId);
        j.executeScript("arguments[0].setAttribute('value', 'C:\\\\Users\\\\ricardomaximino\\\\work\\\\git\\\\src\\\\main\\\\resources\\\\files\\\\preview.pdf')", fileInput);
        fileInput.sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
//
        System.out.println(fileInput.getAttribute("type"));
        System.out.println(fileInput.getAttribute("value"));
        System.out.println(fileInput.getAttribute("title"));
        System.out.println(fileInput.getAttribute("id"));
        Thread.sleep(5000);
    }

    private void certificate() throws InterruptedException {
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.id("details-button"));
        button.click();
        Thread.sleep(1000);

        WebElement link = driver.findElement(By.id("proceed-link"));
        link.click();
    }

    private void acceptCookies() throws InterruptedException {
        Thread.sleep(1000);
        WebElement cookies = driver.findElement(By.id("policyModalOk"));
        cookies.click();
        Thread.sleep(1000);
    }

    @Test
    public void testEdgeS() throws InterruptedException {
        String url = "https://localhost:8443/sp-ui-tmefiling/oneform.htm";
//        String url = "https://ccvld-apt701:8443/sp-ui-tmefiling/oneform.htm";

        driver.navigate().to(url);

        acceptCookies();

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
//        WebElement fileInput = driver.findElement(By.name("fileWrapper.pathFilename"));
//        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"fileUpload\"]"));
        WebElement fileInput = driver.findElement(By.id("fileUpload"));
        System.out.println(fileInput.isDisplayed());
        System.out.println(fileInput.isEnabled());
        System.out.println(fileInput.isSelected());
        System.out.println(fileInput.toString());
//        fileInput.clear();
        System.out.println("Waiting...");
        Thread.sleep(10000);
        j.executeScript("FU.functions.enableFileUpload()");
        WebElement currentDocumentId = driver.findElement(By.name("currentDocumentId"));
//        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(fileInput)).sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
        j.executeScript("arguments[0].setAttribute('value', 'C:\\\\Users\\\\ricardomaximino\\\\work\\\\git\\\\src\\\\main\\\\resources\\\\files\\\\preview.pdf')", currentDocumentId);
        j.executeScript("arguments[0].setAttribute('value', 'C:\\\\Users\\\\ricardomaximino\\\\work\\\\git\\\\src\\\\main\\\\resources\\\\files\\\\preview.pdf')", fileInput);
        fileInput.sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
//
        System.out.println(fileInput.getAttribute("type"));
        System.out.println(fileInput.getAttribute("value"));
        System.out.println(fileInput.getAttribute("title"));
        System.out.println(fileInput.getAttribute("id"));
        Thread.sleep(5000);
    }

    @Test
    public void testLoadXMLEdgeServer() throws InterruptedException {
        String url = "https://ccvld-apt701:8443/sp-ui-tmefiling/oneform.htm";

        driver.navigate().to(url);

        acceptCookies();
        JavascriptExecutor j = (JavascriptExecutor) driver;

        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        inputList.stream().filter(input -> input.getAttribute("type").equals("file")).forEach(input -> System.out.println("Name: " + input.getAttribute("name") + " Type: " + input.getAttribute("type") + "\n\n"));
        Optional<WebElement> loadXML = inputList.stream().filter(input -> input.getAttribute("name").equals("loadApplicationXML")).findFirst();
        loadXML.ifPresent(input -> {
            System.out.println("Name: " + input.getAttribute("name") + " Type: " + input.getAttribute("type") + "\n\n");
            j.executeScript("arguments[0].setAttribute('style','display:block')",input);
            System.out.println(input.getAttribute("style"));
            input.sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            j.executeScript("arguments[0].setAttribute('style','display:none')",input);

        });

    }

    @Test
    public void testLoadXMLEdgeLocal() throws InterruptedException {
        String url = "https://localhost:8443/sp-ui-tmefiling/oneform.htm";

        driver.navigate().to(url);

        certificate();

        acceptCookies();
        JavascriptExecutor j = (JavascriptExecutor) driver;

        driver.findElement(By.name("loadApplicationXML")).sendKeys("C:\\Users\\ricardomaximino\\work\\git\\src\\main\\resources\\files\\preview.pdf");
        Thread.sleep(1000);
    }



    @After
    public void teardown(){
        driver.quit();
    }
}
