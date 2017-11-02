import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class AjaxFileDownloader {

    private static  WebDriver driver;

    public AjaxFileDownloader(WebDriver driverObject) {
        this.driver = driverObject;
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS); // maybe you need a different timeout
    }

    public static void main(String[] args) throws IOException  {
         /*
          System.setProperty("webdriver.chrome.driver", "/Applications/New Folder With Items/Google Chrome.app/Contents/MacOS/Google Chrome");
          WebDriver driver = new ChromeDriver();
          driver.get("http://www.sciencedirect.com.eresources.mssm.edu/science/article/pii/S0378378208000078/pdfft?md5=c036fdb38be223081e00317986f14924&amp;pid=1-s2.0-S0378378208000078-main.pdf");
         System.out.println("Title " + driver.getTitle());
        */
          //Create FireFox Profile object
		FirefoxProfile profile = new FirefoxProfile();
 
		//Set Location to store files after downloading.
		profile.setPreference("browser.download.dir", "/Users/hand10/Downloads/");
		profile.setPreference("browser.download.folderList", 2);
 
		//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
		    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
 
		profile.setPreference( "browser.download.manager.showWhenStarting", false );
		profile.setPreference( "pdfjs.disabled", true );
 
		//Pass FProfile parameter In webdriver to use preferences to download file.
		FirefoxDriver driver = new FirefoxDriver(profile);  
 
		// Open APP to download application
		driver.get("http://toolsqa.com/automation-practice-form/");
 
		// Click to download 
		driver.findElement(By.linkText("Test File to Download")).click();
 
		//Halting the execution for 5 secs to donwload the file completely
		//Thread.sleep(5000);
 
		driver.close();
    }

}
