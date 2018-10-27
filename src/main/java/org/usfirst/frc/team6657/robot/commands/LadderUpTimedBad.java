package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LadderUpTimedBad extends Command {

	long acc = 0;
	boolean finished;
	
	public LadderUpTimedBad() {
		requires(Robot.ladderWinch);
	}
	
	@Override
	protected void execute() {
		if(acc < 2000) Robot.ladderWinch.runWinch();
		else {
			Robot.ladderWinch.stop();
			finished = true;
		}
		
		// This was really dumb and hacky and honestly has way to high of a chance of failing - NEVER AGAIN
		try {
			Thread.sleep(50);
			acc += 50;
		}catch(Exception e) {
			
		}
	}

	
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
}
