package org.usfirst.frc.team6657.robot;

import org.usfirst.frc.team6657.robot.commands.ClawClose;
import org.usfirst.frc.team6657.robot.commands.ClawOpen;
import org.usfirst.frc.team6657.robot.commands.LadderDown;
import org.usfirst.frc.team6657.robot.commands.LadderUp;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public GenericHID controller;
	public Button ladderUp;
	public Button ladderDown;
	public Button clawOpen;
	public Button clawClose;
	
	public OI(boolean IsXbox) {
		if (IsXbox) {
			controller = new XboxController(RobotMap.driveControllerID);
			ladderUp = new JoystickButton(controller, 1);
			ladderDown = new JoystickButton(controller, 2);
			clawOpen = new JoystickButton(controller, 3);
			clawClose = new JoystickButton(controller, 4);
		}
		else {
			controller = new Joystick(RobotMap.driveControllerID);
			ladderUp = new JoystickButton(controller, 1);
			ladderDown = new JoystickButton(controller, 2);
			clawOpen = new JoystickButton(controller, 3);
			clawClose = new JoystickButton(controller, 4);
		}
		
		
		LadderUp lu = new LadderUp();
		ladderUp.whileHeld(lu);
		
		LadderDown ld = new LadderDown();
		ladderDown.whileHeld(ld);
		
		ClawOpen co = new ClawOpen();
		clawOpen.whileHeld(co);
		
		ClawClose cc = new ClawClose();
		clawClose.whileHeld(cc);
	}
	
	public double getArcadeSpeed() {
		double supaY = ((Joystick) controller).getY();
		return -supaY*supaY*Math.signum(supaY) * RobotMap.joystickArcadeSpeedModifier;
	}
	
	public double getArcadeRotation() {
		double supaTwist = ((Joystick) controller).getTwist();
		return supaTwist * RobotMap.joystickArcadeRotationModifier;
	}
	
	public double getArcadeRoationThrottle() {
		double supaTwist = ((Joystick) controller).getTwist();
		return supaTwist;
	}
	
	public double getScaledThrottle() {
		double supaThrottle = ((Joystick) controller).getThrottle();
		return (0.5 * supaThrottle) + 0.5;
	}
	public double getControllerLeftSpeed() {
		double yHolderLeft = ((XboxController) controller).getY(GenericHID.Hand.kLeft);
		return -yHolderLeft*yHolderLeft*Math.signum(yHolderLeft) * RobotMap.joystickArcadeSpeedModifier;
	}
	public double getControllerRightSpeed() {
		double yHolderRight = ((XboxController) controller).getY(GenericHID.Hand.kRight);
		return -yHolderRight*yHolderRight*Math.signum(yHolderRight) * RobotMap.joystickArcadeSpeedModifier;
	}
	public GenericHID.HIDType getControllerType() {
		return controller.getType();
	}
}
