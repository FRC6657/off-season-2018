package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PIDAutoTest extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.driveTrain.onTarget();
	}
	
	public PIDAutoTest() {
		requires(Robot.driveTrain);
	}
	
	@Override
	public void initialize() {
		Robot.driveTrain.reset();
		Robot.driveTrain.setSetpoint(100);
		
	}
	
	@Override
	public void execute() {
		Robot.driveTrain.enable();
	}
}