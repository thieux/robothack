package robothack.feature;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.technbolts.Direction;
import org.technbolts.Location;
import org.technbolts.Program;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoveSteps {

    private SectorRef sectorRef;

    private Location location;

    private Program program;

    public MoveSteps(SectorRef sectorRef) {
        this.sectorRef = sectorRef;
    }

    @Given("^my location is \\((\\d+),(\\d+)\\), headed (\\w+)$")
    public void setLocation(int x, int y, String direction) {
        location = new Location(
                CoordinateBaseChange.convertCoordinateToInternal(x),
                CoordinateBaseChange.convertCoordinateToInternal(y),
                Direction.valueOf(direction.toUpperCase()));
    }

    @When("^I move forward$")
    public void moveForward() {
        Location destination = location.forward();
        if (sectorRef.getSector().isValidLocation(destination)) {
            location = destination;
        } else {
            program.crash();
        }
    }

    @Then("^my location should be \\((\\d+),(\\d+)\\)$")
    public void locationShouldBe(int x, int y) {
        assertEquals(CoordinateBaseChange.convertCoordinateToInternal(x),
                location.getX());
        assertEquals(CoordinateBaseChange.convertCoordinateToInternal(y),
                location.getY());
    }

    @Then("^the program should crash$")
    public void programShouldHaveCrashed() {
        assertTrue(program.hasCrashed());
    }

    @And("^a simple program$")
    public void simpleProgram() {
        program = new Program();
    }

}
