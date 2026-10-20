package team.gif.robot.commands.neo;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class RunVolts extends Command {

    private final double volts;

    public RunVolts(double v) {
        super();
        addRequirements(Robot.neoMotor);
        volts = v;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.neoMotor.setVoltage(volts);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.neoMotor.stop();
    }
}
