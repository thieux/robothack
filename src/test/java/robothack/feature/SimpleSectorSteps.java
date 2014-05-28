package robothack.feature;

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
    public void createSimpleSector(int width, int height) {
        sectorRef.setSector(new Sector(width, height));
    }

    @Then("^the block at \\((\\d+),(\\d+)\\) should be empty and not corrupted$")
    public void blockShouldBeEmptyAndNotCorrupted(int x, int y) {
        Block block = sectorRef.getSector().getBlock(x - 1, y - 1);
        assertTrue(block.isEmpty());
        assertFalse(block.isCorrupted());
    }

}
