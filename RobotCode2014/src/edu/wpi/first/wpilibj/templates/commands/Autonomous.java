/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import java.util.Timer;

/**
 *
 * @author jmuller4
 */
public class Autonomous extends CommandBase{

    protected void initialize() {
        requires(chassis);
    }

    protected void execute() {
        chassis.drive(0, .5);
        try {
            new Timer().wait(1000);
        } catch (InterruptedException ex) {
        }
        chassis.drive(0, 0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
