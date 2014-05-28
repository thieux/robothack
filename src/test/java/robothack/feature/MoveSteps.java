package robothack.feature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.technbolts.Direction;
import org.technbolts.Location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * User: Christophe
 * Date: 28/05/14
 * Time: 14:40
 * To change this template use File | Settings | File Templates.
 */
public class MoveSteps {

    private Location location;

    @Given("^my location is \\((\\d+),(\\d+)\\), headed (\\w+)$")
    public void my_location_is_headed_west(int x, int y, String direction) throws Throwable {
        location = new Location(x, y, Direction.valueOf(direction.toUpperCase()));

    }

    @When("^I move forward$")
    public void I_move_forward() throws Throwable {
        location = location.forward();
    }

    @Then("^my location is \\((\\d+),(\\d+)\\)$")
    public void my_location_is_(int x, int y) throws Throwable {
        assertEquals(x, location.getX());
        assertEquals(y, location.getY());
    }
}
