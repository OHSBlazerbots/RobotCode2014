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
        System.out.println("DriveForward(" + seconds + ") created");
    }

    protected void initialize() {
        System.out.println("DriveForward.initialize(" + this.time + ",start)");
        chassis.drive(0,-0.5);
        new Timer().delay(this.time);
        chassis.drive(0,0);
        System.out.println("DriveForward.initialize(" + this.time + ",end)");
    }

    protected void execute() {
        System.out.println("DriveForward.execute(" + this.time + ")");
    }

    protected boolean isFinished() {
        System.out.println("DriveForward.isFinished(" + this.time + ")");
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
