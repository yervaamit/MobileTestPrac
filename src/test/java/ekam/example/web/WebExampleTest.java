package ekam.example.web;

import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.testBases.testng.WebTest;
import org.testng.annotations.Test;
import web.SearchPage;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;
import static org.testng.Assert.*;

@Test(groups = "web")
public class WebExampleTest extends WebTest {
    @Test
    public void searchTest() {
        SearchPage searchPage = LayoutInitiator.Page(SearchPage.class);
        searchPage.search("Hello Ekam!!!");
    }
}
