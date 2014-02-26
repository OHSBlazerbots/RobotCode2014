package edu.wpi.first.wpilibj.templates.commands;

/**
 * Turn to a specified angle.
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
