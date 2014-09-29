/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Invert the driving controls by negating the drive ratio.
 * @author jmuller4
 */
public class InvertDrivingDirection extends CommandBase {
    
    public InvertDrivingDirection() {
        //We need to change chassis values
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Negate ratio
        chassis.negatetRatio();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // This command is always finished because there is nothing in execute
    protected boolean isFinished() {
        //Do this once
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}