// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4093.OffSeason2019.subsystems;


import org.usfirst.frc4093.OffSeason2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class ballGrabber extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX top;
    private DigitalInput limitSwitch1;
    private WPI_TalonSRX bottom;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public ballGrabber() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        top = new WPI_TalonSRX(9);
        
        
        
        limitSwitch1 = new DigitalInput(0);
        addChild("Limit Switch 1",limitSwitch1);
        
        
        bottom = new WPI_TalonSRX(10);
        
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }


    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void feed() {
        //feeds ball
        if (limitSwitch1.get()){ //if limitswitch hit is true(limit switch normally closed)
            bottom.set(1); //drive wheel1 forward
            top.set(-1); //drive wheel2 backward
        }
    }
    public void eject() {
        bottom.set(-1); //drive wheel1 backward
        top.set(1); //drive wheel2 forward
    }
    public void hold(){
        bottom.set(-.1); //drive wheel1 backward
        top.set(.1); //drive wheel2 forward
    }
    public void stop() {
        //System.out.println("Current: " + top.getOutputCurrent() );
        bottom.set(0);
        top.set(0);
    }
    public boolean limitHit(){
        return !limitSwitch1.get();
    }
    public boolean highAmp(){
        // if (10  > top.getOutputCurrent()){
        //     return true;
        // }
        return false;
    }
    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

