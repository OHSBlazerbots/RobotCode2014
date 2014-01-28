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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author sgoldman
 */
public class Chassis extends PIDSubsystem {
    //new RBDrive

    public static RobotDrive drive = new RobotDrive(RobotMap.FRONT_LEFT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR);
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
        super("CHASSIS", 10.0, 5.0, 1.0);
        setSetpoint(320);
        setPercentTolerance(7);
        getPIDController().setContinuous(false);
        getPIDController().setInputRange(0, 640);
        getPIDController().setOutputRange(-.75, .75);
        getPIDController().disable();

        //Create new robot drive class with pin values for all four motors
        //drive = new RobotDrive(frontLeftMotor, frontRightMotor);
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
        double turn = -joystick.getX();
        double move = joystick.getY();
        double ratio = SmartDashboard.getNumber("Speed Ratio", 1);
        move /= ratio;
        turn /= ratio;
        SmartDashboard.putNumber("Turn Value", turn);
        SmartDashboard.putNumber("Move Value", move);
        drive.arcadeDrive(turn, move);
    }

    public void drive(double moveValue, double turnValue) {
        drive.arcadeDrive(moveValue, turnValue);
    }

    /**
     * Starts drive with joystick as the default command l
     */
    protected void initDefaultCommand() {
        //Starts driving the robot with this non terminating command
        setDefaultCommand(new DriveWithJoystick());
    }

    protected double returnPIDInput() {
        return CommandBase.network.getNetworkVariable("COG_X");
    }

    protected void usePIDOutput(double d) {
        if (getPIDController().isEnable()) {
            double a = CommandBase.network.getNetworkVariable("COG_AREA");
            double dv = 0.0;
            if (CommandBase.network.getNetworkVariable("CIRCLES_COUNT") > 0 && a / (480 * 640) < .9) {
                dv = -1;
            } else {
                dv = 0;
            }
            if (!onTarget()) {
                drive.arcadeDrive(d, dv);
            } else {
                drive.arcadeDrive(0, dv);
            }
        } else {
            drive.arcadeDrive(0, 0);
        }
    }

    public int getState() {
        return driveState;
    }

    public void enableBallFollowing() {
        driveState = 1;
    }

    public void disableBallFollowing() {
        driveState = 0;
    }
}
