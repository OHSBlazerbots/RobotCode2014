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
        // If ball is on the right side of the screen, turn right
        
        if(x > 340)
        {
            chassis.drive(-.4, 0);
        }
        // If it is on the left side of the screen, turn left
        else if(x < 300)
        {
            //Left side is faster because these motors appear to be weaker
            chassis.drive(.4, 0);
        }
        // Otherwise, it is pretty much center, so don't more
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