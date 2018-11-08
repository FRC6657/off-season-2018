package org.usfirst.frc.team6657.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int motorFrontLeftID = 1;
	public static int motorBackLeftID = 2;
	public static int motorFrontRightID = 3;
	public static int motorBackRightID = 4;
	
	public static int driveControllerID = 0;
	
	public static double joystickArcadeSpeedModifier = 1.0;
	public static double joystickArcadeRotationModifier = 1.0;
	
	public static double ladderWinchSpeed = 1;
	public static double clawSpeed = 0.5;
}