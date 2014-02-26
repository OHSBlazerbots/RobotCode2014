/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Unwind the the pullback cord.
 * @author blazerbots
 */
public class ReleaseShooter extends CommandBase {
    
    public ReleaseShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Run the shooter pullback backwards
        shooter.runShooter(-.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //Will run until button is released
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
