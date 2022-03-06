package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Launch {
    public static String chrome = "webdriver.chrome.driver";
    public static String driverPath = "driverFactory/chromedriver.exe";
    public static String firefox = "webdriver.gecko.driver";
    public static WebDriver driver = null;
    public static void waitFunction(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void URL(String url, String browser) {
        try {
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty(chrome, driverPath);
                driver = new ChromeDriver();
            }
            System.out.println("driver is invoked successfully");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(url);
            System.out.println("URL Loaded successfully");
            waitFunction();
        } catch (Exception e) {
            System.err.println("Exception occured in Browser Launch method" + e.getMessage());
        }
    }

    public static void cursorToWomansLnk() {
        try {
            WebElement menuOption = driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a"));
            //Mouse hover menuOption 'Woman'
            Actions actions = new Actions(driver);
            actions.moveToElement(menuOption).perform();
            System.out.println("Done Mouse hover on 'Woman' from Menu");
           /* //Now Select 'T-shirt' from the options
            WebElement optionTshirt = driver.findElement(By.xpath(".//a[contains(text(),'T-shirts')]"));
            //Mouse hover menuOption 'T-shirt'
            actions.moveToElement(optionTshirt).perform();
            optionTshirt.click();
            System.out.println("'T-shirt' clicked successfully from Women menu");*/
        } catch (Exception e) {
            System.err.println("Exception occured on cursor point to Women menu link" + e.getMessage());
        }
    }

    public static void clickTshirt() {
        try {
            WebElement optionTshirt = driver.findElement(By.xpath(".//a[contains(text(),'T-shirts')]"));
            //Mouse hover menuOption 'T-shirt'
            Actions actions = new Actions(driver);
            actions.moveToElement(optionTshirt).perform();
            optionTshirt.click();
            System.out.println("'T-shirt' clicked successfully from Women menu");
        } catch (Exception e) {
            System.err.println("Exception occured on cursor point to Women menu link" + e.getMessage());
        }
    }


    public static void validateFirstProduct() {
        try {
            String firstPrdName = driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/h5")).getText();
            System.out.println("First Product name is: "+firstPrdName);
            if(firstPrdName.equals("Faded Short Sleeve T-shirts"))
                System.out.println("First product name is " + firstPrdName + " displaying as expected");
            else
                System.out.println("First product name is not " + firstPrdName + " displaying as expected");
        } catch (Exception e) {
            System.err.println("Exception occured on cursor point to Women menu link" + e.getMessage());
        }
    }
    public static void searchProduct() {
        try {
            String searchPrdName = driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/h5")).getText();
            System.out.println("Search Product name is: "+searchPrdName);
            WebElement srchBox = driver.findElement(By.xpath("//*[@id='search_query_top']"));
            srchBox.sendKeys(searchPrdName);
            WebElement srchIcon = driver.findElement(By.xpath("//*[@id='searchbox']/button"));
            srchIcon.click();
        } catch (Exception e) {
            System.err.println("Exception occured on cursor point to Women menu link" + e.getMessage());
        }
    }

    public static void validateSearchedProduct() {
        try {
            String expectedTetxt = driver.findElement(By.xpath("//*[@id='search_query_top']")).getAttribute("value");
            System.err.println("Searching product name is: " + expectedTetxt);
            String actualTetxt = driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/h5/a")).getText();
            System.err.println("Displayiing product name is: " + expectedTetxt);
            Assert.assertEquals(expectedTetxt, actualTetxt);
            System.err.println("Displaying product name is same product as expected");
        } catch (Exception e) {
            System.err.println("Exception occured on cursor point to Women menu link" + e.getMessage());
        }
    }
    public static void quitBrowser() {
        try {
            driver.quit();
            System.err.println("Browser closed successfully");
        } catch (Exception e) {
            System.err.println("Exception occured on cursor point to Women menu link" + e.getMessage());
        }
    }

    }


