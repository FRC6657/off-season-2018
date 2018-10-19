package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class LadderUpTimed extends TimedCommand {

	public LadderUpTimed(double timeout) {
		super(timeout);
		requires(Robot.ladderWinch);
	}
	
	@Override
	public void execute() {
		Robot.ladderWinch.runWinch();
	}
	
	@Override
	public void end() {
		Robot.ladderWinch.stop();
	}
}
