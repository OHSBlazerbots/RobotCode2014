package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;


/**
 * Turn right.
 * @author sgoldman
 */
public class TurnRight extends CommandBase {
    private double time, speed;
    
    public TurnRight(double seconds, double spd) {
        requires(chassis);
        this.time = seconds;
        speed = spd;    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.drive(0, -speed);
        new Timer().delay(this.time);
        chassis.drive(0,0);
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