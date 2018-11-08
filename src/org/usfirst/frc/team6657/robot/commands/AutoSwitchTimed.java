package org.usfirst.frc.team6657.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSwitchTimed extends CommandGroup{
	
	public AutoSwitchTimed() {
		setName("someconstantthatsidentifiableTIMED");
		addSequential(new BaseDriveTimed(5, 0.5));
		/*if(gameData != "") {
			gameData = gameData.substring(0, 1);
			int pos = DriverStation.getInstance().getLocation();
			if((gameData.equals("L") && pos == 1) || (gameData.equals("R") && pos == 3)) {
				addSequential(new LadderUpTimed(2)); //addSequential(new LadderUpTimedBad());
				addSequential(new ClawOpenTimed(0.5));
			}
		}*/
	}
	
	public void setGameData(String gameData) {
		if(gameData != "") {
			gameData = gameData.substring(0, 1);
			int pos = DriverStation.getInstance().getLocation();
			if((gameData.equals("L") && pos == 1) || (gameData.equals("R") && pos == 3)) {
				addSequential(new LadderUpTimed(2)); //addSequential(new LadderUpTimedBad());
				addSequential(new ClawOpenTimed(0.5));
			}
		}
	}
}
