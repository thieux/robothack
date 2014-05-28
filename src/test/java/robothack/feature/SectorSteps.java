package robothack.feature;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.technbolts.Sector;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class SectorSteps {

    private Sector sector;

    @Given("^a Sector with (\\d+) documents$")
    public void createNewSector(int documentCount) throws Throwable {
        sector = new Sector();
        for (int i = 0; i < documentCount; ++i) {
            sector.declareDocument(new org.technbolts.Document());
        }
    }

    @When("^I hack (\\d+) document$")
    public void hackDocuments(int documentCount) throws Throwable {
        for (int i = 0; i < documentCount; ++i) {
            sector.hackDocument();
        }
    }

    @Then("^the Sector should not be won$")
    public void sectorIsNotWon() throws Throwable {
        assertFalse(sector.isWon());
    }

    @Then("^the Sector should be won$")
    public void sectorIsWon() throws Throwable {
        assertTrue(sector.isWon());
    }

}
