package com.frc2879.knight_fury.commands;

import com.frc2879.knight_fury.RobotModule;
import com.frc2879.knight_fury.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateWithGyro extends Command {
    
    double distance, angleInDegrees, speed, initialAngle;
    boolean turnLeft;
    
    Drivetrain dt = RobotModule.drivetrain;

    public RotateWithGyro(double angleInDegrees, double speed, boolean turnLeft) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("RotateWithGyro");
        requires(RobotModule.drivetrain);
        
        this.angleInDegrees = angleInDegrees;
        this.speed = speed;
        this.turnLeft = turnLeft;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initialAngle = RobotModule.imu.getCurrentGyroDegrees();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (turnLeft) {
            dt.drive(-speed, speed);
        }
        else {
            dt.drive(speed,-speed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (turnLeft) {
            return (RobotModule.imu.getCurrentGyroDegrees() - initialAngle < -angleInDegrees);
        }
        else {
            return (RobotModule.imu.getCurrentGyroDegrees() - initialAngle > angleInDegrees);
        }
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
