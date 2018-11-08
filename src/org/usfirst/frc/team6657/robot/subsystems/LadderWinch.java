package org.usfirst.frc.team6657.robot.subsystems;

import org.usfirst.frc.team6657.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LadderWinch extends Subsystem {
	
	private Spark winch = new Spark(0);

	public LadderWinch() {
		
	}

	@Override
	protected void initDefaultCommand() {
	}
	
	public void runWinch() {
		winch.set(RobotMap.ladderWinchSpeed);
	}
	
	public void reverseWinch() {
		winch.set(-RobotMap.ladderWinchSpeed);
	}
	
	public void stop() {
		winch.set(0);
	}
}
