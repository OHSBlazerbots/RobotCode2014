/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author jmuller4
 */
public class Picker extends Subsystem {
    
    // Declare properties of the Picker
    SpeedController controller;
    DoubleSolenoid solenoid, solenoid2;
    //DoubleSolenoid solenoid2;
    Compressor compressing;
    
    // Constructor
    public Picker(int cChannel, int fwdSolenoidChannel, int revSolenoidChannel, int fwdSolenoidChannel2, int revSolenoidChannel2, int pressureSwitchControl, int compressorRelayChannel ) {
        controller = new Jaguar(cChannel);
        solenoid = new DoubleSolenoid(fwdSolenoidChannel, revSolenoidChannel);
        solenoid2 = new DoubleSolenoid(fwdSolenoidChannel2, revSolenoidChannel2);
        //solenoid2 = new DoubleSolenoid(fwdSolenoidChannelTwo, revSolenoidChannelTwo);
        compressing = new Compressor(pressureSwitchControl, compressorRelayChannel);
        compressing.start();
    }
    
    // Getter Methods
    public boolean getTurningState(){
        return (controller.get() > 0);
    }
    
    public boolean getExtendedState(){
        return (solenoid.get() == Value.kForward);
    }
    
    // Special Methods
    //Move the picker up or down
    public void pickerDown(){
        solenoid.set(DoubleSolenoid.Value.kForward);
        solenoid2.set(DoubleSolenoid.Value.kForward);
    }
    public void pickerUp(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
        solenoid2.set(DoubleSolenoid.Value.kReverse);
    }
    
    // Turn the wheels on or off
    public void turnOn(){
        controller.set(1.0);
    }
    public void turnOff(){
        controller.set(0.0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}