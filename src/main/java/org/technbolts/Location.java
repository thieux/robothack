package org.technbolts;

/**
 * Created with IntelliJ IDEA.
 * User: Christophe
 * Date: 28/05/14
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class Location {
    private final int x;
    private final int y;
    private final Direction direction;

    public Location(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Location forward() {
        int x = this.x;
        int y = this.y;
        switch (direction) {
            case NORTH:
                y--;
                break;
            case SOUTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }
        return new Location(x, y, direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
