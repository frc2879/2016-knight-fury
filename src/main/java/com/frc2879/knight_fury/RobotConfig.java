package com.frc2879.knight_fury;

import jaci.openrio.toast.lib.module.ModuleConfig;

public class RobotConfig {
    
    public static int CONTROLLER_DRIVER;
    public static int CONTROLLER_CODRIVER;
    
    public static String DRIVE_TYPE;
    public static boolean DRIVE_SQUAREDINPUTS;
    
    public static boolean DRIVETRAIN_TALONS_BRAKE;
    
    public static double DRIVETRAIN_TALONS_RAMPRATE;
    
    public static Integer[] DRIVETRAIN_TALONS_LEFT_IDS;
    public static Integer[] DRIVETRAIN_TALONS_RIGHT_IDS;
    
    //public static Double[] DRIVETRAIN_TALONS_LEFT_PIDF;
    //public static Double[] DRIVETRAIN_TALONS_RIGHT_PIDF;
    
    public static int DRIVETRAIN_TALONS_LEFT_ENCODER_ID;
    public static int DRIVETRAIN_TALONS_RIGHT_ENCODER_ID;
    
    public static boolean DRIVETRAIN_TALONS_LEFT_ENCODER_REVERSE;
    public static boolean DRIVETRAIN_TALONS_RIGHT_ENCODER_REVERSE;
    
    public static int DRIVETRAIN_TALONS_LEFT_ENCODER_CODESPERREV;
    public static int DRIVETRAIN_TALONS_RIGHT_ENCODER_CODESPERREV;
    
    public static boolean DRIVETRAIN_TALONS_LEFT_ENCODER_ZEROPOSITIONONINDEX;
    public static boolean DRIVETRAIN_TALONS_RIGHT_ENCODER_ZEROPOSITIONONINDEX;
    
    //public static double DRIVETRAIN_TALONS_LEFT_ENCODER_CODESPERFOOT;
    //public static double DRIVETRAIN_TALONS_RIGHT_ENCODER_CODESPERFOOT;
    
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
    public static double COMMANDS_DRIVEFORWARDDISTANCE_DISTERROR;
    
    public static double COMMANDS_AUTOLOWBARONCE_MOVEARMDOWN_SPEED;
    public static double COMMANDS_AUTOLOWBARONCE_DRIVEFORWARDDIST_SPEED;
    public static double COMMANDS_AUTOLOWBARONCE_DRIVEFORWARDDIST_DISTANCE;
    
    public RobotConfig() {
        // TODO Auto-generated constructor stub
    }
    
    public static void load(ModuleConfig config) {
        //config = new ModuleConfig(RobotModule.moduleName);
        
        CONTROLLER_DRIVER = config.getInt("controller.driver", 0);
        CONTROLLER_CODRIVER = config.getInt("controller.codriver", 1);
        
        
        //Drive preferences
        DRIVE_TYPE = config.getString("drive.type", "ARCADE");
        DRIVE_SQUAREDINPUTS = config.getBoolean("drive.squaredinputs", false);
        
        DRIVETRAIN_TALONS_BRAKE = config.getBoolean("drivetrain.talons.brake", true);
        
        DRIVETRAIN_TALONS_RAMPRATE = config.getDouble("drivetrain.talons.ramprate", 0);
        
        //Drivetrain talon IDs
        DRIVETRAIN_TALONS_LEFT_IDS = (Integer[]) config.getArray("drivetrain.talons.left.ids", new Integer[] {1, 2,});
        DRIVETRAIN_TALONS_RIGHT_IDS = (Integer[]) config.getArray("drivetrain.talons.right.ids", new Integer[] {3, 4});
        
        //DRIVETRAIN_TALONS_LEFT_PIDF = (Double[]) config.getArray("drivetrain.talons.left.pidf", new Double[] {0.0, 0.0, 0.0, 0.19343985446});
        //DRIVETRAIN_TALONS_RIGHT_PIDF = (Double[]) config.getArray("drivetrain.talons.right.pidf", new Double[] {0.0, 0.0, 0.0, 0.19343985446});
        
        DRIVETRAIN_TALONS_LEFT_REVERSE = config.getBoolean("drivetrain.talons.left.reverse", false);
        DRIVETRAIN_TALONS_RIGHT_REVERSE = config.getBoolean("drivetrain.talons.right.reverse", false);
        
        DRIVETRAIN_TALONS_LEFT_ENCODER_ID = config.getInt("drivetrain.talons.left.encoder.id", DRIVETRAIN_TALONS_LEFT_IDS[1]);
        DRIVETRAIN_TALONS_RIGHT_ENCODER_ID = config.getInt("drivetrain.talons.right.encoder.id", DRIVETRAIN_TALONS_RIGHT_IDS[1]);
        
        DRIVETRAIN_TALONS_LEFT_ENCODER_REVERSE = config.getBoolean("drivetrain.talons.left.encoder.reverse", true);
        DRIVETRAIN_TALONS_RIGHT_ENCODER_REVERSE = config.getBoolean("drivetrain.talons.right.encoder.reverse", true);
        
        DRIVETRAIN_TALONS_LEFT_ENCODER_CODESPERREV = config.getInt("drivetrain.talons.left.encoder.codesperrev", 2048);
        DRIVETRAIN_TALONS_RIGHT_ENCODER_CODESPERREV = config.getInt("drivetrain.talons.right.encoder.codesperrev", 2048);
        
        DRIVETRAIN_TALONS_LEFT_ENCODER_ZEROPOSITIONONINDEX = config.getBoolean("drivetrain.talons.left.encoder.zeropositiononindex", false);
        DRIVETRAIN_TALONS_RIGHT_ENCODER_ZEROPOSITIONONINDEX = config.getBoolean("drivetrain.talons.right.encoder.zeropositiononindex", false);
        
        

        
       // DRIVETRAIN_TALONS_LEFT_ENCODER_CODESPERFOOT = config.getDouble("drivetrain.talons.left.encoder.codesperfoot", 8000);
       // DRIVETRAIN_TALONS_RIGHT_ENCODER_CODESPERFOOT = config.getDouble("drivetrain.talons.right.encoder.codesperfoot", 8000);
        
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
    
        COMMANDS_AUTOLOWBARONCE_MOVEARMDOWN_SPEED = config.getDouble("commands.autolowbaronce.movearmdown.speed", 0.5);
        COMMANDS_AUTOLOWBARONCE_DRIVEFORWARDDIST_SPEED = config.getDouble("commands.autolowbaronce.driveforwarddistance.speed", 0.4);
        COMMANDS_AUTOLOWBARONCE_DRIVEFORWARDDIST_DISTANCE = config.getDouble("commands.autolowbaronce.driveforwarddistance.distance", 12);
    
    
    }
    

}
