package edu.wpi.first.wpilibj.templates.commands;

/**
 * Decrease the ratio for driving.
 * This actually speeds the robot off.
 * @author blazerbots
 */
public class DecrementDriveRatio extends CommandBase{
    public DecrementDriveRatio(){
        //Change chassis properties
        requires(chassis);
    }

    protected void initialize() {
        //Try to decrease the ratio
        chassis.decrementRatio();
    }

    protected void execute() {
   }

    protected boolean isFinished() {
        //Only do it once
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
