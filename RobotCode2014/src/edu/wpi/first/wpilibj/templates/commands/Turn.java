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

    //How much to turn
    private double degrees;
    private GoToSetPoint gTSP;
    
    public Turn(double d) {
        requires(chassis);
        //Set turning
        this.degrees = d;
        gTSP =  new GoToSetPoint();
    }

    protected void initialize() {
        //Turn
        chassis.turn(this.degrees);
        //Go
        gTSP.initialize();
    }

    protected void execute() {
        System.out.println("Turn.execute()");
        gTSP.execute();
    }

    protected boolean isFinished() {
        //We are done if gTSP is
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
