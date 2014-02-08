package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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
    private final JoystickButton stopBallFollowing,
            followBall,
            iRatio,
            dRatio,
            straightToggle,
            turnToggle,
            setSetpoint,
            toggleSetpoint,
            driveForward,
            turn,
            square,
            pickerUpDown;

    public OI() {
        //Instantiate all of the buttons
        stopBallFollowing = new JoystickButton(joystick, 4);
        followBall = new JoystickButton(joystick, 1);
        iRatio = new JoystickButton(joystick, 6);
        dRatio = new JoystickButton(joystick, 5);
        straightToggle = new JoystickButton(joystick, 2);
        turnToggle = new JoystickButton(joystick, 3);
        setSetpoint = new JoystickButton(joystick, 8);
        toggleSetpoint = new JoystickButton(joystick, 7);
        driveForward = new JoystickButton(joystick2, 1);
        turn = new JoystickButton(joystick2, 2);
        square = new JoystickButton(joystick2, 3);
        pickerUpDown = new JoystickButton(joystick2, 4);

        //Declare what the buttons do
        stopBallFollowing.whenPressed(new ToggleBallFollowing());
        followBall.whenPressed(new CenterOnBall());
        iRatio.whenPressed(new IncrementDriveRatio());
        dRatio.whenPressed(new DecrementDriveRatio());
        straightToggle.whenPressed(new ToggleStraight());
        turnToggle.whenPressed(new ToggleTurn());
        setSetpoint.whenPressed(new SetSetpointCurrent());
        toggleSetpoint.whenPressed(new ToggleAutoTurn());
        driveForward.whenPressed(new DriveForward(2, .4));
        turn.whenPressed(new Turn(85));
        square.whenPressed(new DriveInSquare());
        pickerUpDown.whenPressed(new TogglePickerUpDown());
    }

    //Returns the joystick that controls driving
    public Joystick getJoystick() {
        return joystick;
    }
}
