package org.usfirst.frc4093.DeepSpace4093;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dash  {
	static final int HATCH_TAB = 2;
	static final int CARGO_TAB = 3;
	private int lastTab;
	public double throttle;
	private double l_Throttle;
	public String driveStyle;
	public String l_driveStyle = "?";
	public double encoder;
	public double l_encoder;
	public double voltage = 0;
	public double l_voltage = 0;
	public double time = 0;
	public double l_time = 0;
	public void Dash(){
		lastTab = 0;

	}
	public void displayData(String key, double value){
		SmartDashboard.putNumber(key, value);
	}
	public void displayData(String key, String value){
		SmartDashboard.putString(key, value);
	}
	public void displayData(String key,Boolean value) {
		SmartDashboard.putBoolean(key, value);
	}
	public void updateDashBoard(){
		//check if change is actually needed to preserve cpu
		if (throttle != l_Throttle) {
			l_Throttle = throttle;
			showSpeed();
		}
		if (encoder != l_encoder) {
			showEncoder();
		}
		if (driveStyle != l_driveStyle) {
			l_driveStyle = driveStyle;
			showDriveStyle();
		}
		if (time != l_time){
			l_time = time;
			showMatchTime();
		}
		if (voltage != l_voltage){
			l_voltage = voltage;
			showVoltage();
		}
			
	}
	public void changeTab(int tab){
		Shuffleboard.selectTab(tab); //switch to tab
		lastTab = tab;
	}
	public void toggleTab(){
		if (lastTab ==  HATCH_TAB){
			changeTab(CARGO_TAB);
		}else{
			changeTab(HATCH_TAB);
		}
	}
	public void showDriveStyle(){
		displayData("Drive Mode", driveStyle); //show drive mode in smart dashboard
        Shuffleboard.selectTab(driveStyle + " View");
	}
	public void showSpeed(){
		displayData("Speed",throttle);
	}
	public void showEncoder(){
		displayData("LiftEncoder",encoder);
	}
	public void showMatchTime(){
		displayData("Match Time", time);
	}
	public void showVoltage(){
		displayData("Voltage", voltage);
	}
}