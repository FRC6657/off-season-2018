package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class ClawOpenTimed extends TimedCommand {

	// Used for the auto claw and doesn't require manual control
	public ClawOpenTimed(double timeout) {
		super(timeout);
		requires(Robot.claw);
	}

	@Override
	public void execute() {
		Robot.claw.open();
	}
	
	@Override
	public void end() {
		Robot.claw.stop();
	}
}
