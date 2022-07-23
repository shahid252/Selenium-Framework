package com.mystore.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

    /**
     * Configuration of Browsers
     * All reusable methods
     * Reporting utilities
     * Property readers
     * Xml readers
     */

    public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream fis;
    public static DesiredCapabilities cap;

    @BeforeSuite
    public void properties() throws IOException {

        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\mystore\\config\\config.properties");
        prop.load(fis);
        System.out.println("Property file data" + prop);
    }


    public void invoke() throws IOException {
        properties();
        invokeBrowser("Chrome");
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();



    }
    @SuppressWarnings("deprication")
    public void invokeBrowser(String browser) {


        if (prop.getProperty("Os.Name").contains("win")) {

            if (browser.contains("Chrome")) {

                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");

                cap = new DesiredCapabilities();
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                driver= new ChromeDriver(cap);


            } else if (browser.contains("Firefox")) {

                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fp = new FirefoxOptions();
                String path = "/Drivers/firefox.exe";
                fp.setBinary(path);
                driver=new FirefoxDriver(fp);
            } else {

            }

        }


    }

}