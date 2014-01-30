/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author blazerbots
 */
public class IncrementDriveRatio extends CommandBase {

    public IncrementDriveRatio() {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
    }

    protected void initialize() {
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
