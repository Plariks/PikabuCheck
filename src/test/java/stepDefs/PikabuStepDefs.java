package stepDefs;

import baseFunc.BaseFunc;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

public class PikabuStepDefs {

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private SearchPage searchPage;



    private final String url = "https://pikabu.ru/";


    @Given("pikabu homepage")
    public void open_pikabu_homepage() {
        baseFunc.openPage(url);
        homePage = new HomePage(baseFunc);

   }
//
//    @Then("round {double} value to {int} digits after comma")
//    public void round_up_number(Double needed, Integer value) {
//        baseFunc.roundTheNumber(needed, value);
//    }

    @When("we hover over button")
    public void hover_over_search() {
        homePage.moveOverSearchButton();
    }

    @And("adding {string} as search word")
    public void find_this_word (String searchWord) {
        homePage.searchSomethingInPikabu(searchWord);
    }

    @Then("opens tag search page")
    public void web_page_check() {
        searchPage = new SearchPage(baseFunc);
    }

    @When("we choose sort by {string}")
    public void filtering_by_importance (String status) {
        searchPage.filterValue(status);
    }

    @Then("first post should have rating more than {int}")
    public void first_post_rating_check (Integer ratingValue) {
        searchPage.checkPostValue(ratingValue);
    }
}

