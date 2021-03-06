package ekam.example.mobile;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import mobile.LoginScreen;
import org.testng.annotations.Test;

//@Test(groups = "mobile")
public class MobileExampleTest extends MobileTest {
    @Test
    public void loginWithValidCredentials() {
        LoginScreen loginScreen = LayoutInitiator.Screen(LoginScreen.class);
        loginScreen.login("standard_user", "secret_sauce");
    }
}
