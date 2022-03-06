package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Launch;

public class MyStepdefs {
    @Given("I open the UR in browse {string} and  {string}")
    public void iOpenTheURInBrowseAnd(String url, String browser) {
        Launch.URL(url, browser);
    }

    @When("Moving the cursor over the Women link")
    public void movingTheCursorOverTheWomenLink() {
        Launch.cursorToWomansLnk();
    }

    @Then("Clicked on the sub Menu T-shirts")
    public void clickedOnTheSubMenuTShirts() {
        Launch.clickTshirt();
    }

    @And("Validate name of the first product display")
    public void validateNameOfTheFirstProductDisplay() {
        Launch.validateFirstProduct();
    }

    @Then("Now enter the same product name in the search bar present on top of page and click the search button")
    public void nowEnterTheSameProductNameInTheSearchBarPresentOnTopOfPageAndClickTheSearchButton() {
        Launch.searchProduct();
    }

    @And("Validate that the same product is displayed on a searched page with the same details which were displayed on T-Shirt's page.")
    public void validateThatTheSameProductIsDisplayedOnASearchedPageWithTheSameDetailsWhichWereDisplayedOnTShirtSPage() {
        Launch.validateSearchedProduct();
        Launch.quitBrowser();
    }

}
