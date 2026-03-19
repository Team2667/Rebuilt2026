package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;

public class UnJamFeeder extends Command {
    Feeder feeder;

    public UnJamFeeder(Feeder feeder) {
        this.feeder = feeder;
        this.addRequirements(feeder);
    }

    @Override
    public void initialize() {
        feeder.reverse();
    }

    public void end (boolean isInterupted) {
        feeder.stop();
    }
}
