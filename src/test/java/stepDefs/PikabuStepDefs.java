package stepDefs;

import baseFunc.BaseFunc;
import cucumber.api.java.en.Given;
import pages.*;

public class PikabuStepDefs {

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;



    private final String url = "https://pikabu.ru/";


    @Given("pikabu homepage")
    public void open_pikabu_homepage() {
        baseFunc.openPage(url);
//        homePage = new HomePage(baseFunc);
    }


}

