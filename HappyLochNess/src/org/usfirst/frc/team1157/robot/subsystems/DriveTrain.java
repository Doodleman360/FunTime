package org.usfirst.frc.team1157.robot.subsystems;

import org.usfirst.frc.team1157.robot.RobotMap;
import org.usfirst.frc.team1157.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	CANJaguar frontLeft = RobotMap.frontLeftMotor;
	CANJaguar frontRight = RobotMap.frontRightMotor;
	CANJaguar backLeft = RobotMap.backLeftMotor;
	CANJaguar backRight = RobotMap.backRightMotor;
    //private CANJaguar frontLeft, frontRight, backLeft, backRight;
    
    private RobotDrive drive;
    private Encoder leftEncoder, rightEncoder;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DriveTrain() {
    	super();
    	drive = new RobotDrive(frontLeft, frontRight, backLeft, backRight);
    	
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDriveWithJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double speed, double rotate) {
    	drive.arcadeDrive(speed, rotate, true);
    }
    public void drive(Joystick joy) {
    	if (joy.getTrigger()) {
    		drive(-joy.getY(), joy.getZ());
    	} else {
    		drive(joy.getY(), -joy.getZ());
    	}
    }
}

