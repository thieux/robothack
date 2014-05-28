package org.technbolts;

public class Program {

    private boolean crashed;

    public void crash() {
        crashed = true;
    }

    public boolean hasCrashed() {
        return crashed;
    }
}
