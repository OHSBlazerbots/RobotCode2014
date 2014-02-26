/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author sgoldman
 */
public class CenterOnBall extends CommandBase {

    public CenterOnBall() {
        //We need to get the ball's position
        requires(network);
        //We need to move
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Tell the chassis we are following the ball
        chassis.enableBallFollowing();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double x = network.getNetworkVariable("COG_X");
        // If ball is on the right side of the screen, turn right
        double xv = 0.0;
        if (x > 340) {
            xv = -.4;
        } // If it is on the left side of the screen, turn left
        else if (x < 300) {
            //Left side is faster because these motors appear to be weaker
            xv = .4;
        } // Otherwise, it is pretty much center, so don't more
        else {
            xv = 0.0;
        }

        double a = network.getNetworkVariable("COG_AREA");
        if (network.getNetworkVariable("RGB_FILTER_GREEN_COUNT") < 60000 && a / (480 * 640) < .9) {
                chassis.drive(xv, -.5);
        } else {
            chassis.drive(0, 0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //Finish when the driver tells us to
        return (chassis.getState() != 1);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
