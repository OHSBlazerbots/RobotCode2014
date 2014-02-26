package edu.wpi.first.wpilibj.templates.commands;

/**
 * Toggle only turning.
 * @author blazerbots
 */
public class ToggleTurn extends CommandBase{

    public ToggleTurn()
    {
        requires(chassis);
    }
    protected void initialize() {
        //Toggle only turning
        chassis.toggleOnlyTurn();
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
