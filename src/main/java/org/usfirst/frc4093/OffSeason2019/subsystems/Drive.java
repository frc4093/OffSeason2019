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

import org.usfirst.frc4093.OffSeason2019.Dash;
import org.usfirst.frc4093.OffSeason2019.Robot;
import org.usfirst.frc4093.OffSeason2019.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX frontRight;
    private WPI_TalonSRX frontLeft;
    private WPI_TalonSRX backRight;
    private WPI_TalonSRX backLeft;
    private MecanumDrive mecanumDrive1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private double x = 0;
    private double y = 0;
    private double z = 0;
    private double rawX = 0;
    private double rawY = 0;
    private double rawZ = 0;
    private double speed = 0;
    public Boolean driveCargo = true;
    public double max = 1.0;

    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        frontRight = new WPI_TalonSRX(1);
        
        
        
        frontLeft = new WPI_TalonSRX(2);
        
        
        
        backRight = new WPI_TalonSRX(3);
        
        
        
        backLeft = new WPI_TalonSRX(4);
        
        
        
        mecanumDrive1 = new MecanumDrive(frontRight, backRight,
              frontLeft, backLeft);
        addChild("Mecanum Drive 1",mecanumDrive1);
        mecanumDrive1.setSafetyEnabled(true);
        mecanumDrive1.setExpiration(0.1);
        mecanumDrive1.setMaxOutput(1.0);

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new xboxDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void driveAuto(double throttle) {
        if (!driveCargo) {
            driveWithJoystickReversed(throttle);
        } else {
            driveWithJoystick(throttle);
        }
    }

    public void driveWithJoystickReversed(Double throttle) {
        speed = ((throttle * -1 + 1) / 8.0) * 3 + .25;
        if (speed > max) {
            speed = max;
        }
        mecanumDrive1.driveCartesian(x * -speed /* x */, y * -speed/* y */, z * speed /* z */, 0.0 /* gyro */);
    }

    public void driveWithJoystick(Double throttle) {
        speed = ((throttle * -1 + 1) / 8.0) * 3 + .25;
        if (speed > max) {
            speed = max;
        }
        mecanumDrive1.driveCartesian(x * speed /* x */, y * speed/* y */, z * speed /* z */, 0.0 /* gyro */);
    }

    public void moveRight() {
        if (!driveCargo) {
            mecanumDrive1.driveCartesian(.75 /* x */, 0/* y */, 0 /* z */, 0.0 /* gyro */);
        } else {
            mecanumDrive1.driveCartesian(-.75 /* x */, 0/* y */, 0 /* z */, 0.0 /* gyro */);
        }
    }
    public void driveStraight(double speed){
        mecanumDrive1.driveCartesian(-0 /* x */, speed , 0 /* z */, 0.0 /* gyro */);
    }

    public void moveLeft() {
        if (!driveCargo) {
            mecanumDrive1.driveCartesian(-.75/* x */, 0/* y */, 0 /* z */, 0.0 /* gyro */);
        } else {
            mecanumDrive1.driveCartesian(.75/* x */, 0/* y */, 0 /* z */, 0.0 /* gyro */);
        }
    }
    /**
     * @return the driveCargo
     */
    public Boolean getDriveCargo() {
        return driveCargo;
    }
    public String getStyle(){
        if (driveCargo){
            return "Cargo";
        }
        return "Hatch";
    }
    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }
    @Override
    public void periodic() {
        // Put code here to be run every loop

        // get raw values
        rawX = Robot.oi.leftJoystick.getRawAxis(0);
        rawY = Robot.oi.leftJoystick.getRawAxis(1);
        rawZ = Robot.oi.leftJoystick.getRawAxis(4);
        // create a "Dead Zone"
        x = (rawX > .2 || rawX < -.2 ? rawX : 0);
        y = (rawY > .2 || rawY < -.2 ? rawY : 0);
        z = (rawZ > .2 || rawZ < -.2 ? rawZ : 0);
        Robot.Dash.throttle = speed; // set dash speed to to speed
        Robot.Dash.driveStyle = getStyle(); //set dash drive style
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
