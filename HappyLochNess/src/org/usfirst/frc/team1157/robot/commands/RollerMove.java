package org.usfirst.frc.team1157.robot.commands;

import org.usfirst.frc.team1157.robot.Robot;
import org.usfirst.frc.team1157.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollerMove extends Command {
	int direction;

	public RollerMove(int dir) {
		requires(Robot.roller);
		direction = dir;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (direction == 1) {
			Roller.forward();
		} else if (direction == -1) {
			Roller.backward();
		} else {
			Roller.stop();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
