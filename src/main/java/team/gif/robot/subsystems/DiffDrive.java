// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this projec

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DiffDrive extends SubsystemBase {

    private WPI_TalonSRX flMotor;
    private WPI_TalonSRX frMotor;
    private WPI_TalonSRX rlMotor;
    private WPI_TalonSRX rrMotor;
    private DifferentialDrive differentialDrive;

    public DiffDrive() {
        configure();
        differentialDrive = new DifferentialDrive(flMotor, frMotor);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public void arcadeDrive(double speed, double turn) {
        differentialDrive.arcadeDrive(speed, turn);
    }

    public void configure() {
        /**
         * Create motor objects in constructor
         */
        flMotor = new WPI_TalonSRX(1);
        frMotor = new WPI_TalonSRX(2);
        rlMotor = new WPI_TalonSRX(3);
        rrMotor = new WPI_TalonSRX(4);

        /**
         * Leave configs as factory defaults
         */
        flMotor.configFactoryDefault();
        frMotor.configFactoryDefault();
        rlMotor.configFactoryDefault();
        rrMotor.configFactoryDefault();

        /**
         * Set the motor's idle mode to brake
         * because I don't think it's a good idea
         * to have them in Coast
         */
        flMotor.setNeutralMode(NeutralMode.Brake);
        frMotor.setNeutralMode(NeutralMode.Brake);
        rlMotor.setNeutralMode(NeutralMode.Brake);
        rrMotor.setNeutralMode(NeutralMode.Brake);

        /**
         * Rear motors will have the same output as the
         * motor in front of it.
         */
        rlMotor.follow(flMotor);
        rrMotor.follow(frMotor);
    }

}
