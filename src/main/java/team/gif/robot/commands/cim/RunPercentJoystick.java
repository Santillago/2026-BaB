package team.gif.robot.commands.cim;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class RunPercentJoystick extends Command {

    public RunPercentJoystick() {
        super();
        addRequirements(Robot.cimMotor);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double percent = -Robot.oi.driver.getLeftY();
        Robot.cimMotor.runPercent(percent);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.cimMotor.stop();
    }
}
