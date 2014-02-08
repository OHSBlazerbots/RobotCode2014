package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.CenterOnBall;
import edu.wpi.first.wpilibj.templates.commands.DecrementDriveRatio;
import edu.wpi.first.wpilibj.templates.commands.DriveForward;
import edu.wpi.first.wpilibj.templates.commands.DriveInSquare;
import edu.wpi.first.wpilibj.templates.commands.IncrementDriveRatio;
import edu.wpi.first.wpilibj.templates.commands.SetSetpointCurrent;
import edu.wpi.first.wpilibj.templates.commands.ToggleBallFollowing;
import edu.wpi.first.wpilibj.templates.commands.ToggleAutoTurn;
import edu.wpi.first.wpilibj.templates.commands.ToggleStraight;
import edu.wpi.first.wpilibj.templates.commands.ToggleTurn;
import edu.wpi.first.wpilibj.templates.commands.Turn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private CenterOnBall cob = new CenterOnBall();
    private static final int JOYSTICK_PORT = 1;
    private static final int JOYSTICK2_PORT = 2;
    //// CREATING BUTTONS
    // One type of stopBallFollowing is a joystick stopBallFollowing which is any stopBallFollowing on a joystick.
    // You create one by telling it which joystick it's on and which stopBallFollowing
    // number it is.
    Joystick joystick = new Joystick(JOYSTICK_PORT);
    Joystick joystick2 = new Joystick(JOYSTICK2_PORT);
    // Button stopBallFollowing = new JoystickButton(stick, buttonNumber);
    Button stopBallFollowing;
    Button followBall;
    Button iRatio;
    Button dRatio;
    Button straightToggle;
    Button turnToggle;
    Button setSetpoint;
    Button toggleSetpoint;
    Button driveForward;
    // Another type of stopBallFollowing you can create is a DigitalIOButton, which is
    // a stopBallFollowing or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button stopBallFollowing = new DigitalIOButton(1);
    private final JoystickButton turn;
    private final JoystickButton square;

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a stopBallFollowing, it's trivial to bind it to a stopBallFollowing in one of
    // three ways:
    // Start the command when the stopBallFollowing is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // stopBallFollowing.whenPressed(new ExampleCommand());
    // Run the command while the stopBallFollowing is being held down and interrupt it once
    // the stopBallFollowing is released.
    // stopBallFollowing.whileHeld(new ExampleCommand());
    // Start the command when the stopBallFollowing is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // stopBallFollowing.whenReleased(new ExampleCommand());
    public OI() {
        stopBallFollowing = new JoystickButton(joystick, 4); //y
        stopBallFollowing.whenPressed(new ToggleBallFollowing()); 
        followBall = new JoystickButton(joystick, 1); //a
        followBall.whenPressed(new CenterOnBall());
        iRatio = new JoystickButton(joystick, 6); //rb
        iRatio.whenPressed(new IncrementDriveRatio());
        dRatio = new JoystickButton(joystick, 5); //lb
        dRatio.whenPressed(new DecrementDriveRatio());
        straightToggle = new JoystickButton(joystick, 2); //b
        straightToggle.whenPressed(new ToggleStraight());
        turnToggle = new JoystickButton(joystick, 3); //x
        turnToggle.whenPressed(new ToggleTurn());
        setSetpoint = new JoystickButton(joystick, 8); //start
        setSetpoint.whenPressed(new SetSetpointCurrent());
        toggleSetpoint = new JoystickButton(joystick, 7); //back
        toggleSetpoint.whenPressed(new ToggleAutoTurn());
        driveForward = new JoystickButton(joystick2, 1); //a
        driveForward.whenPressed(new DriveForward(2));
        turn = new JoystickButton(joystick2, 2); //b
        turn.whenPressed(new Turn(85));
        square = new JoystickButton(joystick2, 3); //x
        square.whenPressed(new DriveInSquare());
    }

    //Returns the joystick that controls driving
    public Joystick getJoystick() {
        return joystick;
    }
}
