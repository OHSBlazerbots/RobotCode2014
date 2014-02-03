/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 *
 * @author blazerbots
 */
public class DriveForward extends CommandBase{
    private double time;
    public DriveForward(double seconds) {
        requires(chassis);
        this.time = seconds;
    }

    protected void initialize() {
        chassis.drive(0,-0.5);
        new Timer().delay(this.time);
        chassis.drive(0,0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
