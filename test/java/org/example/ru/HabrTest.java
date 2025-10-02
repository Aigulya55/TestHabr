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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class HabrTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void changeLog() {
        WebElement userPage = driver.findElement(new By.ByXPath("//a[text()='Устройство сайта']"));
        userPage.click();

        List<WebElement> changeLog = driver.findElements(new By.ByXPath("//a[text()='Changelog']"));
        assertFalse(changeLog.isEmpty(), "ChangeLog не найден");

    }
}
