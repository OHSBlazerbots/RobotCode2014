/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import edu.wpi.first.wpilibj.templates.commands.GetNetworkData;

/**
 *
 * @author sgoldman
 */
public class Network extends Subsystem{

    // Holds a reference to the SmartDashboard, where we get info from
    private NetworkTable server;
    
    /**
     * Creates the Network subsystem
     * Initializes private reference to SmartDashboard
     */
    public Network() {
        server = NetworkTable.getTable("SmartDashboard");
    }
    
    /**
     * Default method for 
     */
    
    protected void initDefaultCommand() {
        // Starts the robot with the following non-terminating command
        setDefaultCommand(new GetNetworkData());
    }
    
    public double getCOGArea() {
        try {
            return server.getNumber("COG_AREA");
        }
        catch (TableKeyNotDefinedException exp){
            return 0;
        }
    }
}
