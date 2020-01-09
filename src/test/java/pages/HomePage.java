package pages;

import baseFunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage {
    private BaseFunc basefunc;

    private final By SEARCH_BUTTON_OVER = By.xpath("//form[@action='/search']/button[@type='submit']");
    private final By SEARCH_FIELD_PLACE = By.xpath("//form[@action='/search']/div[@class='input__box']/input[@name='q']");

    public HomePage (BaseFunc baseFunc){
        this.basefunc = baseFunc;
    }

    public void moveOverSearchButton () {
        basefunc.moveOverElement(SEARCH_BUTTON_OVER);
    }

    public void searchSomethingInPikabu (String searchingThis) {
        WebElement searchFieldPlace = basefunc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action='/search']/div[@class='input__box']/input[@name='q']")));
        searchFieldPlace.sendKeys(searchingThis);
        searchFieldPlace.sendKeys(Keys.ENTER);
    }
}
