package team.gif.robot.commands.cim;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class RunPercent extends Command {

    private final double percent;

    public RunPercent(double percent) {
        super();
        addRequirements(Robot.cimMotor);
        this.percent = percent;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
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
