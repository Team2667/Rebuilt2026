package frc.robot.commands;

public class ShooterState {
    public enum State{
        beginShooting,
        rotateReverse,
        rotateForward
    }
    
    private static int beginShootingCount = 150;
    private static int rotateReverseCount = 25;
    private static int rotateForwardCount = 25;
    private int count;
    State currentState;

    public ShooterState() {
        currentState = State.beginShooting;
        count = 0;
    }

    public State getState() {
        count++;
        if (currentState == State.beginShooting && count == beginShootingCount) {
            count = 0;
            currentState = State.rotateReverse;
        }
        if (currentState == State.rotateReverse && count == rotateReverseCount) {
            count = 0;
            currentState = State.rotateForward;
        }
        if (currentState == State.rotateForward && count == rotateForwardCount) {
            count = 0;
            currentState = State.rotateReverse;
        }
        return currentState;
    }

}
