package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    DoubleSolenoid shooterSol;
    
    public Shooter() {
        super("Shooter");
        SmartDashboard.putData(this);
        
        shooterSol = new DoubleSolenoid(RobotConfig.PNEUMATICS_PCM, RobotConfig.PNEUMATICS_SHOOTER_FORWARD, RobotConfig.PNEUMATICS_SHOOTER_REVERSE);
    }
    
    public void setSol(DoubleSolenoid.Value val) {
        shooterSol.set(val);
    }
    
    public void extend() {
        setSol(DoubleSolenoid.Value.kForward);
    }
    
    public void retract() {
        setSol(DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

