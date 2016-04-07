package com.frc2879.knight_fury.commands;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.RobotModule;
import com.frc2879.knight_fury.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardDistance extends Command {
    
    private double initialDistLeft, initialDistRight, setDist, setSpeed;
    
    Drivetrain dt = RobotModule.drivetrain;

    public DriveForwardDistance(double speed, double distance, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("DriveForwardDistance", timeout);
        requires(RobotModule.drivetrain);
        setSpeed = speed;
        setDist = distance - RobotConfig.COMMANDS_DRIVEFORWARDDISTANCE_DISTERROR;
    }
    
    public DriveForwardDistance(double speed, double distance) {
        this(speed, distance, 15);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
        initialDistLeft = dt.getLeftTalon().getPosition();
        initialDistRight = dt.getRightTalon().getPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dt.drive(setSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((Math.abs(dt.getLeftTalon().getPosition() - initialDistLeft) > (setDist)) 
                && (Math.abs(dt.getRightTalon().getPosition() - initialDistRight) > (setDist)) 
                || ((Math.abs(dt.getLeftTalon().get()) > 0.1) && dt.getLeftTalon().getSpeed() < 1) 
                || ((Math.abs(dt.getRightTalon().get()) > 0.1) && dt.getRightTalon().getSpeed() < 1));
    }

    // Called once after isFinished returns true
    protected void end() {
        dt.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}