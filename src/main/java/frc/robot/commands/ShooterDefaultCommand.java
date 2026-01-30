package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterDefaultCommand extends Command {

    Shooter shooter;

    public ShooterDefaultCommand(Shooter shooter) {
        this.shooter = shooter;
        shooter.setDefaultCommand(this);
        this.addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.start();
    }
    
}
