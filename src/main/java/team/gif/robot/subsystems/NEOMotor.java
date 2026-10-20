// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;

public class NEOMotor extends SubsystemBase {

    private final SparkMax neoMotor;
    private final PIDController positionPID;
    private final PIDController velocityPID;

    public NEOMotor(int canID) {
        positionPID = new PIDController(Constants.BuildABot.SPARKMAX_POSITION_PID_kP, Constants.BuildABot.SPARKMAX_POSITION_PID_kI, Constants.BuildABot.SPARKMAX_POSITION_PID_kD);
        velocityPID = new PIDController(Constants.BuildABot.SPARKMAX_VELOCITY_PID_kP, Constants.BuildABot.SPARKMAX_VELOCITY_PID_kI, Constants.BuildABot.SPARKMAX_VELOCITY_PID_kD);
        neoMotor = new SparkMax(canID, SparkLowLevel.MotorType.kBrushless);
        configure();
    }

    public void setVoltage(double volts) {
        neoMotor.setVoltage(volts);
    }

    public double getPosition() {
        return neoMotor.getEncoder().getPosition();
    }

    public void setPosition(double setpoint) {
        neoMotor.set(positionPID.calculate(getPosition(), setpoint));
    }

    public double getVelocity() {
        return neoMotor.getEncoder().getVelocity();
    }

    public void setVelocity(double setpoint) {
        neoMotor.set(velocityPID.calculate(getVelocity(), setpoint));
    }

    public void configure() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.idleMode(SparkBaseConfig.IdleMode.kCoast);
        neoMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void stop() {
        neoMotor.stopMotor();
    }

}
