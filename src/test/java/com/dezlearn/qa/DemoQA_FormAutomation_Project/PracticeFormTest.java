package com.dezlearn.qa.DemoQA_FormAutomation_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PracticeFormTest {

    private WebDriver driver;

    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillCompleteDemoQAForm() throws InterruptedException {
        // Fill First Name and Last Name
        driver.findElement(By.id("firstName")).sendKeys("Jayani");
        driver.findElement(By.id("lastName")).sendKeys("thashmila");

        // Email
        driver.findElement(By.id("userEmail")).sendKeys("jayani@test.com");

        // Gender - Female
        driver.findElement(By.xpath("//label[text()='Female']")).click();

        // Mobile Number (10 digits)
        driver.findElement(By.id("userNumber")).sendKeys("0773503137");

        // Date of Birth - open date picker and select date
        driver.findElement(By.id("dateOfBirthInput")).click();
        // Select Month
        WebElement monthSelect = driver.findElement(By.className("react-datepicker__month-select"));
        new Select(monthSelect).selectByVisibleText("November");
        // Select Year
        WebElement yearSelect = driver.findElement(By.className("react-datepicker__year-select"));
        new Select(yearSelect).selectByVisibleText("2002");
        
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='11' and not(contains(@class,'outside-month'))]")).click();

        // Subjects - type and select (e.g. English)
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("English");
        Thread.sleep(1000);  // wait for auto-suggest dropdown
        subjectsInput.sendKeys("\n");  // press enter to select first option

        // Hobbies - select Sports and Music
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        driver.findElement(By.xpath("//label[text()='Music']")).click();

        // Upload Picture (optional) - make sure the path is valid on your PC
        // Upload Picture (optional) - make sure the path is valid on your PC
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("C:\\Users\\user\\Downloads\\image\\jayani.jpeg");  // correct path without extra quotes


        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Test Address, Colombo, Sri Lanka");

        // Scroll down to make State visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("state")));

        // Select State (dropdown implemented as div dropdown)
        driver.findElement(By.id("state")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'NCR')]")).click();

        // Select City
        driver.findElement(By.id("city")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();

        // Submit the form
        driver.findElement(By.id("submit")).click();

        // Wait for confirmation modal to appear
        Thread.sleep(2000);

        // Validate submission confirmation modal text
        String confirmationText = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertEquals(confirmationText, "Thanks for submitting the form");

        System.out.println("✅ Test Passed: Form submitted successfully!");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
