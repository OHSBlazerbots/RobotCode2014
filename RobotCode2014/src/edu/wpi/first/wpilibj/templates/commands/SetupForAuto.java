/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotValues;

/**
 *
 * @author blazerbots
 */
public class SetupForAuto extends CommandGroup {
    
    public SetupForAuto() {
        addSequential(new Pullback());
        addSequential(new WaitCommand(RobotValues.PULLBACK_TIME));
        addSequential(new StopPullAndLatch());
        addSequential(new WaitCommand(RobotValues.WAIT_TIME_AFTER_LATCH));
        addSequential(new ReleaseShooter());
        addSequential(new WaitCommand(RobotValues.RELEASE_TIME));
        addSequential(new StopRelease());
    }
}
