/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author jmuller4
 */
public class InvertDrivingDirection extends CommandBase {
    
    public InvertDrivingDirection() {
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.negatetRatio();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // This command is always finished because there is nothing in execute
    protected boolean isFinished() {
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