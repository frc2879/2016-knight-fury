package com.frc2879.knight_fury.commands;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.RobotModule;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmDown extends Command {
    
    private double setSpeed;

    public MoveArmDown(Double speed, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("MoveArmDown", timeout);
        requires(RobotModule.arm);
        requires(RobotModule.grabber);
        setSpeed = speed;
    }
    
    public MoveArmDown(Double speed) {
        this(speed, 5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(!RobotModule.grabber.getGrabbed()) {
            this.cancel();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(RobotModule.grabber.getGrabbed()) {
            RobotModule.arm.set(-setSpeed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotModule.arm.isFwdLimitSwitchClosed() || !RobotModule.grabber.getGrabbed());
    }

    // Called once after isFinished returns true
    protected void end() {
        RobotModule.arm.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
