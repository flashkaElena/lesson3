package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class crm_add_prog {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Проекты']/ancestor::a"))).build().perform();

        driver.findElement(By.xpath("//span[.='Все проекты']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name-uid')]")).sendKeys("testtest");

        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Bins-Haley']")).click();

        Select selectbusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectbusinessUnit.selectByVisibleText("Research & Development");

        Select selectProgCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectProgCurator.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select selectProgRp = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectProgRp.selectByVisibleText("Зиганшина Алсу");

        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Исаева Анастасия");

        driver.findElement(By.xpath("//button[contains(.,'Сохранить')]")).click();

        Thread.sleep(6000);
        driver.quit();

    }

    static void login(WebDriver driver) {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
