package org.technbolts;

/**
 * Zero-indexed 2D coordinates of a point on a sector.
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
