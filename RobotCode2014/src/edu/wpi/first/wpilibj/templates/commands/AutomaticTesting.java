package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * This command runs through all parts of the robot for testing purposes.
 * @author sgoldman
 */
public class AutomaticTesting extends CommandGroup {
    
    public AutomaticTesting() {
        // wait to check if compressor is running
        addSequential(new WaitCommand(5));
        
        // Testing driving forward with different speeds: slow, medium, and fast
        addSequential(new DriveForward(3.0, .33));
        addSequential(new DriveForward(3.0, .66));
        addSequential(new DriveForward(3.0,  1.0));
        addSequential(new WaitCommand(1));
        
        //Testing driving backwards with same different speeds
        addSequential(new DriveForward(3.0, -0.33));
        addSequential(new DriveForward(3.0, -0.66));
        addSequential(new DriveForward(3.0, -1.0));
        addSequential(new WaitCommand(1));
        
        //Testing turning right with same different speeds
        addSequential(new TurnRight(3.0, .33));
        addSequential(new TurnRight(3.0, .66));
        addSequential(new TurnRight(3.0, 1.0));
        addSequential(new WaitCommand(1));
        
        //Testing turning left with same different speeds
        addSequential(new TurnLeft(3.0, .33));
        addSequential(new TurnLeft(3.0, .66));
        addSequential(new TurnLeft(3.0, 1.0));
        addSequential(new WaitCommand(1));
        
        /* Commented out for testing on old bot - replace for new bot
        //Wait to check pressure at 120 psi
        addSequential(new WaitCommand(10));
        
        //Pulling up picker
        addSequential(new TogglePickerUpDown());
        addSequential(new WaitCommand(4));
        
        //Pulling down picker
        addSequential(new TogglePickerUpDown());
        addSequential(new WaitCommand(4));
        
        //Starting picker wheels
        addSequential(new TogglePickerRun());
        addSequential(new WaitCommand(5));
        
        //Stopping Picker Wheels
        addSequential(new TogglePickerRun());
        addSequential(new WaitCommand(5));
    
        //Shooting shooter
        addSequential(new TestCycleShooter());
        * */
    }
}