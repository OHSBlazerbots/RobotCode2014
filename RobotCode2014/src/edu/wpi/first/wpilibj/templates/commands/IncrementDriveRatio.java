/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Increase the drive ratio.
 * This actually slows the robot down.
 * @author blazerbots
 */
public class IncrementDriveRatio extends CommandBase {

    public IncrementDriveRatio() {
        // we need to change chassis values
        requires(chassis);
    }

    protected void initialize() {
        //Increment ratio
        chassis.incrementRatio();
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
