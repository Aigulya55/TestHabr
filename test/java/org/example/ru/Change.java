package org.example.ru;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Change {
    private WebDriver driver;

    @BeforeEach
    public void setUP() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void englishChange() {
        WebElement setting = driver.findElement(By.cssSelector("button[data-test-id='user-menu-settings']"));
        setting.click();

        WebElement radioButton = driver.findElement(By.xpath("//*[(text()='English')]"));
        radioButton.click();

        WebElement saveSetting = driver.findElement(By.xpath("//*[text()='Save preferences']"));
        saveSetting.click();
    }
}
