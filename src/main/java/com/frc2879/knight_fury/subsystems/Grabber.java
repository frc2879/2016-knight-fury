package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Solenoid grabberSol;
    
    public Grabber() {
        super("Grabber");
        
        grabberSol = new Solenoid(RobotConfig.PNEUMATICS_PCM, RobotConfig.PNEUMATICS_GRABBER);
    }    
    
    public void setSol(boolean val) {
        grabberSol.set(val);
    }
    
    //grabber is in grabbed position when sol is set to false
    public boolean getGrabbed() {
        return !grabberSol.get();
    }
    
    public void grab() {
        setSol(false);
    }
    
    public void release() {
        setSol(true);
    }
    
    public void toggle() {
        if(getGrabbed()) {
            release();
        } else {
            grab();
        }
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

