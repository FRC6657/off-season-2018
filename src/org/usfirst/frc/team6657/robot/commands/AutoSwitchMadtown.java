package org.usfirst.frc.team6657.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSwitchMadtown extends CommandGroup {
	public AutoSwitchMadtown(String gameData) {
		// Will pass baseline no matter what
		addSequential(new AutoPassBaseline(5));
		if(gameData != "") {
			gameData = gameData.substring(0, 1);
			// Conditionally drops cube if we're lined up for it. Ideally this would be a config option in the DS
			if(gameData.equals("L")) {
				addSequential(new LadderUpTimedBad());
				addSequential(new ClawOpenTimed(0.5));
			}
		}
	}
}
