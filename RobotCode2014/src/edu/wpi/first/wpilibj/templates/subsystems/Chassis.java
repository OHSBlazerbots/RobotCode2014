/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

/**
 *
 * @author sgoldman
 */
public class Chassis extends Subsystem {
    //new RBDrive

    public static RobotDrive drive;

    /**
     * Create an instance of the chassis class with the appropriate motors.
     *
     * @param frontLeftMotor
     * @param rearLeftMotor
     * @param frontRightMotor
     * @param rearRightMotor
     */
    public Chassis(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
        //Create new robot drive class with pin values for all four motors
        drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        //Disables safety so that you can drive
        drive.setSafetyEnabled(false);
    }

    /**
     * Command the chassis to drive with the joystick.
     *
     * @param joystick
     */
    public void driveWithJoyStick(Joystick joystick) {
        drive.arcadeDrive(joystick.getY(), -joystick.getX());
    }

    /**
     * Starts drive with joystick as the default command
     */
    protected void initDefaultCommand() {
        //Starts driving the robot with this non terminating command
        setDefaultCommand(new DriveWithJoystick());
    }
}
