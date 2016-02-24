package com.frc2879.knight_fury;

import jaci.openrio.toast.lib.module.ModuleConfig;

public class RobotConfig {
    
    public static ModuleConfig config;

    public static int CONTROLLER_DRIVER;
    public static int CONTROLLER_CODRIVER;
    
    public static String DRIVE_TYPE;
    public static boolean DRIVE_SQUAREDINPUTS;
    
    public static boolean DRIVETRAIN_TALONS_BRAKE;
    
    public static Integer[] DRIVETRAIN_TALONS_LEFT_IDS;
    public static Integer[] DRIVETRAIN_TALONS_RIGHT_IDS;
    
    public static int DRIVETRAIN_TALONS_LEFT_ENCODER;
    public static int DRIVETRAIN_TALONS_RIGHT_ENCODER;
    
    public static boolean DRIVETRAIN_TALONS_LEFT_REVERSE;
    public static boolean DRIVETRAIN_TALONS_RIGHT_REVERSE;
    
    public static int PNEUMATICS_PCM;
    
    public static int PNEUMATICS_GRABBER;
    
    public static int PNEUMATICS_SHOOTER_FORWARD;
    public static int PNEUMATICS_SHOOTER_REVERSE;
    
    public static int ARM_TALON_ID;
    public static boolean ARM_TALON_REVERSE;
    public static boolean ARM_TALON_BRAKE;
    
    public static double COMMANDS_SHOOTBALL_WAITTIMEOUT_SHOOTEREXTENDRETRACT;
    public static double COMMANDS_SHOOTBALL_WAITTIMEOUT_GRABRELEASESHOOT;
    
    public static double COMMANDS_MOVEARMDOWN_SPEEDMULTIPLIER;
    public static double COMMANDS_MOVEARMUP_SPEEDMULTIPLIER;
    
    
    public RobotConfig() {
        // TODO Auto-generated constructor stub
    }
    
    public static void load() {
        config = new ModuleConfig(RobotModule.moduleName);
        
        CONTROLLER_DRIVER = config.getInt("controller.driver", 0);
        CONTROLLER_CODRIVER = config.getInt("controller.codriver", 1);
        
        //Drive preferences
        DRIVE_TYPE = config.getString("drive.type", "TANK");
        DRIVE_SQUAREDINPUTS = config.getBoolean("drive.squaredinputs", false);
        
        DRIVETRAIN_TALONS_BRAKE = config.getBoolean("drivetrain.talons.brake", false);
        
        //Drivetrain talon IDs
        DRIVETRAIN_TALONS_LEFT_IDS = (Integer[]) config.getArray("drivetrain.talons.left.ids", new Integer[] {1, 2,});
        DRIVETRAIN_TALONS_RIGHT_IDS = (Integer[]) config.getArray("drivetrain.talons.right.ids", new Integer[] {3, 4});
        
        DRIVETRAIN_TALONS_LEFT_REVERSE = config.getBoolean("drivetrain.talons.left.reverse", false);
        DRIVETRAIN_TALONS_RIGHT_REVERSE = config.getBoolean("drivetrain.talons.right.reverse", false);
        
        DRIVETRAIN_TALONS_LEFT_ENCODER = config.getInt("drivetrain.talons.left.encoder", DRIVETRAIN_TALONS_LEFT_IDS[1]);
        DRIVETRAIN_TALONS_RIGHT_ENCODER = config.getInt("drivetrain.talons.right.encoder", DRIVETRAIN_TALONS_RIGHT_IDS[1]);
        
        //PCM CAN ID
        PNEUMATICS_PCM = config.getInt("pneumatics.pcm", 0);
        
        //Grabber solenoid IDs
        PNEUMATICS_GRABBER = config.getInt("pneumatics.grabber", 0);
        
        //Shooter solenoid IDs
        PNEUMATICS_SHOOTER_FORWARD = config.getInt("pneumatics.shooter.forward", 2);
        PNEUMATICS_SHOOTER_REVERSE = config.getInt("pneumatics.shooter.reverse", 3);
        
        ARM_TALON_ID = config.getInt("arm.talon.id", 5);
        ARM_TALON_REVERSE = config.getBoolean("arm.talon.reverse", false);
        ARM_TALON_BRAKE = config.getBoolean("arm.talon.brake", false);
        
        COMMANDS_SHOOTBALL_WAITTIMEOUT_SHOOTEREXTENDRETRACT = config.getDouble("commands.shootball.waittimeout.shooterextendretract", 1);
        COMMANDS_SHOOTBALL_WAITTIMEOUT_GRABRELEASESHOOT = config.getDouble("commands.shootball.waittimeout.grabreleaseshoot", 0.25);
        
        COMMANDS_MOVEARMDOWN_SPEEDMULTIPLIER = config.getDouble("commands.movearmdown.speedmultiplier", 0.5);
        COMMANDS_MOVEARMUP_SPEEDMULTIPLIER = config.getDouble("commands.movearmup.speedmultiplier", 0.5);
    }
    

}
