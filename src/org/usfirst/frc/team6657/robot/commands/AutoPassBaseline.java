package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoPassBaseline extends TimedCommand {

	public AutoPassBaseline(double secondsToWait) {
		super(secondsToWait);
		requires(Robot.driveTrain);
		requires(Robot.claw);
	}
	
	@Override
	public void execute() {
		Robot.driveTrain.drive(0.5, 0.5);
	}
	
}
