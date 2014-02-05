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
    DoubleSolenoid solenoid1;
    DoubleSolenoid solenoid2;
    Compressor compressing;
    
    // Constructor
    public Picker(int relayChannel, int fwdSolenoidChannelOne, int revSolenoidChannelOne, int fwdSolenoidChannelTwo, int revSolenoidChannelTwo, int pressureSwitchControl, int compressorRelayChannel ) {
        relay = new Relay(relayChannel);
        solenoid1 = new DoubleSolenoid(fwdSolenoidChannelOne, revSolenoidChannelOne);
        solenoid2 = new DoubleSolenoid(fwdSolenoidChannelTwo, revSolenoidChannelTwo);
        compressing = new Compressor(pressureSwitchControl, compressorRelayChannel);
        compressing.start();
    }
    
    // Getter Methods
    public Relay.Value getTurningState(){
        return relay.get();
    }
    
    public Value getExtendedLeftState(){
        return solenoid1.get();
    }
    
    public Value getExtendedRightState(){
        return solenoid2.get();
    }
    
    // Special Methods
    //Move the picker up or down
    public void pickerDown(){
        solenoid1.set(DoubleSolenoid.Value.kForward);
        solenoid2.set(DoubleSolenoid.Value.kForward);
    }
    public void pickerUp(){
        solenoid1.set(DoubleSolenoid.Value.kReverse);
        solenoid2.set(DoubleSolenoid.Value.kReverse);
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