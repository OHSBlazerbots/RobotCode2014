/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CenterOnBall;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.GoToSetPoint;
import edu.wpi.first.wpilibj.templates.commands.PutGyroAccelData;

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
    private static double ratio;
    private boolean driveStraight;
    private boolean onlyTurn;
    private Gyro gyro;
    private Accelerometer accelerometerX;
    private Accelerometer accelerometerY;
    private double setPoint;
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
        getPIDController().setInputRange(0, 360);
        getPIDController().setOutputRange(-.75, .75);
        getPIDController().disable();
        ratio = 1;
        driveStraight = false;
        onlyTurn = false;
        //Create new robot drive class with pin values for all four motors
        //drive = new RobotDrive(frontLeftMotor, frontRightMotor);
        //Disables safety so that you can drive
        drive.setSafetyEnabled(false);
        
        gyro = new Gyro(1, 1)/*(RobotMap.GYRO_PORT, 2);*/;
        accelerometerX = new Accelerometer(4);
        accelerometerY = new Accelerometer(5);
        gyro.startLiveWindowMode();
        accelerometerX.startLiveWindowMode();
        accelerometerY.startLiveWindowMode();
        this.driveState = 0;
        setPoint = 0.0;
                
    }

    /**
     * Command the chassis to drive with the joystick.
     *
     * @param joystick
     */
    public void driveWithJoyStick(Joystick joystick) {
        double turn = -joystick.getX();
        double move = joystick.getY();
        //double ratio = SmartDashboard.getNumber("Speed Ratio", 1);
        //System.out.println("SR: " + ratio);
        move /= ratio;
        turn /= ratio;
        if(onlyTurn)
        {
            move = 0;
        }
        if(driveStraight)
        {
            turn = 0;
        }
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
        //setDefaultCommand(new PutGyroAccelData());
    }

    protected double returnPIDInput() {
        return gyro.pidGet();
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

    public void incrementRatio() {
        if (ratio < 2.5) {
            ratio += .5;
        }
    }

    public void decrementRatio() {
        if (ratio > 1) {
            ratio -= .5;
        }
    }
    
    public double getGyroAngle()
    {
        double angle = gyro.getAngle() % (360);
        if (angle < 0.0)
        {
            angle += 360;
        }
        return angle;
    }
    
    public double[] getAcceleration()
    {
        double[] a = new double[2];
        a[0] = accelerometerX.getAcceleration();
        a[1] = accelerometerY.getAcceleration();
        return a;
    }
    
    public void toggleDriveStraight()
    {
        driveStraight = !driveStraight;
    }
    
    public void toggleOnlyTurn()
    {
        onlyTurn = !onlyTurn;
    }
    
    public void setGyroSetpoint()
    {
        setPoint = getGyroAngle();
        System.out.println(setPoint);
        
    }
    
    public void goToSetPoint()
    {
        driveState = 2;
    }
    
    public int sign(double value)
    {
        if(value == 0)
        {
            //If it is 0, there is no sign
            return 0;
        }
        else if(value > 0){
            //If it is greater than 0, it is positive
            return 1;
        }
        else{
            //If it is not 0 or greater than zero, it is less than 0 and thus negative
            return -1;
        }
    }
    
    public void stopGoingToSetPoint()
    {
        driveState = 0;
    }
    
    public double getSetPoint()
    {
        return setPoint;
    }
    
    public void turn(double d)
    {
        setPoint = (getGyroAngle() + d) % 360;
        System.out.println(getGyroAngle());
        System.out.println(setPoint);
        driveState = 2;
    }
}
