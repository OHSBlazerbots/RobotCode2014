/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CenterOnBall;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

/**
 *nn
 * @author sgoldman
 */
public class Chassis extends PIDSubsystem {
    //new RBDrive

    public static RobotDrive drive = new RobotDrive(RobotMap.FRONT_LEFT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR);;
    
    // Determines what type of driving, (auto, joystick...) we are doing
    // Joystick = 0
    // Auto = 1
    // Ball Track  = 2
    
    private static int driveState;

    /**
     * Create an instance of the chassis class with the appropriate motors.
     *
     * @param frontLeftMotor
     * @param rearLeftMotor
     * @param frontRightMotor
     * @param rearRightMotor
     */
    public Chassis(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
        super("CHASSIS", 1.0, 0.0, 0.0);
        getPIDController().setContinuous(false);
        getPIDController().setInputRange(0, 640);
        getPIDController().setOutputRange(-.75, .75);
        //Create new robot drive class with pin values for all four motors
        drive = new RobotDrive(frontLeftMotor, frontRightMotor);
        //Disables safety so that you can drive
        drive.setSafetyEnabled(false);
        this.driveState = 0;
    }

    /**
     * Command the chassis to drive with the joystick.
     *
     * @param joystick
     */
    public void driveWithJoyStick(Joystick joystick) {
        drive.arcadeDrive(-joystick.getX(), joystick.getY());
    }
    
    public void drive(double moveValue, double turnValue){
        drive.arcadeDrive(moveValue, turnValue);
    }

    /**
     * Starts drive with joystick as the default command
    l */
    protected void initDefaultCommand() {
        //Starts driving the robot with this non terminating command
        setDefaultCommand(new DriveWithJoystick());
    }

    protected double returnPIDInput() {
        return CommandBase.network.getNetworkVariable("COG_X");
    }

    protected void usePIDOutput(double d) {
        drive.arcadeDrive(d, 0.0);
    }
    
    public boolean getState()
    {
        return getPIDController().isEnable();
    }
    
    public void enableBallFollowing()
    {
        enable();
    }
    
    public void disableBallFollowing()
    {
        disable();
    }
}
