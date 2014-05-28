package robothack.feature;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.technbolts.Block;
import org.technbolts.Sector;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SimpleSectorSteps {

    private SectorRef sectorRef;

    public SimpleSectorSteps(SectorRef sectorRef) {
        this.sectorRef = sectorRef;
    }

    @Given("^a very simple (\\d+)x(\\d+) sector$")
    public void createSimpleSector(int width, int height) throws Throwable {
        sectorRef.setSector(new Sector(width, height));
    }

    @Then("^the block at \\((\\d+),(\\d+)\\) should be empty and not corrupted$")
    public void the_block_at_should_be_empty_and_not_corrupted(int x, int y) throws Throwable {
        Block block = sectorRef.getSector().getBlock(x, y);
        assertTrue(block.isEmpty());
        assertFalse(block.isCorrupted());
    }

}
