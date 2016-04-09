package com.frc2879.knight_fury.commands;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.RobotModule;
import com.frc2879.xboxcontroller.XboxController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmDownCont extends Command {
    
    XboxController controller;

    public MoveArmDownCont(XboxController controller) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("MoveArmDownCont");
        requires(RobotModule.arm);
        requires(RobotModule.grabber);
        this.controller = controller;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //RobotModule.grabber.grab();
        if(!RobotModule.grabber.getGrabbed()) {
            this.cancel();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(RobotModule.grabber.getGrabbed()) {
            RobotModule.arm.set(-(controller.lt.getX() * RobotConfig.COMMANDS_MOVEARMDOWNCONT_SPEEDMULTIPLIER));
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (controller.lt.getX() == 0 || RobotModule.arm.isFwdLimitSwitchClosed() || !RobotModule.grabber.getGrabbed());
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