/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Get and put the gyro and accel data.
 * @author blazerbots
 */
public class PutGyroAccelData extends CommandBase{

    public PutGyroAccelData()
    {
        //To get  data
        requires(chassis);
    }
    
    protected void initialize() {

    }

    protected void execute() {
        //Put gyro data
        SmartDashboard.putNumber("Angle: ", chassis.getGyroAngle());
        //Get and put accel data
        double[] a = chassis.getAcceleration();
        SmartDashboard.putNumber("A-X: ", a[0]);
        SmartDashboard.putNumber("A-Y: ", a[1]);
    }

    protected boolean isFinished() {
        //Don't stop
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
