/**
 * Copyright 2012. FRC Team 3807.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 * This class maps controls with the joystick to driving the chassis.
 */
public class DriveWithJoystick extends CommandBase {

    /**
     * Construct this command.
     */
    public DriveWithJoystick() {
        // We need the chassis to drive with the joystick.
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Turn with joystick
        chassis.driveWithJoyStick(oi.getJoystick());
        
        //Place data: needs to move
        //SmartDashboard.putNumber("Current Angle: ", chassis.getGyroAngle());
        //SmartDashboard.putNumber("X: ", chassis.getAcceleration()[0]);
        //SmartDashboard.putNumber("Y: ", chassis.getAcceleration()[1]);
        SmartDashboard.putNumber("distanceX", chassis.getDistance()[0]);
        SmartDashboard.putNumber("distanceY", chassis.getDistance()[1]);
        SmartDashboard.putNumber("Sonar", chassis.getSonarDistance());
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
