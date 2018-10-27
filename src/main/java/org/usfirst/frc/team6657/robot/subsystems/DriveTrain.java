package org.usfirst.frc.team6657.robot.subsystems;

import org.usfirst.frc.team6657.robot.RobotMap;
import org.usfirst.frc.team6657.robot.commands.JoystickArcadeDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {

	private WPI_TalonSRX motorFrontLeft = new WPI_TalonSRX(RobotMap.motorFrontLeftID);
	private WPI_TalonSRX motorBackLeft = new WPI_TalonSRX(RobotMap.motorBackLeftID);
	//private SpeedControllerGroup controllersLeft = new SpeedControllerGroup(motorFrontLeft, motorBackLeft);
	
	private WPI_TalonSRX motorFrontRight = new WPI_TalonSRX(RobotMap.motorFrontRightID);
	private WPI_TalonSRX motorBackRight = new WPI_TalonSRX(RobotMap.motorBackRightID);
	//private SpeedControllerGroup controllersRight = new SpeedControllerGroup(motorFrontRight, motorBackRight);
	
	private Encoder encoderLeft = new Encoder(0, 1, true, Encoder.EncodingType.k2X);
	private Encoder encoderRight = new Encoder(2, 3, false, Encoder.EncodingType.k2X);
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private static double distancePerRevolution = 15.2 * Math.PI;
	private static double pulsesPerRevolution = 1440;
	private static double distancePerPulse = distancePerRevolution / pulsesPerRevolution;
	
	private DifferentialDrive drive;//= new DifferentialDrive(controllersLeft, controllersRight);
	
	private double driveMax = 1.0d;
	
	public DriveTrain() {

		encoderLeft.setDistancePerPulse(distancePerPulse);
		encoderRight.setDistancePerPulse(distancePerPulse);
		
		motorBackLeft.follow(motorFrontLeft);
		motorBackRight.follow(motorFrontRight);
		
		motorFrontLeft.configOpenloopRamp(0.3, 0);
		motorFrontRight.configOpenloopRamp(0.3, 0);

		drive = new DifferentialDrive(motorFrontLeft, motorFrontRight);
		
		reset();
		gyroCalibrate();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickArcadeDrive());
	}
	
	public void setMax(double max) {
		driveMax = max;
	}
	
	public void arcadeDrive(double speed, double rotation) {
		
		drive.arcadeDrive(driveMax * speed, driveMax * rotation);
	}
	
	public void reset() {
		encoderLeft.reset();
		encoderRight.reset();
		gyro.reset();
	}
	
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	public double getDistance() {
		return ((encoderLeft.getDistance()  + encoderRight.getDistance()) / 2);
	}
	
	public double getEncoderLeft() {
		return encoderLeft.getDistance();
	}
	
	public double getEncoderRight() {
		return encoderRight.getDistance();
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	public void gyroCalibrate() {
		gyro.calibrate();
	}
	
	public void stop() {
		drive.tankDrive(0, 0);
		reset();
	}
}