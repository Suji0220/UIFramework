package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="link-to-login")
        private WebElement loginLink;

    @FindBy(id="spree_user_email")
            private WebElement emailTextBox;

    @FindBy(id="spree_user_password")
            private WebElement passwordTextBox;

    @FindBy(name="commit")
            private WebElement submitButton;

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductListingPage login(String username, String password)
    {
        loginLink.click();
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        submitButton.click();
        return new ProductListingPage(driver);
    }




}
