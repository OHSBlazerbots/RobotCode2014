/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 *
 * @author blazerbots
 */
public class GoToSetPoint extends CommandBase {

    public GoToSetPoint() {
        System.out.println("GoToSetPoint Created");
        requires(chassis);
    }

    protected void initialize() {

    }

    protected void execute() {
        System.out.println("Current Angle: " + chassis.getGyroAngle());
        SmartDashboard.putNumber("Current Angle: ", chassis.getGyroAngle());
        SmartDashboard.putNumber("Setpoint: ", chassis.getSetpoint());
        double error = SmartDashboard.getNumber("Error: ", 5);
        System.out.println(error);
        double turn = chassis.getGyroAngle() - chassis.getSetPoint();
        if (turn < 0) {
            turn += 360;
        }
        double bound1 = chassis.getSetPoint() - error;
        if (bound1 < 0) {
            bound1 += 360;
        }
        double bound2 = chassis.getSetPoint() + error;
        if (bound2 >= 360) {
            bound2 -= 360;
        }
        double tv = 0.0;
        if(bound1 < bound2)
        {
            if(chassis.getGyroAngle() < bound2 && chassis.getGyroAngle() > bound1)
            {
                tv = 0;
                chassis.stopGoingToSetPoint();
            }
            else{
                if(turn <= 180)
                {
                    tv = .5;
                }
                else{
                    tv = -.5;
                }
            }
        }
        else
        {
            if(chassis.getGyroAngle() < bound2 || chassis.getGyroAngle() > bound1)
            {
                tv = 0;
                chassis.stopGoingToSetPoint();
            }
            else{
                if(turn <= 180)
                {
                    tv = .5;
                }
                else{
                    tv = -.5;
                }
            }
        }
        Chassis.drive.arcadeDrive(tv, 0);
    }

    protected boolean isFinished() {
        if(chassis.getState() != 2)
        System.out.println("GTSP Finished");
        return (chassis.getState() != 2);
    }

    protected void end() {
    }

    protected void interrupted() {

    }

}
