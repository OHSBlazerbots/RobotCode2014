/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author blazerbots
 */
public class DriveInSquare extends CommandGroup {
    
    public DriveInSquare() {
        addSequential(new DriveForward(2, .4));
        addSequential(new Turn(85));
        addSequential(new DriveForward(2 , .4));
        addSequential(new Turn(85));
        addSequential(new DriveForward(2, .4));
        addSequential(new Turn(85));
        addSequential(new DriveForward(2, .4));
        addSequential(new Turn(85));
    }
}
