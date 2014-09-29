/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author sgoldman
 */
public class ToggleSubsystem1Relay1 extends CommandBase {

    public ToggleSubsystem1Relay1() {
        requires(subsystem1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (subsystem1.getRelay1State().equals(Value.kOn)) {
            subsystem1.relay1Off();
        } else {
            subsystem1.relay1On();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}