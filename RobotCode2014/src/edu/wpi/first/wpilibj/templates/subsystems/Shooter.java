/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

/**
 * Deals with shooter assets.
 * @author jmuller4
 */
public class Shooter extends Subsystem {

    // Tells us the current speed of the shooter
    private double shooterSpeed;
    //The spike
    private final Relay relay;
    private final Servo servo;

    //Contruct
    public Shooter(int channel, int servoChannel) {
        relay = new Relay(channel);
        servo = new Servo(servoChannel);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    //Run the pullback mechanism
    public void runShooter(double speed) {
        if (speed > 0) {
            relay.set(Relay.Value.kForward);
        }
        if (speed < 0) {
            relay.set(Relay.Value.kReverse);
        }
        shooterSpeed = speed;
    }

    //Run the pullback mechanism for a specified amount of time
    public void runShooter(double speed, double seconds) {
        // Limit the speed of the motor - we dont want to die
        if (speed > 0) {
            relay.set(Relay.Value.kForward);
        }
        if (speed < 0) {
            relay.set(Relay.Value.kReverse);
        }
        //Set the speed
        shooterSpeed = speed;
        //Let it run for seconds
        Timer.delay(seconds);
        //Stop now, please
        stopShooter();
    }

    //Stop the shooter
    public void stopShooter() {
        relay.set(Relay.Value.kOff);
        shooterSpeed = 0;
    }
    
    //Get speed
    public double getCurrentSpeed()
    {
        return shooterSpeed;
    }
    
    //Set servo angle
    public void setServoAngle(double d)
    {
        servo.setAngle(d);
    }
    
    //Get servo angle
    public double getServoAngle()
    {
        return servo.getAngle();
    }
}