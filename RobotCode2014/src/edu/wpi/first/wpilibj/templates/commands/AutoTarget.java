/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitUntilCommand;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 *
 * @author jmuller4
 */
public class AutoTarget extends CommandBase {

    private boolean done;

    public AutoTarget() {
        requires(chassis);
    }

    protected void initialize() {
        done = false;
        //Turn to 0
        chassis.setSetPoint(0);
        ToggleAutoTurn toggleAutoTurn = new ToggleAutoTurn();
        toggleAutoTurn.start();
    }

    protected void execute() {
        double distance = chassis.getSonarDistance();
        if (distance > 125) {
            Chassis.drive.arcadeDrive(0, .4);
        } else if (distance < 115) {
            Chassis.drive.arcadeDrive(0, -.4);
        } else {
            done = true;
        }
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
        Chassis.drive.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    }
}
