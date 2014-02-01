/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author blazerbots
 */
public class Turn extends CommandBase {

    private double degrees;
    private GoToSetPoint gTSP;
    public Turn(double d) {
        requires(chassis);
        this.degrees = d;
        
    }

    protected void initialize() {
        chassis.turn(this.degrees);
        gTSP =  new GoToSetPoint();
        gTSP.start();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        System.out.println("Turn finished");
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
