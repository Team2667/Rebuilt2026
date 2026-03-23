package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Rollers;
import static frc.robot.commands.ShooterState.State;

public class RollerAgitateCommand extends Command {

    Rollers rollers;
    ShooterState shooterState;

    public RollerAgitateCommand(Rollers rollers) {
        this.rollers = rollers;
        this.addRequirements(rollers);
        this.shooterState = new ShooterState();
    }

    @Override
    public void execute() {
        switch(shooterState.getState()) {
            case beginShooting:
            case rotateForward: rollers.start();
                                break;
            case rotateReverse: rollers.reverse();
                                break;   
        }
    }

    public void end(boolean isInterupted) {
        rollers.stop();
    }
}
