package web;

import com.testvagrant.ekam.reports.annotations.WebStep;
import com.testvagrant.ekam.atoms.web.WebPage;
import org.openqa.selenium.By;

public class SearchPage extends WebPage {

    @WebStep(keyword = "When", description = "I hit search button")
    public SearchPage search() {
        return this;
    }

    By name = queryByName("q");

    public void search(String query) {
        textbox(name).setText(query);
    }

}