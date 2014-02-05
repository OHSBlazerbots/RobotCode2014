/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author jmuller4
 */
public class Shooter extends Subsystem {
    
    // Declare properties of the Picker
    // The Relay we are using
    Relay relay;
    
    // Tells us whether to use the shooter or not
    private boolean shooterOn;
    
    public Shooter(int relayChannel) {
        relay = new Relay(relayChannel);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
