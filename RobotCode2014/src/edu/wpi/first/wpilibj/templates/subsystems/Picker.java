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

/**
 *
 * @author jmuller4
 */
public class Picker extends Subsystem {
    
    // Declare properties of the Picker
    Relay relay;
    DoubleSolenoid solenoid;
    //DoubleSolenoid solenoid2;
    Compressor compressing;
    
    // Constructor
    public Picker(int relayChannel, int fwdSolenoidChannel, int revSolenoidChannel, int pressureSwitchControl, int compressorRelayChannel ) {
        relay = new Relay(relayChannel);
        solenoid = new DoubleSolenoid(fwdSolenoidChannel, revSolenoidChannel);
        //solenoid2 = new DoubleSolenoid(fwdSolenoidChannelTwo, revSolenoidChannelTwo);
        compressing = new Compressor(pressureSwitchControl, compressorRelayChannel);
        compressing.start();
    }
    
    // Getter Methods
    public boolean getTurningState(){
        return (relay.get() == Relay.Value.kForward);
    }
    
    public boolean getExtendedState(){
        return (solenoid.get() == Value.kForward);
    }
    
    // Special Methods
    //Move the picker up or down
    public void pickerDown(){
        solenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void pickerUp(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    // Turn the wheels on or off
    public void turnOn(){
        relay.set(Relay.Value.kForward);
    }
    public void turnOff(){
        relay.set(Relay.Value.kOff);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}