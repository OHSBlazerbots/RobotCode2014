/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author jmuller4
 */
public class Shooter extends Subsystem {

    // Tells us the current speed of the shooter
    private double shooterSpeed;
    //The speed controller
    private SpeedController controller;
    private Servo servo;

    public Shooter(int channel, int servoChannel) {
        controller = new Jaguar(channel);
        servo = new Servo(servoChannel);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void runShooter(double speed) {
        // Limit the speed of the motor - we dont want to die
        if (speed > 1.0) {
            speed = 1.0;
        }
        if (speed < -1.0) {
            speed = -1.0;
        }
        //Set the speed
        controller.set(speed);
        shooterSpeed = speed;
    }

    public void runShooter(double speed, double seconds) {
        // Limit the speed of the motor - we dont want to die
        if (speed > 1.0) {
            speed = 1.0;
        }
        if (speed < -1.0) {
            speed = -1.0;
        }
        //Set the speed
        controller.set(speed);
        shooterSpeed = speed;
        //Let it run for seconds
        Timer.delay(seconds);
        //Stop now, please
        stopShooter();
    }
    //hi joey and sam
    //Stop the shooter
    public void stopShooter() {
        controller.set(0.0);
        shooterSpeed = 0;
    }
    
    public double getCurrentSpeed()
    {
        return shooterSpeed;
    }
    
    public void setServoAngle(double d)
    {
        servo.setAngle(d);
    }
    
    public double getServoAngle()
    {
        return servo.getAngle();
    }
}