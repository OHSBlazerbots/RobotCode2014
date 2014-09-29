/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Practice command for driving in a square.
 * @author blazerbots
 */
public class DriveInSquare extends CommandGroup {
    
    public DriveInSquare() {
        //Drive forward
        addSequential(new DriveForward(2, .4));
        
        //Turn
        addSequential(new Turn(85));
        
        //Drive forward
        addSequential(new DriveForward(2 , .4));
        
        //Turn
        addSequential(new Turn(85));
        
        //Drive forward
        addSequential(new DriveForward(2, .4));
        
        //Turn
        addSequential(new Turn(85));
        
        //Drive forward
        addSequential(new DriveForward(2, .4));
        
        //Turn
        addSequential(new Turn(85));
    }
}
