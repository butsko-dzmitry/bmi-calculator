import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BMICalculator {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
    }

    // Starvation category with SI Units <= 14.99 (Weight: 47.5 kg, Height: 178 cm)
    @Test
    public void starvationCategory() {

        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("47.5");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("178");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Starvation",
                "actual text is not: Your category is Starvation");
    }

    // Underweight category with SI Units = 15.00 (Weight: 58.6 kg, Height: 178 cm)
    @Test
    public void underweightCategoryFirstRangeInKgAndCm() {

        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("47");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("177");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Underweight",
                "actual text is not: Your category is Underweight");
    }

    // Underweight category with SI Units <= 18.50 (Weight: 58.6 kg, Height: 178 cm)
    @Test
    public void underweightCategorySecondRangeInKgAndCm() {

        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("58.6");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("178");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Underweight",
                "actual text is not: Your category is Underweight");
    }


    // Normal category with IS Unit = 18.51 (Weight: 59.3 kg, Height: 179 cm)
    @Test
    public void normalCategoryFirstRangeInKgAndCm() {


        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("59.3");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("179");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Normal",
                "actual text is not: Your category is Normal");
    }


    // Normal category with IS Unit = 25.00 (Weight: 81 kg, Height: 180 cm)
    @Test
    public void normalCategorySecondRangeInKgAndCm() {

        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("81");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("180");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Normal",
                "actual text is not: Your category is Normal");
    }

    // Overweight category with SI Units = 25.01 (Weight: 85.6 kg, Height: 185 cm)
    @Test
    public void overweightCategoryFirstRangeInKgAndCm() {

        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("85.6");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("185");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Overweight",
                "actual text is not: Your category is Overweight");
    }

    // Overweight category with SI Units = 30.00 ( Weight: 94 kg, Height: 177 cm)
    @Test
    public void overweightCategorySecondRangeInKgAndCm() {

        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("94");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("177");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Overweight",
                "actual text is not: Your category is Overweight");
    }

    // Obesity category with SI Units = 30.01 (Weight: 102.7 kg, Height: 185 cm)
    @Test
    public void obesityCategory() {

        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("102.7");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("185");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Overweight",
                "actual text is not: Your category is Overweight");
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}


