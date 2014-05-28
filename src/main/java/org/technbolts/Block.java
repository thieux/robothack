package org.technbolts;

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

    public void hack() {
        if (!isEmpty()) {
            this.empty = true;
        } else {
            this.corrupted = true;
        }
    }
}
