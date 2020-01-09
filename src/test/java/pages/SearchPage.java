package pages;

import baseFunc.BaseFunc;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private BaseFunc basefunc;


    private final By SEARCH_PAGE_ONE = By.xpath("//div[@class='stories-search']");
    private final By SEARCH_PAGE_TAGS = By.xpath("//div[@class='form-group stories-search__tags-group']");
    private final By SORT_BUTTON = By.xpath("//div[@class='stories-search__feed-panel']/a");
    private final By BESTIE = By.xpath("//div[@class='popup__content popup__content_indent']/form/p/label[text()=' Сначала лучшее']/span/div");
    private final By NEWIE = By.xpath("//div[@class='popup__content popup__content_indent']/form/p/label[text()=' Сначала свежее']/span/div");
    private final By HOT_OR_FRESH = By.xpath("//div[@class='popup__content popup__content_indent']/form/p/label/span/input");
    private final By RATING_AMOUNT = By.xpath("//div[@class='stories-feed__container']/article[@class='story']/div[@class='story__left']/div/div/div[@class='story__rating-count']");

    public SearchPage(BaseFunc baseFunc) {
        this.basefunc = baseFunc;
        Assertions.assertFalse(baseFunc.isElementPresent(SEARCH_PAGE_ONE));
        Assertions.assertFalse(baseFunc.isElementPresent(SEARCH_PAGE_TAGS));
    }

    public void clickOnFilterButton() {
        WebElement sortingButton = basefunc.getElement(SORT_BUTTON);
        sortingButton.click();
    }

    public void filterValue(String oneOfTwo) {
        clickOnFilterButton();
        WebElement bestie = basefunc.getElement(BESTIE);
        WebElement newie = basefunc.getElement(NEWIE);
        if (oneOfTwo.equals("HOT")) {
            bestie.click();
        } else if (oneOfTwo.equals("FRESH")) {
            newie.click();
        }
      }

    public void checkPostValue(Integer postValueAmount) {
        List<WebElement> tryRatingCheck = basefunc.getAllElements(RATING_AMOUNT);
        for (int i = 0; i < tryRatingCheck.size(); i++) {
            String ratingToNumbers = tryRatingCheck.get(1).getText();
            int ratingtoNumberInt = Integer.parseInt(ratingToNumbers);
            if (ratingtoNumberInt<postValueAmount) {
                System.out.println("Error dude... Try harder");
            } else {
                System.out.println("Yo, good boy!");
            } break;
        }
    }
    }

