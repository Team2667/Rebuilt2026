package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Feeder extends SubsystemBase{
    private SparkFlex beltMotor; // TODO: Talk to the builders and vwerify that the bult will have 2 motors.
    private SparkFlex neckMotor; 


    public Feeder() {
        //  TODO: Initialize beltMotor and neckMotor using new. See the Shooter subsystem as an example

        // If we end up with 2 belt motors, one motor will need to be configured to follow the other.
        // See https://github.com/Team2667/Reefscape/blob/main/src/main/java/frc/robot/subsystems/Elevator.java#L55-L58
        // For an example of how to do that.
    }

    public void feed() {
        // the purpose of this method is to run the feeder motors at a slow speed.
    }

    public void stop() {
        // The purpose of this method is to stop the motors
    }
}
