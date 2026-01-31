package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShooterDefaultCommand extends Command {

    Shooter shooter;

    public ShooterDefaultCommand(Shooter shooter) {
        this.shooter = shooter;
        this.addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.start();
    }
    
    // TODO: add a method named end. 
    // * The return type for the  method should be void (it doesnt return anything)
    // * It will take a single parameter. The type for the parameter is boolean. 
    // * The method should stop the shooter motors.
    // 
}
