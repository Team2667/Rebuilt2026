package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.RollerConstants.*;

public class Rollers extends SubsystemBase {
    private SparkFlex rollerMotor;

    public Rollers() {
        rollerMotor = new SparkFlex(rollerCanId, MotorType.kBrushless);
        rollerMotor.configure(createConfigurationForVelocity(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void start() {
        rollerMotor.set(0.3);
    }

    public void statAtVelocity() {
        rollerMotor.getClosedLoopController().setSetpoint(setPoint, ControlType.kVelocity, ClosedLoopSlot.kSlot0, kFF);
    }
    
    public void stop() {
        rollerMotor.stopMotor();
    }

    private SparkFlexConfig createConfigurationForVelocity(){
        var motorConfig = new SparkFlexConfig();
        motorConfig.closedLoop.pid(kP, kI, kD);
        motorConfig.closedLoop.maxOutput(1.0);
        motorConfig.closedLoop.minOutput(-1.0);
        return motorConfig;
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Rollor Motor Velocity", rollerMotor.getEncoder().getVelocity());
    }
}
