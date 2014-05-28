package org.technbolts;

/**
 * Created with IntelliJ IDEA.
 * User: Christophe
 * Date: 28/05/14
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public class ProgramExecutionError extends RuntimeException {
    public ProgramExecutionError(String s) {
        super(s);
    }
}
