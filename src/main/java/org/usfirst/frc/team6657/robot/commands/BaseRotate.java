package org.usfirst.frc.team6657.robot.commands;

import org.usfirst.frc.team6657.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class BaseRotate extends PIDCommand {
	
	public BaseRotate(double angle) {
		super(2.0, 0.0, 0.0);
		
		requires(Robot.driveTrain);
		
		getPIDController().reset();
		getPIDController().setOutputRange(-0.5d,  0.5d);
		getPIDController().setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(true);
		
		setSetpoint(angle);
	}

	@Override
	public void initialize() {
		Robot.driveTrain.reset();
	}
	
	@Override
	protected double returnPIDInput() {
		return Robot.driveTrain.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveTrain.arcadeDrive(0.5, output);
	}

	@Override
	protected boolean isFinished() {
		return getPIDController().onTarget();
	}
}
