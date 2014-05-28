package robothack.feature;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.technbolts.Direction;
import org.technbolts.Location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * User: Christophe
 * Date: 28/05/14
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
public class MoveSteps {

    private SectorRef sectorRef;

    private Location location;

    private Program program;

    public MoveSteps(SectorRef sectorRef) {
        this.sectorRef = sectorRef;
    }

    @Given("^my location is \\((\\d+),(\\d+)\\), headed (\\w+)$")
    public void setLocation(int x, int y, String direction) throws Throwable {
        location = new Location(x, y, Direction.valueOf(direction.toUpperCase()));
    }

    @When("^I move forward$")
    public void moveForward() throws Throwable {
        Location destination = location.forward();
        if (sectorRef.getSector().isValidLocation(destination)) {
            location = destination;
        } else {
            program.crash();
        }
    }

    @Then("^my location should be \\((\\d+),(\\d+)\\)$")
    public void locationShouldBe(int x, int y) throws Throwable {
        assertEquals(x, location.getX());
        assertEquals(y, location.getY());
    }

    @Then("^the program should crash$")
    public void checkTheProgramHasCrashed() throws Throwable {
        assertTrue(program.hasCrashed());
    }

    @And("^a simple program$")
    public void a_simple_program() throws Throwable {
        program = new Program();
    }
}
