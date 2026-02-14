package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.FeederConstants.*;

import static frc.robot.Constants.*;

public class Feeder extends SubsystemBase{
    

    private SparkMax motor1;
    private SparkMax motor2;


    public Feeder() { 
        motor1 = new SparkMax(motor1CanId, MotorType.kBrushless);
        motor2 = new SparkMax(motor2CanId, MotorType.kBrushless);

        motor1.configure(createConfigurationForVelocity(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        motor2.configure(createConfigurationForVelocity(), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void feed() {
        motor1.set(0.3);
        motor2.set(0.3);
    }

    public void feedAtConstantVelocity() {
        motor1.getClosedLoopController().setSetpoint(setPoint, ControlType.kVelocity, ClosedLoopSlot.kSlot0, kFF);
        motor2.getClosedLoopController().setSetpoint(setPoint, ControlType.kVelocity, ClosedLoopSlot.kSlot0, kFF);
    }

    public void stop() {
        motor1.stopMotor();
        motor2.stopMotor();
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
        SmartDashboard.putNumber("Feeder Motor1 Velocity", motor1.getEncoder().getVelocity());
        SmartDashboard.putNumber("Feeder Motor2 Velocity", motor1.getEncoder().getVelocity());
    }
}
