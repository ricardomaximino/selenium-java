package com.brasajava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TutorialSelenium {

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
    public void getBookPrice() throws InterruptedException {
        String bookName = "Ptazetas: Barzelona";
        String url = "https://amazon.es";

        driver.navigate().to(url);
        String title = driver.getTitle();

        WebElement all = driver.findElement(By.id("searchDropdownBox"));

        String label = all.getText();

        Select select = new Select(all);
        select.selectByValue("search-alias=stripbooks");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(bookName);
        searchBox.submit();
        Thread.sleep(4000);

        List<WebElement> books = driver.findElements(By.cssSelector(".a-link-normal.a-text-normal"));
        Optional<WebElement> firstBook = books.stream().filter(book -> bookName.equalsIgnoreCase(book.getText())).findFirst();
        if(firstBook.isPresent()){
            firstBook.get().click();
            Thread.sleep(2000);
            WebElement types = driver.findElement(By.cssSelector(".a-unordered-list.a-nostyle.a-button-list.a-horizontal"));
            List<WebElement> prices = types.findElements(By.xpath("./child::li"));
            prices.stream().map(price -> price.getText()).forEach(price -> System.out.println(price + "\n"));

        } else {
            throw new RuntimeException("The " + bookName.toUpperCase() + " was not found on " + url);
        }

        Thread.sleep(2000);

    }

    @After
    public void teardown(){
        driver.quit();
    }
}
