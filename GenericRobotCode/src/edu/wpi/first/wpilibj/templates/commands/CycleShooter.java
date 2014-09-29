package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotValues;

/**
 * This is the command that automatically cycles the shooter.
 *
 * @author blazerbots
 */
public class CycleShooter extends CommandGroup {

    public CycleShooter() {
        addSequential(new Shoot());
        addSequential(new WaitCommand(RobotValues.WAIT_TIME_AFTER_SHOT));
        addSequential(new Pullback());
        addSequential(new WaitCommand(RobotValues.PULLBACK_TIME));
        addSequential(new StopPullAndLatch());
        addSequential(new WaitCommand(RobotValues.WAIT_TIME_AFTER_LATCH));
        addSequential(new ReleaseShooter());
        addSequential(new WaitCommand(RobotValues.RELEASE_TIME));
        addSequential(new StopRelease());
    }
}
