
package org.usfirst.frc.team6171.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
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
	
	Servo serv1,serv2;
	VictorSP victor1;
	OI oi;
	PowerDistributionPanel pdp;
	
    public void robotInit() {
    	serv1 = new Servo(RobotMap.SERVO_PORT_ONE);
    	serv2 = new Servo(RobotMap.SERVO_PORT_TWO);
    	victor1 = new VictorSP(RobotMap.MOTOR_PORT_ONE);
    	oi = new OI();
    	pdp = new PowerDistributionPanel();
    	SmartMaker.servoPositionCreator();
    	SmartMaker.startCamera();
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
    }

    
    public void teleopInit()
    {
    	serv1.set(0);
    	SmartMaker.putNumber("Servo one angle:", serv1.getAngle());
    	victor1.set(0);
    	SmartMaker.putNumber("Motor one speed:", victor1.get());
    	SmartMaker.putNumber("Motor one current:",pdp.getCurrent(RobotMap.MOTOR_PORT_ONE_PDP));
    	serv2.setAngle((int)SmartMaker.servoPosition.getSelected());
    	SmartMaker.putNumber("Servo two angle:",serv2.getAngle());
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
    	if(oi.getJoyPOV()==90)serv1.setAngle(0);
    	if(oi.getJoyPOV()==45)serv1.setAngle(45);
    	if(oi.getJoyPOV()==0)serv1.setAngle(90);
    	if(oi.getJoyPOV()==315)serv1.setAngle(135);
    	if(oi.getJoyPOV()==270)serv1.setAngle(180);
    	SmartMaker.putNumber("Servo one angle:", serv1.getAngle());
    	victor1.set(oi.getJoyLeftY());
    	SmartMaker.putNumber("Motor one speed:", victor1.get());
    	SmartMaker.putNumber("Motor one current:",pdp.getCurrent(RobotMap.MOTOR_PORT_ONE_PDP));
     	//SmartMaker.putNumber("Servo two input angle:", 90);
    	serv2.setAngle((int)SmartMaker.servoPosition.getSelected());
    	//SmartMaker.putNumber("Selected",(int)SmartMaker.servoPosition.getSelected() );
    	SmartMaker.putNumber("Servo two angle:",serv2.getAngle());
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
