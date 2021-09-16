package ekam.example.mobile;

import com.testvagrant.ekam.testBases.testng.MobileTest;
import org.testng.annotations.Test;
import static com.testvagrant.ekam.commons.LayoutInitiator.*;
import static org.testng.Assert.*;

@Test(groups = "mobile")
public class MobileExampleTest extends MobileTest {
    @Test
    public void loginWithValidCredentials() {
        LoginScreen loginScreen = LayoutInitiator.Screen(LoginScreen.class);
        loginScreen.login("standard_user", "secret_sauce");
    }
}
