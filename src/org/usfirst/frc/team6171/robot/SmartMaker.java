package org.usfirst.frc.team6171.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartMaker extends SmartDashboard{
	
	public static CameraServer server;
	
	public static SendableChooser servoPosition;
	
	public static void startCamera(){
		try{
	    	server = CameraServer.getInstance();
	        server.setQuality(50);
	        //the camera name (ex "cam0") can be found through the roborio web interface
	        server.startAutomaticCapture(RobotMap.CAMERA_PORT_ONE);
	    	}
	    	catch(Exception e){}	
	}
	public static void servoPositionCreator()
	{
		servoPosition = new SendableChooser();
		servoPosition.addObject("0 degrees",0);
		servoPosition.addObject("45 degrees",45);
		servoPosition.addObject("90 degrees",90);
		servoPosition.addObject("135 degrees",135);
		servoPosition.addObject("180 degrees",180);
		putData("Servo Position chooser",servoPosition);
		}
	
}
