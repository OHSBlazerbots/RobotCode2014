/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author sgoldman
 */
public class CenterOnBall extends CommandBase {
    
    public CenterOnBall() {
        // Use requires() here to declare subsystem dependencies
        requires(network);
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double x = network.getNetworkVariable("COG_X");
        if(x > 340)
        {
            chassis.drive(0, 1);
        }
        else if(x < 300)
        {
            chassis.drive(0, -1);
        }
        else
        {
            chassis.drive(0, 0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}