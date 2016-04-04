package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.RobotModule;
import com.frc2879.knight_fury.commands.DriveArcade;
import com.frc2879.knight_fury.commands.DriveTank;
import com.frc2879.knight_fury.util.HelpableAbstractCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.openrio.toast.core.command.CommandBus;
import jaci.openrio.toast.core.thread.Heartbeat;
import jaci.openrio.toast.lib.registry.Registrar;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    CANTalon leftTalon, leftTalonF, rightTalon, rightTalonF;
    
    public RobotDrive robotDrive;
    
    SendableChooser driveChooser;
    Command driveCommand;
    
    public Drivetrain() {
        super("Drivetrain");
        SmartDashboard.putData(this);
        
        initTalonConfig();
        
        robotDrive = new RobotDrive(leftTalon, rightTalon);
        
        Heartbeat.add(skipped -> {
            //closed loop testing stuff
            SmartDashboard.putNumber("left talon speed", RobotModule.drivetrain.getLeftTalon().getSpeed());
            SmartDashboard.putNumber("right talon speed", RobotModule.drivetrain.getRightTalon().getSpeed());
            SmartDashboard.putNumber("left talon pos", RobotModule.drivetrain.getLeftTalon().getPosition());
            SmartDashboard.putNumber("right talon pos", RobotModule.drivetrain.getRightTalon().getPosition());
            SmartDashboard.putNumber("left talon encpos", RobotModule.drivetrain.getLeftTalon().getEncPosition());
            SmartDashboard.putNumber("right talon encpos", RobotModule.drivetrain.getRightTalon().getEncPosition());
            SmartDashboard.putNumber("left talon encvel", RobotModule.drivetrain.getLeftTalon().getEncVelocity());
            SmartDashboard.putNumber("right talon encvel", RobotModule.drivetrain.getRightTalon().getEncVelocity());
            SmartDashboard.putNumber("left talon get", RobotModule.drivetrain.getLeftTalon().get());
            SmartDashboard.putNumber("right talon get", RobotModule.drivetrain.getRightTalon().get());
            SmartDashboard.putNumber("left talon cl error", RobotModule.drivetrain.getLeftTalon().getClosedLoopError());
            SmartDashboard.putNumber("right talon cl error", RobotModule.drivetrain.getRightTalon().getClosedLoopError());

        });
        
        CommandBus.registerCommand(new HelpableAbstractCommand() {
            @Override
            public String getCommandName() {
                return "reloaddrivetrainconfig";
            }
            @Override
            public void invokeCommand(int argLength, String[] args, String fullCommand) {
                initTalonConfig();
                RobotModule.logger.info("Drivetrain config reloaded");
            }
            @Override
            public String getHelp() {
                return "Reloads Drivetrain talon config";
            }
        });

        CommandBus.registerCommand(new HelpableAbstractCommand() {
            @Override
            public String getCommandName() {
                return "setpidf";
            }
            @Override
            public void invokeCommand(int argLength, String[] args, String fullCommand) {
                if(args[0].equalsIgnoreCase("left")) {
                    leftTalon.setPID(Double.valueOf(args[1]),Double.valueOf(args[2]),Double.valueOf(args[3]));
                    leftTalon.setF(Double.valueOf(args[4]));
                } else if(args[0].equalsIgnoreCase("right")) {
                    rightTalon.setPID(Double.valueOf(args[1]),Double.valueOf(args[2]),Double.valueOf(args[3]));
                    rightTalon.setF(Double.valueOf(args[4]));
                }
            }
            @Override
            public String getHelp() {
                return "Sets Talon PIDF values. Args: [side (left/right), P, I, D, F]";
            }
        });
        
        CommandBus.registerCommand(new HelpableAbstractCommand() {
            @Override
            public String getCommandName() {
                return "settaloncontrolmode";
            }
            @Override
            public void invokeCommand(int argLength, String[] args, String fullCommand) {
                if(args[0].equalsIgnoreCase("pvb") || args[0].equalsIgnoreCase("PercentVbus")) {
                    leftTalon.changeControlMode(TalonControlMode.PercentVbus);
                    rightTalon.changeControlMode(TalonControlMode.PercentVbus);
                } else if(args[0].equalsIgnoreCase("Current")) {
                    leftTalon.changeControlMode(TalonControlMode.Current);
                    rightTalon.changeControlMode(TalonControlMode.Current);
                } else if(args[0].equalsIgnoreCase("Speed")) {
                    leftTalon.changeControlMode(TalonControlMode.Speed);
                    rightTalon.changeControlMode(TalonControlMode.Speed);
                } else if(args[0].equalsIgnoreCase("Position")) {
                    leftTalon.changeControlMode(TalonControlMode.Position);
                    rightTalon.changeControlMode(TalonControlMode.Position);
                }
            }
            @Override
            public String getHelp() {
                return "Sets main talon modes. Args: [mode (pvb/PercentVbus, Current, Speed, Position)]";
            }
        });
        
        //robotDrive.setSafetyEnabled(false);
        
    }
    
    public void initTalonConfig() {
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
        
        leftTalon.setVoltageRampRate(RobotConfig.DRIVETRAIN_TALONS_RAMPRATE);
        rightTalon.setVoltageRampRate(RobotConfig.DRIVETRAIN_TALONS_RAMPRATE);
        
        
        leftTalon.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);
        leftTalonF.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);
        rightTalon.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);
        rightTalonF.enableBrakeMode(RobotConfig.DRIVETRAIN_TALONS_BRAKE);
        
        
        leftTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        rightTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        
        leftTalon.reverseSensor(RobotConfig.DRIVETRAIN_TALONS_LEFT_ENCODER_REVERSE);
        rightTalon.reverseSensor(RobotConfig.DRIVETRAIN_TALONS_RIGHT_ENCODER_REVERSE);
        
        
        leftTalon.configEncoderCodesPerRev(RobotConfig.DRIVETRAIN_TALONS_LEFT_ENCODER_CODESPERREV);
        rightTalon.configEncoderCodesPerRev(RobotConfig.DRIVETRAIN_TALONS_RIGHT_ENCODER_CODESPERREV);
        
        leftTalon.enableZeroSensorPositionOnIndex(RobotConfig.DRIVETRAIN_TALONS_LEFT_ENCODER_ZEROPOSITIONONINDEX, false);
        rightTalon.enableZeroSensorPositionOnIndex(RobotConfig.DRIVETRAIN_TALONS_RIGHT_ENCODER_ZEROPOSITIONONINDEX, false);
        
        leftTalon.configNominalOutputVoltage(+0.0f, -0.0f);
        rightTalon.configNominalOutputVoltage(+0.0f, -0.0f);
        
        leftTalon.configPeakOutputVoltage(+12.0f, -12.0f);
        rightTalon.configPeakOutputVoltage(+12.0f, -12.0f);
        
        leftTalon.setEncPosition(0);
        rightTalon.setEncPosition(0);
        
        leftTalon.setProfile(0);
        leftTalon.setPID(RobotConfig.DRIVETRAIN_TALONS_LEFT_PIDF[0], RobotConfig.DRIVETRAIN_TALONS_LEFT_PIDF[1], RobotConfig.DRIVETRAIN_TALONS_LEFT_PIDF[2]);
        leftTalon.setF(RobotConfig.DRIVETRAIN_TALONS_LEFT_PIDF[3]);
        
        rightTalon.setProfile(0);
        rightTalon.setPID(RobotConfig.DRIVETRAIN_TALONS_RIGHT_PIDF[0], RobotConfig.DRIVETRAIN_TALONS_RIGHT_PIDF[1], RobotConfig.DRIVETRAIN_TALONS_RIGHT_PIDF[2]);
        rightTalon.setF(RobotConfig.DRIVETRAIN_TALONS_RIGHT_PIDF[3]);
        
        leftTalon.set(0);
        rightTalon.set(0);
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
    
    public CANTalon getLeftTalon() {
        return leftTalon;
    }
    
    public CANTalon getRightTalon() {
        return rightTalon;
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
        leftTalon.set(-leftSpeed);
        rightTalon.set(rightSpeed);
    }
    
    public void drive(double speed) {
        drive(speed, speed);
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

