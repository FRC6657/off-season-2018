package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickArcadeDrive extends Command {

	public JoystickArcadeDrive() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void execute() {
		if (Robot.oi.getControllerType() == GenericHID.HIDType.kHIDJoystick) 
			Robot.driveTrain.arcadeDrive(Robot.oi.getArcadeSpeed(), Robot.oi.getArcadeRoationThrottle());
		else 
			Robot.driveTrain.drive(Robot.oi.getControllerLeftSpeed(), Robot.oi.getControllerRightSpeed());
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.stop();
		Robot.driveTrain.reset();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
