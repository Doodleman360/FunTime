package org.usfirst.frc.team1157.robot.subsystems;

import org.usfirst.frc.team1157.robot.RobotMap;
import org.usfirst.frc.team1157.robot.commands.ArmWithJoystick;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmWithoutPID extends Subsystem {

    CANJaguar motor = RobotMap.armMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {

//	motor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
//	motor.enableControl();
//	motor.set(0.0);
	// Set the default command for a subsystem here.

	setDefaultCommand(new ArmWithJoystick());
    }

    public void armControl(Joystick joy) {
	motor.set(0.5 * joy.getY());
    }

    public boolean speed(double speed) {
	if (speed < 1 || speed > -1) {
	    motor.set(speed);
	} else {
	    return false;
	}
	return true;
    }

    public void forward() {
	motor.set(1.0);

    }

    public void backward() {
	motor.set(-1.0);
    }

    public void stop() {
	motor.set(0.0);
    }
}
