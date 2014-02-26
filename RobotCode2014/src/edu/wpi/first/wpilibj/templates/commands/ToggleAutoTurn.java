/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 * Turn on/off the automated turning function.
 * @author blazerbots
 */
public class ToggleAutoTurn extends CommandBase {

    private GoToSetPoint goToSetPoint;

    public ToggleAutoTurn() {
        //Need chassis so we can turn
        requires(chassis);
    }

    protected void initialize() {
        //If already turning, stop
        if (chassis.getState() == 2) {
            chassis.stopGoingToSetPoint();
        } else {
            //Else start
            chassis.goToSetPoint();
            goToSetPoint = new GoToSetPoint();
            goToSetPoint.start();
        }
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return !goToSetPoint.isRunning();
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
