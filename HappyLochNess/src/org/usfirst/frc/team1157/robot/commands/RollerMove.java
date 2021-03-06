package org.usfirst.frc.team1157.robot.commands;

import org.usfirst.frc.team1157.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollerMove extends Command {
    int direction;

    public RollerMove(int dir, double time) {

	setTimeout(time);
	requires(Robot.roller);
	direction = dir;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	if (direction == 1) {
	    Robot.roller.forward();
	} else if (direction == -1) {
	    Robot.roller.backward();
	} else {
	    Robot.roller.stop();
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
	Robot.roller.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	end();
    }
}
