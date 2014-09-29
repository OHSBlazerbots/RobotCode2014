/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author sgoldman
 */
public class SubsystemOne extends Subsystem {

    Relay relay1;
    Relay relay2;
    Jaguar jag1;
    Jaguar jag2;
    Servo servo1;
    Servo servo2;

    public void initDefaultCommand() {
    }

    public SubsystemOne(int relay1Port, int relay2Port, int jag1Port, int jag2Port, int servo1Port, int servo2Port) {
        if (relay1Port > -1) {
            this.relay1 = new Relay(relay1Port);
        }
        if (relay2Port > -1) {
            this.relay2 = new Relay(relay2Port);
        }
        if (jag1Port > -1) {
            this.jag1 = new Jaguar(jag1Port);
        }
        if (jag2Port > -1) {
            this.jag2 = new Jaguar(jag2Port);
        }
        if (servo1Port > -1) {
            this.servo1 = new Servo(servo1Port);
        }
        if (servo2Port > -1) {
            this.servo2 = new Servo(servo2Port);
        }
    }

    /**
     * Turn the motor attached to relay 1 on
     */
    public void relay1On() {
        if (relay1 != null) {
            relay1.set(Value.kOn);
        }
    }

    /**
     * Turn the motor attached to relay 1 off
     */
    public void relay1Off() {
        if (relay1 != null) {
            relay1.set(Value.kOff);
        }
    }

    /**
     * Get the value of the state of the motor attached to relay 1
     *
     * @return
     */
    public Value getRelay1State() {
        if (relay1 != null) {
            return relay1.get();
        } else {
            return null;
        }
    }

    /**
     * Run the motor attached to relay 1 for a specified amount of time.
     *
     * @param seconds the number of seconds to run the motor.
     */
    public void runRelay1(double seconds) {
        if (relay1 != null) {
            relay1On();
            Timer.delay(seconds);
            relay1Off();
        }
    }

    /**
     * Turn the motor attached to relay 2 on
     */
    public void relay2On() {
        if (relay2 != null) {
            relay2.set(Value.kOn);
        }
    }

    /**
     * Turn the motor attached to relay 2 off
     */
    public void relay2Off() {
        if (relay2 != null) {
            relay2.set(Value.kOff);
        }
    }

    /**
     * Get the value of the state of the motor attached to relay 1
     *
     * @return
     */
    public Value getRelay2State() {
        if (relay2 != null) {
            return relay2.get();
        } else {
            return null;
        }
    }

    /**
     * Run the motor attached to relay 2 for a specified amount of time.
     *
     * @param seconds the number of seconds to run the motor.
     */
    public void runRelay2(double seconds) {
        if (relay2 != null) {
            relay2On();
            Timer.delay(seconds);
            relay2Off();
        }
    }

    /**
     * Run the motor attached to jaguar 1 at the specified speed
     *
     * @param speed the speed to run the motor at. Between -1 and 1.
     */
    public void setJag1Speed(double speed) {
        if (jag1 != null) {
            if (speed < -1.0) {
                speed = -1;
            }
            if (speed > 1.0) {
                speed = 1;
            }
            jag1.set(speed);
        }
    }

    /**
     * Stops the motor attached to jaguar 1. (Sets its speed to 0)
     */
    public void stopJag1() {
        if (jag1 != null) {
            setJag1Speed(0.0);
        }
    }

    /**
     * Runs the motor attached to jaguar 1 for a specified amount of time at a
     * certain speed.
     *
     * @param speed the speed at which to run the motor
     * @param seconds how long to run the motor
     */
    public void runJag1(double speed, double seconds) {
        if (jag1 != null) {
            setJag1Speed(speed);
            Timer.delay(seconds);
            stopJag1();
        }
    }

    /**
     * Get the speed of the motor attached to jaguar 1
     *
     * @return
     */
    public double getJag1Speed() {
        if (jag1 != null) {
            return jag1.get();
        } else {
            return 0.0;
        }
    }

    /**
     * Run the motor attached to jaguar 2 at the specified speed
     *
     * @param speed the speed to run the motor at. Between -1 and 1.
     */
    public void setJag2Speed(double speed) {
        if (jag2 != null) {
            if (speed < -1.0) {
                speed = -1;
            }
            if (speed > 1.0) {
                speed = 1;
            }
            jag2.set(speed);
        }
    }

    /**
     * Stops the motor attached to jaguar 2. (Sets its speed to 0)
     */
    public void stopJag2() {
        if (jag2 != null) {
            setJag2Speed(0.0);
        }
    }

    /**
     * Runs the motor attached to jaguar 2 for a specified amount of time at a
     * certain speed.
     *
     * @param speed the speed at which to run the motor
     * @param seconds how long to run the motor
     */
    public void runJag2(double speed, double seconds) {
        if (jag2 != null) {
            setJag2Speed(speed);
            Timer.delay(seconds);
            stopJag2();
        }
    }

    /**
     * Get the speed of the motor attached to jaguar 1
     *
     * @return
     */
    public double getJag2Speed() {
        if (jag2 != null) {
            return jag2.get();
        } else {
            return 0.0;
        }
    }

    /**
     * Gets the angle that servo 1 is currently at
     *
     * @return
     */
    public double getServo1Angle() {
        if (servo1 != null) {
            return servo1.getAngle();
        } else {
            return 0.0;
        }
    }

    /**
     * Sets the angle of servo 1
     *
     * @param angle
     */
    public void setServo1Angle(double angle) {
        if (servo1 != null) {
            servo1.set(angle);
        }
    }

    /**
     * Gets the angle that servo 2 is currently at
     *
     * @return
     */
    public double getServo2Angle() {
        if (servo2 != null) {
            return servo2.getAngle();
        } else {
            return 0.0;
        }
    }

    /**
     * Sets the angle of servo 2
     *
     * @param angle
     */
    public void setServo2Angle(double angle) {
        if (servo2 != null) {
            servo2.set(angle);
        }
    }
}