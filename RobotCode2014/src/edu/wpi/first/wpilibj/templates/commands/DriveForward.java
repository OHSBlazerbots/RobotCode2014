package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 * Drive forward for a specified duration and at a specified speed.
 * @author blazerbots
 */
public class DriveForward extends CommandBase{
    private double time, speed;
    public DriveForward(double seconds, double spd) {
        //We need to drive
        requires(chassis);
        //Set the time that this will run
        this.time = seconds;
        //Set the speed that this will run at
        speed = spd;
    }

    protected void initialize() {
        //Drive at speed
        chassis.drive(-speed, 0);
        
        //Wait
        new Timer().delay(this.time);
        
        //Stop
        chassis.drive(0,0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        //Only do this once
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
