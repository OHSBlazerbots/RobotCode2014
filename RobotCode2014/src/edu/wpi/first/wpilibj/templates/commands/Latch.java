/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotValues;

/**
 * Latch the shooter in place with the hook.
 * @author blazerbots
 */
public class Latch extends CommandBase {
    
    public Latch() {
        //We need the shooter to latch
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Set the servo to the latch position
            shooter.setServoAngle(RobotValues.SERVO_LATCH);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
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
