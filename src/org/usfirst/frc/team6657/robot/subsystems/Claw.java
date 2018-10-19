package org.usfirst.frc.team6657.robot.subsystems;

import org.usfirst.frc.team6657.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
	
	private Spark cl = new Spark(1);

	public Claw() {
		
	}

	@Override
	protected void initDefaultCommand() {
	}
	
	public void open() {
		cl.set(-RobotMap.clawSpeed);
	}
	
	public void close() {
		cl.set(RobotMap.clawSpeed);
	}
	
	public void stop() {
		cl.set(0);
	}
}