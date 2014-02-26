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

    //Is this command done running
    private boolean done;

    public AutoTarget() {
        requires(chassis);
    }

    protected void initialize() {
        //Start off as not done
        done = false;
        //Turn to 0
        chassis.setSetPoint(0);
        //Possibly go to 0
//        ToggleAutoTurn toggleAutoTurn = new ToggleAutoTurn();
//        toggleAutoTurn.start();
    }

    protected void execute() {
        //Get the distance
        double distance = chassis.getSonarDistance();
        //Place the distance
        SmartDashboard.putNumber("Sonar", distance);
        //If we are farther than 102 inches out, drive forward
        if (distance > 102) {
            Chassis.drive.arcadeDrive(0, -.5);
        //Otherwise, if the distance is smaller than 98, drive forward
        } else if (distance < 98) {
            Chassis.drive.arcadeDrive(0, .5);
        //Otherwise, we are done
        } else {
            done = true;
        }
    }

    protected boolean isFinished() {
        //Are we done
        return done;
    }

    protected void end() {
        //Make sure that the robot stops
        Chassis.drive.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    }
}
