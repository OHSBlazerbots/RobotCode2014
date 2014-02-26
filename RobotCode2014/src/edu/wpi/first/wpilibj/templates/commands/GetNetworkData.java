/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author sgoldman
 */
public class GetNetworkData extends CommandBase {
    
    public GetNetworkData() {
        //we need a network to get network data
        requires(network);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    // Get COG x and y
    protected void execute() {
        //Get data
        double var1 = network.getNetworkVariable("COG_X");
        double var2 = network.getNetworkVariable("COG_Y");
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}