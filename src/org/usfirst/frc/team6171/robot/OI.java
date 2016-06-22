package org.usfirst.frc.team6171.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static final int LEFTX = 0;
	public static final int LEFTY = 1;
	public static final int RTRIGGER = 3;
	public static final int LTRIGGER = 2;
	public static final int RIGHTX = 4;
	public static final int RIGHTY = 5;

	public static final int A_NUM = 1;
	public static final int B_NUM = 2;
	public static final int X_NUM = 3;
	public static final int Y_NUM = 4;
	public static final int LB_NUM = 5;
	public static final int RB_NUM = 6;
	public static final int BACK_NUM = 7;
	public static final int START_NUM = 8;
	public static final int LEFT_JOY_NUM = 9;
	public static final int RIGHT_JOY_NUM = 10;
	
	public static final float RUMBLE_ON = 1;
	public static final float RUMBLE_OFF = 0;
	
	
	JoystickButton X, A, B, Y, LB, RB, Back, Start, LeftJoy, RightJoy;
	Joystick joy;
	
	public OI(){
		
		joy = new Joystick(RobotMap.COMPUTER_PORT_ONE);
		A = new JoystickButton(joy, A_NUM);
		B = new JoystickButton(joy, B_NUM);
		X = new JoystickButton(joy, X_NUM);
		Y = new JoystickButton(joy, Y_NUM);
		LB = new JoystickButton(joy, LB_NUM);
		RB = new JoystickButton(joy, RB_NUM);
		Back = new JoystickButton(joy, BACK_NUM);
		Start = new JoystickButton(joy, START_NUM);
		LeftJoy = new JoystickButton(joy, LEFT_JOY_NUM);
		RightJoy = new JoystickButton(joy, RIGHT_JOY_NUM);
	
	}
	
	public double getJoyLeftY(){
		return joy.getRawAxis(LEFTY);
	}
	public double getJoyLeftX(){
		return joy.getRawAxis(LEFTX);
	}
	public double getJoyRightY(){
		return joy.getRawAxis(RIGHTY);
	}
	public double getJoyRightX(){
		return joy.getRawAxis(RIGHTX);
	}
	public double getJoyRightTrigger()
	{
		return joy.getRawAxis(RTRIGGER);
	}
	public double getJoyLeftTrigger()
	{
		return joy.getRawAxis(LTRIGGER);
	}
	
	public void setJoyRumbleOn()
	{
			joy.setRumble(RumbleType.kLeftRumble,RUMBLE_ON);
			joy.setRumble(RumbleType.kRightRumble,RUMBLE_ON);
		

	}
	public void setJoyRumbleOff()
	{
			joy.setRumble(RumbleType.kLeftRumble,RUMBLE_OFF);
			joy.setRumble(RumbleType.kRightRumble,RUMBLE_OFF);
		

	}

	public int getJoyPOV() {
		// TODO Auto-generated method stub
		return joy.getPOV();
	}
}
