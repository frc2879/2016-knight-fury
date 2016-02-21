package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.RobotModule;
import com.frc2879.knight_fury.commands.DriveArcade;
import com.frc2879.knight_fury.commands.DriveTank;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.openrio.toast.core.thread.Heartbeat;
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
    
    SendableChooser driveChooser;
    Command driveCommand;
    
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
        
        robotDrive.setSafetyEnabled(false);
        
    }

    public void initDefaultCommand() {
        driveChooser = new SendableChooser();
        if(RobotConfig.DRIVE_TYPE.equalsIgnoreCase("tank")) {
            driveChooser.addDefault("Tank", new DriveTank());
            driveChooser.addObject("Arcade", new DriveArcade());
        } else if(RobotConfig.DRIVE_TYPE.equalsIgnoreCase("arcade")) {
            driveChooser.addDefault("Arcade", new DriveArcade());
            driveChooser.addObject("Tank", new DriveTank());
        } else {
            driveChooser.addDefault("Tank", new DriveTank());
            driveChooser.addObject("Arcade", new DriveArcade());
        }
        
        SmartDashboard.putData("Drive Chooser", driveChooser);
        driveCommand = (Command) driveChooser.getSelected();
        
        
        Heartbeat.add(skipped -> {
            if((Command) driveChooser.getSelected() != driveCommand) {
                driveCommand = (Command) driveChooser.getSelected();
                RobotModule.drivetrain.setDriveCommand(driveCommand);
            }
        });
        
        setDefaultCommand(driveCommand);
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand()); 
        /*if(RobotConfig.DRIVE_TYPE.equalsIgnoreCase("tank")) {
            setDefaultCommand(new DriveTank());
        } else if(RobotConfig.DRIVE_TYPE.equalsIgnoreCase("arcade")) {
            setDefaultCommand(new DriveArcade());
        } else {
            setDefaultCommand(new DriveTank());
        }*/
    }
    
    public void setDriveCommand(Command c) {
        getDefaultCommand().cancel();
        setDefaultCommand(c);
        //getDefaultCommand().start();
        //getCurrentCommand().cancel();
    }
    
    public RobotDrive getRobotDrive() {
        return this.robotDrive;
    }
    
    public void stop() {
        robotDrive.stopMotor();
    }
}

