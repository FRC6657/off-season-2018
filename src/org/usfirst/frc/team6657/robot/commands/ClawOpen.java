package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawOpen extends Command {

	public ClawOpen() {
		requires(Robot.claw);
	}
	
	@Override
	protected void execute() {
	Robot.claw.open();
	}
	
	@Override
	protected void end() {
		Robot.claw.stop();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
