package com.frc2879.knight_fury.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.frc2879.knight_fury.RobotModule;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.openrio.toast.core.Environment;
import jaci.openrio.toast.core.thread.Heartbeat;

/**
 *
 */
public class IMU extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static ADIS16448_IMU adisimu;
        
    public IMU() {
        if(Environment.isSimulation()){
            
        } else {
            adisimu = new ADIS16448_IMU();
        }
        
        Heartbeat.add(skipped -> {
            SmartDashboard.putData("IMU", adisimu);
        });
    }
    
    public static ADIS16448_IMU getIMUDevice() {
        return adisimu;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

