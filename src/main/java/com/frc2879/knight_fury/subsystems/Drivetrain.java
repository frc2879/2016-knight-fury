package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import jaci.openrio.toast.lib.registry.Registrar;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    CANTalon leftTalon;
    CANTalon leftTalonF;
    CANTalon rightTalon;
    CANTalon rightTalonF;
    
    public RobotDrive robotDrive;
    
    public Drivetrain() {
        super("Drivetrain");
        
        leftTalon = Registrar.canTalon(RobotConfig.DRIVETRAIN_TALONS_LEFT_IDS[0]);
        leftTalonF = Registrar.canTalon(RobotConfig.DRIVETRAIN_TALONS_LEFT_IDS[1]);
        rightTalon = Registrar.canTalon(RobotConfig.DRIVETRAIN_TALONS_RIGHT_IDS[0]);
        rightTalonF = Registrar.canTalon(RobotConfig.DRIVETRAIN_TALONS_RIGHT_IDS[1]);
        
        leftTalon.changeControlMode(TalonControlMode.PercentVbus);
        rightTalon.changeControlMode(TalonControlMode.PercentVbus);
        leftTalonF.changeControlMode(TalonControlMode.Follower);
        rightTalonF.changeControlMode(TalonControlMode.Follower);
        
        leftTalonF.set(leftTalon.getDeviceID());
        rightTalonF.set(rightTalon.getDeviceID());
        
        leftTalon.setInverted(RobotConfig.DRIVETRAIN_TALONS_LEFT_REVERSE);
        rightTalon.setInverted(RobotConfig.DRIVETRAIN_TALONS_RIGHT_REVERSE);
        
        
        leftTalon.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);
        leftTalonF.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);
        rightTalon.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);
        rightTalonF.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);

        leftTalon.set(0);
        rightTalon.set(0);
        
        robotDrive = new RobotDrive(leftTalon, rightTalon);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand()); 
    }
    
    public RobotDrive getRobotDrive() {
        return this.robotDrive;
    }
    
    public void stop() {
        robotDrive.stopMotor();
    }
}

