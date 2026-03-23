package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;
import static frc.robot.commands.ShooterState.State;

public class FeederAgitateCommand  extends Command {
    Feeder feeder;
    ShooterState shooterState;

    public FeederAgitateCommand(Feeder feeder) {
        this.feeder = feeder;
        shooterState = new ShooterState();
        this.addRequirements(feeder);
    }

    @Override
    public void execute() {
        switch(shooterState.getState()){
            case beginShooting:
            case rotateForward: feeder.feed(); 
                                break;
            case rotateReverse: feeder.reverse();
                                break;

        }
    }

    public void end (boolean isInterupted) {
        feeder.stop();
    }
}
