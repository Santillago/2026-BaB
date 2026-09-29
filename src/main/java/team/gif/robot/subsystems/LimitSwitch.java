// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimitSwitch extends SubsystemBase {

    private final DigitalInput limitSwitch;

    public LimitSwitch(int channel) {
        limitSwitch = new DigitalInput(channel);
    }

    public boolean getValue() {
        return limitSwitch.get();
    }

}
