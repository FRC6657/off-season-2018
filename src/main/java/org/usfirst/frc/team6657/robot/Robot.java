package org.usfirst.frc.team6657.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6657.robot.commands.BaseDriveTimed;
import org.usfirst.frc.team6657.robot.commands.AutoSwitch;
import org.usfirst.frc.team6657.robot.commands.ControllerRefresh;
import org.usfirst.frc.team6657.robot.subsystems.Claw;
import org.usfirst.frc.team6657.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6657.robot.subsystems.LadderWinch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static LadderWinch ladderWinch;
	public static Claw claw;
	public static OI oi;
	
	public static double driveMaxOutput = 1.0d;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	SendableChooser<Double> driveChooser = new SendableChooser<>();
	
	BaseDriveTimed baselineAuto;
	AutoSwitch switchAuto;

	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		SmartDashboard.putData(driveTrain);
		ladderWinch = new LadderWinch();
		SmartDashboard.putData(ladderWinch);
		claw = new Claw();
		
		oi = new OI();
		
		baselineAuto = new BaseDriveTimed(2.5, 0.5);
		switchAuto = new AutoSwitch();
		
		chooser.addDefault("Baseline", baselineAuto);
		chooser.addObject("Conditional Switch Cube", switchAuto);
		SmartDashboard.putData("Auto mode", chooser);
		
		driveChooser.addDefault("100%", 1.0d);
		driveChooser.addDefault("60%", 0.6d);
		driveChooser.addObject("50%", 0.5d);
		driveChooser.addObject("Grandma Speed", 0.3d);
		SmartDashboard.putData("Motor Power", driveChooser);

		SmartDashboard.putData("Refresh Controller", new ControllerRefresh());
		
		driveTrain.reset();
		driveTrain.gyroCalibrate();
	}
	
	@Override
	public void robotPeriodic() {
		SmartDashboard.putNumber("Distance", driveTrain.getDistance());
		SmartDashboard.putNumber("Encoder Left", driveTrain.getEncoderLeft());
		SmartDashboard.putNumber("Encoder Right", driveTrain.getEncoderRight());
		SmartDashboard.putNumber("Gyro Angle", driveTrain.getAngle());
	}

	@Override
	public void disabledInit() {
		driveTrain.reset();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousInit() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		// FINISH ME!
		if (autonomousCommand != null)
			autonomousCommand.start();	
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.setMax((double) driveChooser.getSelected());
	}
}
