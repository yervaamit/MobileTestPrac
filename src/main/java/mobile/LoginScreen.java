import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import org.openqa.selenium.By;

import static org.testng.Assert.*;

public class LoginScreen extends MobileScreen {

    @MobileStep(keyword = "When", description = "I login")
    public LoginScreen login() {
        return this;
    }

    private final By usernameTextBox = queryByContentDesc("test-Username");
    private final By passwordTextBox = queryByContentDesc("test-Password");
    private final By loginButton = queryByContentDesc("test-LOGIN");
    private final By errorMessageContainer = query("//*[@content-desc = 'test-Error message']/*");

    public LoginScreen login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
        return this;
    }


    public LoginScreen clickLogin() {
        element(loginButton).click();
        return this;
    }


    public LoginScreen setUsername(String username) {
        textbox(usernameTextBox).setText(username);
        return this;
    }


    public LoginScreen setPassword(String password) {
        textbox(passwordTextBox).setText(password);
        return this;
    }

}