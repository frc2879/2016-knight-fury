package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import jaci.openrio.toast.lib.registry.Registrar;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    CANTalon armTalon; 
    
    public Arm() {
        super("Arm");
        
        armTalon = Registrar.canTalon(RobotConfig.ARM_TALON_ID);
        armTalon.reverseOutput(RobotConfig.ARM_TALON_REVERSE);
        armTalon.enableBrakeMode(RobotConfig.ARM_TALON_BRAKE);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void stop() {
        armTalon.disableControl();
    }
}

