/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author sgoldman
 */
public class ToggleBallFollowing extends CommandBase {
    
    public ToggleBallFollowing() {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        requires(network);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(chassis.getState())
        {
            chassis.disableBallFollowing();
        }
        else{
            chassis.enableBallFollowing();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
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