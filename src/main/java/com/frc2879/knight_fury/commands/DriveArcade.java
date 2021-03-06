package com.frc2879.knight_fury.commands;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.RobotModule;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArcade extends Command {

    public DriveArcade() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("DriveArcade");
        requires(RobotModule.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotModule.drivetrain.getRobotDrive().arcadeDrive(RobotModule.oi.getcontrollerDriver().leftStick.getY(), RobotModule.oi.getcontrollerDriver().leftStick.getX(), RobotConfig.DRIVE_SQUAREDINPUTS);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
