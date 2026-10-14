package com.mystore.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
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

    @BeforeSuite
    public void properties() throws IOException {

        prop = new Properties();
        fis = new FileInputStream(Paths.get(
                System.getProperty("user.dir"),
                "src", "test", "java", "com", "mystore", "config", "config.properties"
        ).toFile());
        prop.load(fis);
        System.out.println("Property file data" + prop);
    }


    public void invoke() throws IOException {
        properties();
        invokeBrowser("Chrome");
        driver.get(prop.getProperty("url"));
        if (!runningInCi()) {
            driver.manage().window().maximize();
        }



    }
    public void invokeBrowser(String browser) {


        if (prop.getProperty("Os.Name").contains("win")) {

            if (browser.contains("Chrome")) {

                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                if (runningInCi()) {
                    options.addArguments(
                            "--headless=new",
                            "--no-sandbox",
                            "--disable-dev-shm-usage",
                            "--disable-gpu",
                            "--window-size=1920,1080"
                    );
                }
                driver = new ChromeDriver(options);


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

    private boolean runningInCi() {
        return "true".equalsIgnoreCase(System.getenv("CI"));
    }

}