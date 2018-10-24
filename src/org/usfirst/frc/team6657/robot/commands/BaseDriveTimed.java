package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class BaseDriveTimed extends TimedCommand {
	private double driveSpeed;
	public BaseDriveTimed(double secondsToWait, double speed) {
		super(secondsToWait);
		driveSpeed = speed;
		requires(Robot.driveTrain);
	}
	
	@Override
	public void execute() {
		Robot.driveTrain.drive(driveSpeed, driveSpeed);
	}
	
}
