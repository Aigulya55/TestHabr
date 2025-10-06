package org.example.ru;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainPage {
    private WebDriver driver;

    @BeforeEach
    public void setUP() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void MainPageSetting() {
        WebElement headerSetting = driver.findElement(By.xpath("//*[text()='Все потоки']"));
        headerSetting.click();

        WebElement searcHabr = driver.findElement(By.xpath("//*[text()='Хабы']"));
        searcHabr.click();

        String input = "Гаджеты";
        WebElement searchField = driver.findElement(By.cssSelector("input[name='searchQuery']"));
        searchField.sendKeys(input);

        WebElement searchButton = driver.findElement(By.cssSelector("svg[class='tm-svg-img tm-svg-icon']"));
        searchButton.click();

        assertEquals(input, searchField.getAttribute("value"), "Неверное значение");

    }
}
