package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class BaseDriveStraight extends PIDCommand {
	
	public BaseDriveStraight(double distance) {
		super(2.0, 0.0, 0.0);
		
		requires(Robot.driveTrain);
		
		getPIDController().reset();
		getPIDController().setOutputRange(-0.5d,  0.5d);
		getPIDController().setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);
		
		setSetpoint(distance);
	}
	
	@Override
	public void initialize() {
		Robot.driveTrain.reset();
	}
	
	@Override
	protected double returnPIDInput() {
		return Robot.driveTrain.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveTrain.drive(output, output);	
	}

	@Override
	protected boolean isFinished() {
		return getPIDController().onTarget();
	}

}
