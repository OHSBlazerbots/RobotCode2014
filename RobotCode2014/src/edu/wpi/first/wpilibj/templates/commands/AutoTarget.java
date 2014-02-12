/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
//        ToggleAutoTurn toggleAutoTurn = new ToggleAutoTurn();
//        toggleAutoTurn.start();
    }

    protected void execute() {
        double distance = chassis.getSonarDistance();
        SmartDashboard.putNumber("Sonar", distance);
        if (distance > 102) {
            Chassis.drive.arcadeDrive(0, -.5);
        } else if (distance < 98) {
            Chassis.drive.arcadeDrive(0, .5);
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
