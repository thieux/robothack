package org.technbolts;

/**
 * Created with IntelliJ IDEA.
 * User: Christophe
 * Date: 28/05/14
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public class Block {
    private boolean empty;
    private boolean corrupted;

    public Block() {
        this(true, false);
    }

    public Block(boolean empty, boolean corrupted) {
        this.empty = empty;
        this.corrupted = corrupted;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isCorrupted() {
        return corrupted;
    }

    public void setCorrupted(boolean corrupted) {
        this.corrupted = corrupted;
    }
}
