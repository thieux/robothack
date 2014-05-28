package robothack.feature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.technbolts.Block;
import org.technbolts.Sector;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class SectorSteps {

    private Sector sector;
    private Block block;

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

    @Given("^a block with a document$")
    public void a_block_with_a_document() throws Throwable {
        block = new Block(false, false);
    }

    @Given("^a block without a document$")
    public void a_block_without_a_document() throws Throwable {
        block = new Block(true, false);
    }

    @When("^I hack$")
    public void I_hack() throws Throwable {
        block.hack();
    }

    @Then("^the block has no document$")
    public void the_block_has_no_document() throws Throwable {
        assertTrue(block.isEmpty());
    }


    @Then("^the block is corrupted$")
    public void the_block_is_corrupted() throws Throwable {
        assertTrue(block.isCorrupted());
    }
}
