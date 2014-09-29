package edu.wpi.first.wpilibj.templates.commands;

/**
 * Toggle going only straight.
 * @author blazerbots
 */
public class ToggleStraight extends CommandBase{
    
    public ToggleStraight()
    {
        requires(chassis);
    }

    protected void initialize() {
        //Toggle driving straight
        chassis.toggleDriveStraight();
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
