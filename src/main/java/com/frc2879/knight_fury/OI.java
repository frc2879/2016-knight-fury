package com.frc2879.knight_fury;

import com.frc2879.knight_fury.commands.*;
import com.frc2879.xboxcontroller.XboxController;

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
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
	private XboxController controllerDriver;
	//private XboxController controllerCoDriver;
	
	public OI() {
	    
	    controllerDriver = new XboxController(RobotConfig.CONTROLLER_DRIVER);
//	    controllerCoDriver = new XboxController(RobotConfig.CONTROLLER_CODRIVER);
		
//	    controllerCoDriver.rt.setTriggerSensitivity(0.3);
//	    controllerCoDriver.lt.setTriggerSensitivity(0.3);
//	    
//	    //controllerCoDriver.lb.whenPressed(new MoveArmDown(RobotConfig.COMMANDS_CONTROLLER_MOVEARMDOWN_SPEED));
//	    //controllerCoDriver.rb.whenPressed(new MoveArmUp(RobotConfig.COMMANDS_CONTROLLER_MOVEARMUP_SPEED));
//		
//	    controllerCoDriver.lt.whenPressed(new MoveArmDownCont(controllerCoDriver));
//	    controllerCoDriver.rt.whenPressed(new MoveArmUpCont(controllerCoDriver));
//		
//	    controllerCoDriver.b.whenPressed(new GrabberToggle());
//	    controllerCoDriver.x.whenPressed(new ShootBall());
//	    
//	    controllerDriver.rt.setTriggerSensitivity(0.3);
//	    controllerDriver.lt.setTriggerSensitivity(0.3);
//        
//	    //controllerDriver.lb.whenPressed(new MoveArmDown(RobotConfig.COMMANDS_CONTROLLER_MOVEARMDOWN_SPEED));
//	    //controllerDriver.rb.whenPressed(new MoveArmUp(RobotConfig.COMMANDS_CONTROLLER_MOVEARMUP_SPEED));
//        
//	    controllerDriver.lt.whenPressed(new MoveArmDownCont(controllerDriver));
//	    controllerDriver.rt.whenPressed(new MoveArmUpCont(controllerDriver));
//        
//	    controllerDriver.b.whenPressed(new GrabberToggle());
//	    controllerDriver.x.whenPressed(new ShootBall());
		
		controllerDriver.dPad.left.whenPressed(new RotateWithGyro(RobotConfig.COMMANDS_CONTROLLER_ROTATEWITHGYRO_ANGLE90DEG, RobotConfig.COMMANDS_CONTROLLER_ROTATEWITHGYRO_SPEED, true));
		controllerDriver.dPad.right.whenPressed(new RotateWithGyro(RobotConfig.COMMANDS_CONTROLLER_ROTATEWITHGYRO_ANGLE90DEG, RobotConfig.COMMANDS_CONTROLLER_ROTATEWITHGYRO_SPEED, false));
		controllerDriver.dPad.down.whenPressed(new RotateWithGyro(RobotConfig.COMMANDS_CONTROLLER_ROTATEWITHGYRO_ANGLE180DEG, RobotConfig.COMMANDS_CONTROLLER_ROTATEWITHGYRO_SPEED, false));
	    
	}
	
	public XboxController getcontrollerDriver() {
		return controllerDriver;
	}
	
//	public XboxController getcontrollerCoDriver() {
//        return controllerCoDriver;
//    }
    
	
}

