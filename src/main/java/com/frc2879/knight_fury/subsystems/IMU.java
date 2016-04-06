package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotModule;
import com.frc2879.knight_fury.lib.device.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.openrio.toast.core.Environment;
import jaci.openrio.toast.core.thread.Async;
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
            Async.schedule(() -> {
                adisimu = new ADIS16448_IMU();
            });
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
    
    public double getCurrentGyroDegrees() {
        if(Environment.isSimulation()){
            return 0.0;
        } else {
            return adisimu.getAngleZ();
        }
    }
    
    public void resetGyro() {
        if(!Environment.isSimulation())
            adisimu.reset();
    }
}

