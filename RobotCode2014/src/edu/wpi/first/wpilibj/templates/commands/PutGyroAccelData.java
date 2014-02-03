/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author blazerbots
 */
public class PutGyroAccelData extends CommandBase{

    public PutGyroAccelData()
    {
        requires(chassis);
    }
    
    protected void initialize() {

    }

    protected void execute() {
        SmartDashboard.putNumber("Angle: ", chassis.getGyroAngle());
        double[] a = chassis.getAcceleration();
        SmartDashboard.putNumber("A-X: ", a[0]);
        SmartDashboard.putNumber("A-Y: ", a[1]);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
