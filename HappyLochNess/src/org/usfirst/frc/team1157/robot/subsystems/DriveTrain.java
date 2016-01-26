package org.usfirst.frc.team1157.robot.subsystems;

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
	
    private CANJaguar frontLeft, frontRight, backLeft, backRight;
    
    private RobotDrive drive;
    private Encoder leftEncoder, rightEncoder;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DriveTrain() {
    	super();
    	frontRight = new CANJaguar(2);
    	backRight = new CANJaguar(3);
    	backLeft = new CANJaguar(4);
    	frontLeft = new CANJaguar(5);
    	drive = new RobotDrive(frontLeft, frontRight, backLeft, backRight);
    	
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDriveWithJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double left, double right) {
    	drive.tankDrive(left, right);
    }
    public void drive(Joystick joy) {
    	drive(joy.getY(), joy.getZ());
    }
}

