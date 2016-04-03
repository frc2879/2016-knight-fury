package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Grabber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Solenoid grabberSol;
    
    public Grabber() {
        super("Grabber");
        SmartDashboard.putData(this);
        
        grabberSol = new Solenoid(RobotConfig.PNEUMATICS_PCM, RobotConfig.PNEUMATICS_GRABBER);
    }    
    
    public void setSol(boolean val) {
        grabberSol.set(val);
    }
    
    static boolean reversed = true;
    
    //grabber is in grabbed position when sol is set to false
    public boolean getGrabbed() {
        if(reversed) {
            return !grabberSol.get();
        } else {
            return grabberSol.get();
        }
    }
    
    public void grab() {
        setSol(!reversed);
    }
    
    public void release() {
        setSol(reversed);
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

