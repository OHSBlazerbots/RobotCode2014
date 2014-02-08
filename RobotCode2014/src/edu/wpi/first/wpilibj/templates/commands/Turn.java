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
        gTSP =  new GoToSetPoint();
    }

    protected void initialize() {
        System.out.println("Turn(Start)");
        chassis.turn(this.degrees);
        gTSP.initialize();
        System.out.println("Turn(End)");
    }

    protected void execute() {
        System.out.println("Turn.execute()");
        gTSP.execute();
    }

    protected boolean isFinished() {
        System.out.println("Turn.isFinished");
        if (gTSP.isFinished()) {
            System.out.println("Turn finished");
        }
        return gTSP.isFinished();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
