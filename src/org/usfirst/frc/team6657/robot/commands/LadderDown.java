package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LadderDown extends Command {

	public LadderDown() {
		requires(Robot.ladderWinch);
	}
	
	@Override
	protected void execute() {
		Robot.ladderWinch.reverseWinch();
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
