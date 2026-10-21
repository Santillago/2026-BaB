package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class ArcadeDrive extends Command {

    double speed;
    double turn;

    public ArcadeDrive() {
        super();
//        addRequirements(Robot.drive);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        speed = Robot.oi.driver.getLeftY();
        turn = Robot.oi.driver.getRightX();

//        Robot.drive.arcadeDrive(-speed, -turn);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
