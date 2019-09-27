// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc4093.OffSeason2019;

import org.usfirst.frc4093.OffSeason2019.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import org.usfirst.frc4093.OffSeason2019.DPad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton toggledir1;
    public JoystickButton toggledir2;
    public JoystickButton interrupt;
    public JoystickButton downb;
    public Joystick leftJoystick;
    public JoystickButton feed;
    public JoystickButton eject;
    public JoystickButton slideForward;
    public JoystickButton slideBack;
    public JoystickButton hatchgrab;
    public JoystickButton hatcheject;
    public JoystickButton feedCargo11;
    public JoystickButton lowLevel9;
    public JoystickButton middlecargo7;
    public JoystickButton hatchBottom12;
    public JoystickButton hatchMid10;
    public JoystickButton hatchtop8;
    public Joystick rightJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // up
    public Button ArmDownPOV;
    public Button ArmDownPOV2;
    public Button ArmDownPOV3;
    // down
    public Button ArmUpPOV;
    public Button ArmUpPOV2;
    public Button ArmUpPOV3;

    //Mecanum
    public Button DriveRightPOV;
    public Button DriveLeftPOV;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        rightJoystick = new Joystick(1);
        
        hatchtop8 = new JoystickButton(rightJoystick, 8);
        hatchtop8.whenPressed(new HatchTop());
        hatchMid10 = new JoystickButton(rightJoystick, 10);
        hatchMid10.whenPressed(new HatchMiddle());
        hatchBottom12 = new JoystickButton(rightJoystick, 12);
        hatchBottom12.whenPressed(new HatchBottom());
        middlecargo7 = new JoystickButton(rightJoystick, 7);
        middlecargo7.whenPressed(new liftAndArmToTop());
        lowLevel9 = new JoystickButton(rightJoystick, 9);
        lowLevel9.whenPressed(new lowLevelCargo());
        feedCargo11 = new JoystickButton(rightJoystick, 11);
        feedCargo11.whenPressed(new Feedposition());
        hatcheject = new JoystickButton(rightJoystick, 5);
        hatcheject.whileHeld(new releaseHatch());
        hatchgrab = new JoystickButton(rightJoystick, 3);
        hatchgrab.whileHeld(new grabHatch());
        slideBack = new JoystickButton(rightJoystick, 4);
        slideBack.whileHeld(new SlideBackward());
        slideForward = new JoystickButton(rightJoystick, 6);
        slideForward.whileHeld(new SlideForward());
        eject = new JoystickButton(rightJoystick, 1);
        eject.whileHeld(new ejectBall());
        feed = new JoystickButton(rightJoystick, 2);
        feed.whileHeld(new feedBall());
        leftJoystick = new Joystick(0);
        
        downb = new JoystickButton(leftJoystick, 2);
        downb.whileHeld(new dumbDown());
        interrupt = new JoystickButton(leftJoystick, 2);
        interrupt.whileHeld(new getOutOfAuto());
        toggledir2 = new JoystickButton(leftJoystick, 6);
        toggledir2.whenPressed(new ToggleDir());
        toggledir1 = new JoystickButton(leftJoystick, 5);
        toggledir1.whenPressed(new ToggleDir());


        // SmartDashboard Buttons
        SmartDashboard.putData("ejectBall", new ejectBall());
        SmartDashboard.putData("releaseHatch", new releaseHatch());
        SmartDashboard.putData("dumbDown", new dumbDown());
        SmartDashboard.putData("BounceArmTimed", new BounceArmTimed());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        //Shuffle Board/SmartDashboard
        ArmUpPOV = new DPad(rightJoystick, DPad.Direction.DOWN);
        ArmUpPOV2 = new DPad(rightJoystick, DPad.Direction.DOWN_LEFT);
        ArmUpPOV3 = new DPad(rightJoystick, DPad.Direction.DOWN_RIGHT);
        // down
        ArmDownPOV = new DPad(rightJoystick, DPad.Direction.UP);
        ArmDownPOV2 = new DPad(rightJoystick, DPad.Direction.UP_LEFT);
        ArmDownPOV3 = new DPad(rightJoystick, DPad.Direction.UP_RIGHT);

        DriveRightPOV = new DPad(leftJoystick,DPad.Direction.RIGHT);
        DriveLeftPOV = new DPad(leftJoystick,DPad.Direction.LEFT);
        // Dpad arm stuff and axis drive stuff
        ArmUpPOV.whileHeld(new armUp());
        ArmUpPOV2.whileHeld(new armUp());
        ArmUpPOV3.whileHeld(new armUp());

        ArmDownPOV.whileHeld(new armDown());
        ArmDownPOV2.whileHeld(new armDown());
        ArmDownPOV3.whileHeld(new armDown());

        DriveRightPOV.whileHeld(new driveRight());
        DriveLeftPOV.whileHeld(new driveLeft());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getleftJoystick() {
        return leftJoystick;
    }

    public Joystick getrightJoystick() {
        return rightJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
