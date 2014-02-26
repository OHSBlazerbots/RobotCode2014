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
        //We need to move
        requires(chassis);
    }

    protected void initialize() {

    }

    protected void execute() {
        //Place data
        SmartDashboard.putNumber("Current Angle: ", chassis.getGyroAngle());
        SmartDashboard.putNumber("Setpoint: ", chassis.getSetPoint());
        
        //Get the rate of error, default of 5
        double error = SmartDashboard.getNumber("Error: ", 5);
        
        //How much we need to turn
        double turn = chassis.getGyroAngle() - chassis.getSetPoint();
        
        //Get it into the range of 0-360
        if (turn < 0) {
            turn += 360;
        }
        //One boundry
        double bound1 = chassis.getSetPoint() - error;
        //Get it into the range of 0-360
        if (bound1 < 0) {
            bound1 += 360;
        }
        //Sencond boundry
        double bound2 = chassis.getSetPoint() + error;
        //Get it into the range of 0-360
        if (bound2 >= 360) {
            bound2 -= 360;
        }
        //Turn value
        double tv = 0.0;
        
        //If bound2 is the upper bound
        if(bound1 < bound2)
        {
            //If we are between both bounds, stop
            if(chassis.getGyroAngle() < bound2 && chassis.getGyroAngle() > bound1)
            {
                //No turn
                tv = 0;
                //Notify chassis
                chassis.stopGoingToSetPoint();
            }
            else{
                //Turn the appropriate values
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
            //If we are between both bounds, stop
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
        //Drive at appropriate values
        Chassis.drive.arcadeDrive(tv, 0);
    }

    protected boolean isFinished() {
        //Are we done
        return (chassis.getState() != 2);
    }

    protected void end() {
    }

    protected void interrupted() {

    }

}
