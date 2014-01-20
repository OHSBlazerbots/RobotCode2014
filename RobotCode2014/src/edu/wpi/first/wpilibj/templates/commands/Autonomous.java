/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author jmuller4
 */
public class Autonomous extends CommandBase {

    protected void initialize() {
        requires(chassis);
    }

    public void execute() {
        System.out.println("Starting");
        chassis.drive(0, -.5);
        System.out.println("Started");
        new Timer().delay(1);

        System.out.println("Stopping");
        chassis.drive(0, 0);
        System.out.println("Stopped");
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
