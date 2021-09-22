package ekam.example.mobile;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.testBases.testng.MobileTest;
import mobile.HomeScreen;
import mobile.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeScreenTest extends MobileTest {



    @Test(groups = "mobile")
    public void mobileExampleTest() {
        HomeScreen homeScreen = LayoutInitiator.Screen(HomeScreen.class);
        LoginScreen loginScreen = LayoutInitiator.Screen(LoginScreen.class);
        loginScreen.login("standard_user", "secret_sauce");
        String thankYouMsg = homeScreen.placeOrderAndVerify();
        System.out.println("Message received : " + thankYouMsg);
        Assert.assertEquals("THANK YOU FOR YOU ORDER", thankYouMsg, "Test case passed");

    }
}