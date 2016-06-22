
package org.usfirst.frc.team6171.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	Servo serv;
	Joystick joy;
	
    public void robotInit() {
    	serv = new Servo(0);
    	joy = new Joystick(0);
    	serv.setAngle(90);
    	SmartDashboard.putDouble("Servo angle",serv.getAngle());
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	//serv.setAngle(45);
    }

    
    public void teleopInit()
    {
    serv.set(90);
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	if(joy.getPOV()==0)serv.setAngle(0);
    	if(joy.getPOV()==45)serv.setAngle(45);
    	if(joy.getPOV()==90)serv.setAngle(90);
    	if(joy.getPOV()==135)serv.setAngle(135);
    	if(joy.getPOV()==180)serv.setAngle(180);
    	SmartDashboard.putDouble("Servo angle",serv.getAngle());
    	SmartDashboard.putDouble("POV angle", serv.getAngle());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
