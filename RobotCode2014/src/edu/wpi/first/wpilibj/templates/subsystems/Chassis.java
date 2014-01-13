/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RBDrive;

/**
 *
 * @author sgoldman
 */
public class Chassis {
    //new RBDrive

    public static RBDrive drive;

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
        drive = new RBDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
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
}
