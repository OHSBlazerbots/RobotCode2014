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
public class DecrementDriveRatio extends CommandBase{
    public DecrementDriveRatio(){
        requires(chassis);
    }

    protected void initialize() {
        chassis.decrementRatio();
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
