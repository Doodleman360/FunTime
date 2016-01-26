package org.usfirst.frc.team1157.robot.commands;

import org.usfirst.frc.team1157.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAuto extends Command {

	double startTime, time, leftSpeed, rightSpeed;

	public DriveAuto(double Itime, double IleftSpeed, double IrightSpeed) {
		requires(Robot.drivetrain);
		time = Itime;
		leftSpeed = IleftSpeed;
		rightSpeed = IrightSpeed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		startTime = Timer.getMatchTime();
		Robot.drivetrain.drive(leftSpeed, rightSpeed);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Timer.getMatchTime() - startTime > time) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
