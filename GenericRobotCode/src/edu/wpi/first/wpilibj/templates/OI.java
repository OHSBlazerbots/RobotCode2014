package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.Latch;
import edu.wpi.first.wpilibj.templates.commands.Pullback;
import edu.wpi.first.wpilibj.templates.commands.ReleaseShooter;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.StopPullAndLatch;
import edu.wpi.first.wpilibj.templates.commands.StopRelease;
import edu.wpi.first.wpilibj.templates.commands.TakePic;
import edu.wpi.first.wpilibj.templates.commands.TogglePickerRun;
import edu.wpi.first.wpilibj.templates.commands.TogglePickerUpDown;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //The robot controllers
    Joystick joystick = new Joystick(RobotMap.JOYSTICK_PORT), // Driver
            joystick2 = new Joystick(RobotMap.JOYSTICK2_PORT); //Co-Driver
    //The buttons on the controllers
    private final JoystickButton togglePickerUpDown,
            togglePickerWheels,
            shootCycle,
            releaseShooter,
            shoot,
            latch;
    //setupShooter;

    /**
     *
     */
    public OI() {

        //Driver
        //Create buttons


        //What do the buttons do?


        //Co Driver
        //Create buttons
        togglePickerUpDown = new JoystickButton(joystick2, 3);
        togglePickerWheels = new JoystickButton(joystick2, 1);
        shootCycle = new JoystickButton(joystick2, 4);
        releaseShooter = new JoystickButton(joystick2, 2);
        shoot = new JoystickButton(joystick2, 8);
        latch = new JoystickButton(joystick2, 10);
//        setupShooter = new JoystickButton(joystick2, 10);

        //What do the buttons do?
        togglePickerUpDown.whenPressed(new TogglePickerUpDown());
        togglePickerWheels.whenPressed(new TogglePickerRun());

        //shootCycle.whenPressed(new CycleShooter());

//Manual pullback/shoot
        shootCycle.whenPressed(new Pullback());
        shootCycle.whenReleased(new StopPullAndLatch());
        releaseShooter.whenPressed(new ReleaseShooter());
        releaseShooter.whenReleased(new StopRelease());
        shoot.whenPressed(new Shoot());
        latch.whenPressed(new Latch());
    }

    //Returns the joystick that controls driving
    public Joystick getJoystick() {
        return joystick; //Driver
    }
}
