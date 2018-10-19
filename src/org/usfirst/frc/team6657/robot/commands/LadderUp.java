package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LadderUp extends Command {

	public LadderUp() {
		requires(Robot.ladderWinch);
	}
	
	@Override
	protected void execute() {
		Robot.ladderWinch.runWinch();
	}
	
	@Override
	protected void end() {
		Robot.ladderWinch.stop();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
