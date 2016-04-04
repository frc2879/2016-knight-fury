package com.frc2879.knight_fury;

import com.frc2879.knight_fury.addon.BlackBoxLogger;
import com.frc2879.knight_fury.commands.DriveForwardDistance;
import com.frc2879.knight_fury.subsystems.*;
import com.frc2879.knight_fury.util.HelpableAbstractCommand;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import jaci.openrio.toast.core.ToastConfiguration;
import jaci.openrio.toast.core.command.CommandBus;
import jaci.openrio.toast.core.loader.module.ModuleManager;
import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;
import jaci.openrio.toast.lib.module.ModuleConfig;
import jaci.openrio.toast.lib.state.RobotState;

//@Branch(branch = "com.frc2879.knight_fury.addon.BlackBoxLogger", dependency = "BlackBox", method = "BBload")
public class RobotModule extends IterativeModule {

    public static Logger logger;
    
    public static final String moduleName = "2016-knight-fury";
    public static final String moduleVersion = "0.1.4";
    
    public static final String robotName = ToastConfiguration.Property.ROBOT_NAME.asString();
    public static final int robotTeam = ToastConfiguration.Property.ROBOT_TEAM.asInt();
    public static final String robotDesc = ToastConfiguration.Property.ROBOT_DESC.asString();

    @Override
    public String getModuleName() {
        return moduleName;
    }

    @Override
    public String getModuleVersion() {
        return moduleVersion;
    }
    
    public static ModuleConfig config;

    public static OI oi;
    
    public static Drivetrain drivetrain;
    public static Arm arm;
    public static Pneumatics pneumatics;
    public static Grabber grabber;
    public static Shooter shooter;
    public static IMU imu;
    
    public static boolean loaded = false;

    //Command autonomousCommand;
    //SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        logger = new Logger(moduleName, Logger.ATTR_DEFAULT);
        // TODO: Module Init
        
        config = new ModuleConfig(RobotModule.moduleName);
        RobotConfig.load(config);

        CommandBus.registerCommand(new HelpableAbstractCommand() {
            @Override
            public String getCommandName() {
                return "reloadkfconfig";
            }
            @Override
            public void invokeCommand(int argLength, String[] args, String fullCommand) {
                RobotConfig.load(RobotModule.config);
                RobotModule.logger.info("Config reloaded");
            }
            @Override
            public String getHelp() {
                return "Reloads Knight Fury config";
            }
        });

        drivetrain = new Drivetrain();
        arm = new Arm();
        pneumatics = new Pneumatics();
        grabber = new Grabber();
        shooter = new Shooter();
        imu = new IMU();
        
        
        oi = new OI();
        
        if(ModuleManager.moduleExists("BlackBox"))
            BlackBoxLogger.init();
                
        loaded = true;
        
        //autoChooser = new SendableChooser();


        CommandBus.registerCommand(new HelpableAbstractCommand() {
            @Override
            public String getCommandName(){
                return "driveforwarddist";
            }
            @Override
            public void invokeCommand(int argLength, String[] args, String command) {
                Scheduler.getInstance().add(new DriveForwardDistance(Double.valueOf(args[0]), Double.valueOf(args[1])));
            }
            @Override
            public String getHelp() {
                return "Drives forward for a distance. Args: [speed, distance (in feet)]";
            }
        });
    }

    @Override
    public void tickState(RobotState state) {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit() {

    }

    public void disabledPeriodic() {
        //Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    public void autonomousInit() {
        //autonomousCommand = (Command) autoChooser.getSelected();
        
        

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
       // if (autonomousCommand != null)
       //     autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
