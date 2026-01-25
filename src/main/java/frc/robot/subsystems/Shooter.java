package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase{
    private SparkFlex leftMotor;
    private SparkFlex rightMotor;

    public Shooter() {
        // Initialize leftMotor and rightMotor using new. See https://github.com/Team2667/Reefscape/blob/main/src/main/java/frc/robot/subsystems/swerveSupport/SwerveModule.java#L39
        // as an example. The Can Ids are found in Constants.java.
    }

    public void start() {
        // the purpose of this method is to run the motor at a constant speed. Eventually, we will want to use
        // PID to do this. For a first draft, just use the set method.
    }
}
