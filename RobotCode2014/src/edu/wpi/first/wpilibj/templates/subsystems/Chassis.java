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
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.GoToSetPoint;
import edu.wpi.first.wpilibj.templates.commands.PutGyroAccelData;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.templates.commands.GetDistance;

/**
 *
 * @author sgoldman
 */
public class Chassis extends PIDSubsystem {
    //new RBDrive

    public static RobotDrive drive;
    // Determines what type of driving, (auto, joystick...) we are doing
    // Joystick = 0
    // Auto = 1
    // Ball Track  = 2
    private static int driveState;
    private static double ratio;
    private boolean driveStraight, onlyTurn;
    private Gyro gyro;
   //private Accelerometer accelerometerX;
    //private Accelerometer accelerometerY;
    private ADXL345_I2C accel;
    private double setPoint,
            velocityX,
            velocityY, 
            distanceX,
            distanceY,
            tiltErrorX,
            tiltErrorY,
            distance;
    private AnalogChannel sonar;
    
    /**
     * Create an instance of the chassis class with the appropriate motors.
     *
     * @param frontLeftMotor
     * @param rearLeftMotor
     * @param frontRightMotor
     * @param rearRightMotor
     */
    public Chassis(int frontLeftMotor, int frontRightMotor, int gyroPort) {
        super("CHASSIS", 10.0, 5.0, 1.0);
        setSetpoint(320);
        setPercentTolerance(7);
        getPIDController().setContinuous(false);
        getPIDController().setInputRange(0, 360);
        getPIDController().setOutputRange(-.75, .75);
        getPIDController().disable();
        ratio = 1;
        velocityX = 0;
        velocityY = 0;
        distanceX = 0;
        distanceY = 0;
        driveStraight = false;
        onlyTurn = false;
        //Create new robot drive class with pin values for the two motors
        drive = new RobotDrive(frontLeftMotor, frontRightMotor);
        //Disables safety so we can drive
        drive.setSafetyEnabled(false);
        
        gyro = new Gyro(1, 1)/*(RobotMap.GYRO_PORT, 2);*/;
        //accelerometerX = new Accelerometer(2);
        //accelerometerY = new Accelerometer(3);
        gyro.startLiveWindowMode();
        //accelerometerX.startLiveWindowMode();
        //accelerometerY.startLiveWindowMode();
        accel = new ADXL345_I2C(1, ADXL345_I2C.DataFormat_Range.k2G);
        tiltErrorX = accel.getAcceleration(ADXL345_I2C.Axes.kX);
        tiltErrorY = accel.getAcceleration(ADXL345_I2C.Axes.kY);
        this.driveState = 0;
        setPoint = 0.0;
        distance = 0.0;
        sonar = new AnalogChannel(7);
    }

    /**
     * Command the chassis to drive with the joystick.
     *
     * @param joystick
     */
    public void driveWithJoyStick(Joystick joystick) {
        //Turn is the reverse of x
        double turn = -joystick.getX();
        //Drive is the y
        double move = joystick.getY();
        //Slow the robot down with the ratio
        move /= ratio;
        turn /= ratio;
        //Don't drive f/b if only turning is desired
        if(onlyTurn)
        {
            move = 0;
        }
        //Don't turn if only f/b driving is desired
        if(driveStraight)
        {
            turn = 0;
        }
        //Put drive values on the smart dashboard
        SmartDashboard.putNumber("Turn Value", turn);
        SmartDashboard.putNumber("Move Value", move);
        if (getSonarDistance() < 24.0 && move < 0)  // If less than 24 inches away, and moving forward
        {
            //move = 0;
        }
        drive.arcadeDrive(turn, move);
    }

    public void drive(double move, double turn) {
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
        if(getSonarDistance() < 24.0 && move < 0)
        {
            move = 0;
        }
        drive.arcadeDrive(move, turn);
    }

    /**
     * Starts drive with joystick as the default command l
     */
    protected void initDefaultCommand() {
        //Starts driving the robot with this non terminating command
        setDefaultCommand(new DriveWithJoystick());
    }

    //<editor-fold defaultstate="collapsed" desc="PID Stuff - not used">
    protected double returnPIDInput() {
        return gyro.pidGet();
    }
    
    protected void usePIDOutput(double d) {
//        if (getPIDController().isEnable()) {
//            double a = CommandBase.network.getNetworkVariable("COG_AREA");
//            double dv;
//            if (CommandBase.network.getNetworkVariable("CIRCLES_COUNT") > 0 && a / (480 * 640) < .9) {
//                dv = -1;
//            } else {
//                dv = 0;
//            }
//            if (!onTarget()) {
//                drive.arcadeDrive(d, dv);
//            } else {
//                drive.arcadeDrive(0, dv);
//            }
//        } else {
//            drive.arcadeDrive(0, 0);
//        }
    }
    //</editor-fold>

    //Returns the current method of driving the robot
    public int getState() {
        return driveState;
    }

    //Turns on ball tracking and following
    public void enableBallFollowing() {
        driveState = 1;
    }

    //Turns off ball tracking and following
    public void disableBallFollowing() {
        driveState = 0;
    }

    //Shifts up the ratio by .5 if it is less than 2.5 currently
    public void incrementRatio() {
        if (ratio < 2.5) {
            ratio += .5;
        }
    }

    //Shifts down the ratio by .5 if it is currently greater than 1
    public void decrementRatio() {
        if (ratio > 1) {
            ratio -= .5;
        }
    }
    
    //Converts the raw gyro angle to degrees and returns it
    public double getGyroAngle()
    {
        double angle = gyro.getAngle() % (360);
        if (angle < 0.0)
        {
            angle += 360;
        }
        return angle;
    }
    
    //Returns a double array
    //First number is x
    //Second number is y
    public double[] getAcceleration()
    {
        double[] a = new double[2];
        a[0] = accel.getAcceleration(ADXL345_I2C.Axes.kX)  - tiltErrorX;
        a[1] = accel.getAcceleration(ADXL345_I2C.Axes.kY)  - tiltErrorY;
        
        // Calculate the other kinematics values while we're at it
        velocityX += a[0];
        velocityY += a[1];
        distanceX += velocityX;
        distanceY += velocityY;
        return a;
    }
    
    public double[] getVelocity() {
        double[] v = {
            velocityX,
            velocityY
        };
        return v;
    }
    
    public double[] getDistance() {
        double[] d = {
            distanceX,
            distanceY
        };
        return d;
    }
    
    //Turns on and off just driving straight
    public void toggleDriveStraight()
    {
        driveStraight = !driveStraight;
    }
    
    //Turns on and off just turning
    public void toggleOnlyTurn()
    {
        onlyTurn = !onlyTurn;
    }
    
    //Sets the target angle to the current angle
    public void setGyroSetpoint()
    {
        setPoint = getGyroAngle();
        System.out.println(setPoint);
        
    }
    
    //Enables going to the target angle (setpoint)
    public void goToSetPoint()
    {
        driveState = 2;
    }
    
    //Return the sign of the number, or 0 if it is 0
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
    
    //Halts the going to target angle
    public void stopGoingToSetPoint()
    {
        driveState = 0;
    }
    
    //Returns the target angle
    public double getSetPoint()
    {
        return setPoint;
    }
    
    //Set the target angle to d degrees farther than it currently is
    public void turn(double d)
    {
        setPoint = (getGyroAngle() + d) % 360;
        System.out.println(getGyroAngle());
        System.out.println(setPoint);
        driveState = 2;
    }
    
    public double getSonarDistance()
    {
        double r = SmartDashboard.getNumber("Sonar Number", 4.0);
        double d = (sonar.getValue() / r * 2 / 2.54);
        distance = d;
        return d;
    }
}
