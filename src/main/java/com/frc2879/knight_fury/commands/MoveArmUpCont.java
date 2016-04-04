package com.frc2879.knight_fury.commands;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.RobotModule;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmUpCont extends Command {

    public MoveArmUpCont() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("MoveArmUpCont");
        requires(RobotModule.arm);
        requires(RobotModule.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //RobotModule.grabber.grab();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(RobotModule.grabber.getGrabbed()) {
            RobotModule.arm.set((RobotModule.oi.getcontrollerDriver().rt.getX() * RobotConfig.COMMANDS_MOVEARMUP_SPEEDMULTIPLIER));
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotModule.oi.getcontrollerDriver().rt.getX() == 0 || RobotModule.arm.isRevLimitSwitchClosed() || !RobotModule.grabber.getGrabbed());
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