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
public class ToggleAutoTurn extends CommandBase {

    private GoToSetPoint goToSetPoint;

    public ToggleAutoTurn() {
        requires(chassis);
    }

    protected void initialize() {
        if (chassis.getState() == 2) {
            System.out.println("Stop turning");
            chassis.stopGoingToSetPoint();
        } else {
            System.out.println("Turning to setpoint");
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
