package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.templates.commands.AutoTarget;
import edu.wpi.first.wpilibj.templates.commands.CenterOnBall;
import edu.wpi.first.wpilibj.templates.commands.DecrementDriveRatio;
import edu.wpi.first.wpilibj.templates.commands.DriveForward;
import edu.wpi.first.wpilibj.templates.commands.DriveInSquare;
import edu.wpi.first.wpilibj.templates.commands.IncrementDriveRatio;
import edu.wpi.first.wpilibj.templates.commands.SetSetpointCurrent;
import edu.wpi.first.wpilibj.templates.commands.ToggleBallFollowing;
import edu.wpi.first.wpilibj.templates.commands.ToggleAutoTurn;
import edu.wpi.first.wpilibj.templates.commands.TogglePickerUpDown;
import edu.wpi.first.wpilibj.templates.commands.ToggleStraight;
import edu.wpi.first.wpilibj.templates.commands.ToggleTurn;
import edu.wpi.first.wpilibj.templates.commands.Turn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //The robot controllers
    Joystick joystick = new Joystick(RobotMap.JOYSTICK_PORT),
            joystick2 = new Joystick(RobotMap.JOYSTICK2_PORT);
    //The buttons on the controllers
    private final JoystickButton speedUp,
            slowDown,
            autoTarget,
            togglePickerUpDown,
            togglePickerWheels,
            shootCycle,
            invertDrivingDirection;

    public OI() {
        //Driver
        //Create buttons
        speedUp = new JoystickButton(joystick, 3);
        slowDown = new JoystickButton(joystick, 1);
        autoTarget = new JoystickButton(joystick, 8);
        invertDrivingDirection = new JoystickButton (joystick, 2);
        
        //What do the buttons do?
        speedUp.whenPressed(new DecrementDriveRatio());
        slowDown.whenPressed(new IncrementDriveRatio());
        autoTarget.whenPressed(new AutoTarget());
        invertDrivingDirection.whenPressed(new InvertDrivingDirection());
        
        //Co Driver
        //Create buttons
        togglePickerUpDown = new JoystickButton(joystick2, 3);
        togglePickerWheels = new JoystickButton(joystick2, 1);
        shootCycle = new JoystickButton(joystick2, 4);
        
        //What do the buttons do?
        togglePickerUpDown.whenPressed(new TogglePickerUpDown());
        togglePickerWheels.whenPressed(new PrintCommand("Toggle Wheels"));
        shootCycle.whenPressed(new PrintCommand("Shoot Cycle"));
    }

    //Returns the joystick that controls driving
    public Joystick getJoystick() {
        return joystick;
    }
}
