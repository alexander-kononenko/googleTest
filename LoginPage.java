package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
        private  WebDriver driver;

    //Login Button
    @FindBy(xpath ="//a[@data-g-label='Sign in']")
    private WebElement loginButton;
    //Login Button Click
    public  void clickLoginButton(){
        loginButton.click();
    }

    //Login/Password Text Field
    @FindBy (xpath=("//input[@type='email']"))
    public  WebElement loginField;
    //Login Input
    public  void loginInput() {
        loginField.sendKeys("zalupatest111\n");
    }

    //Waiting for Password field than input password
    @FindBy (xpath=("//input[@type='password']"))
    public  WebElement PassField;

    public  WebElement passWait() {
        WebDriverWait waitForPass = new WebDriverWait(driver, 10);
        return  waitForPass.until(ExpectedConditions.elementToBeClickable(PassField));
        }
        public void passInput() {
        this.passWait().sendKeys("KerHemHanaycty7\n");
        }

}

