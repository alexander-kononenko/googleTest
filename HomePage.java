package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.util.List;

public class HomePage {
Timestamp timestamp;

public HomePage (WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
}
private  WebDriver driver;

//Waiting for "write email" button than click it
@FindBy(xpath ="//div[@class='T-I J-J5-Ji T-I-KE L3']")
public  WebElement wrEmailBtn;

public  void wrEmail() {
    WebDriverWait waitForPass = new WebDriverWait(driver, 10);
    waitForPass.until(ExpectedConditions.elementToBeClickable(wrEmailBtn));
}


//Sending some emails
public  void sendEmails(){
    for ( int i = 0 ; i < 4; i++) {
    timestamp = new Timestamp(System.currentTimeMillis());
    wrEmailBtn.click();
    WebDriverWait waitForEmailForm = new WebDriverWait(driver, 10);
    waitForEmailForm.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='subjectbox']")));
    WebElement wrEmailTo = driver.findElement(By.xpath("//textarea[@name='to']"));
    wrEmailTo.sendKeys("zalupatest111@gmail.com");
    WebElement wrEmailTheme = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        if (i==2)
            wrEmailTheme.sendKeys("zalupa");
        else
            wrEmailTheme.sendKeys("wawa"+timestamp.getTime());

    WebElement wrEmailBody = driver.findElement(By.xpath("//div[@role='textbox']"));
    wrEmailBody.sendKeys("KerHemHanaycty7@df");

    WebElement wrEmailSnd = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO T-I-atl L3']"));
    wrEmailSnd.click();
    }
}
    
    //Click Incoming email
@FindBy (xpath = "//a[@class='J-Ke n0']")
public WebElement incEmail;
public void incEmailClick(){
   incEmail.click();
}
}



