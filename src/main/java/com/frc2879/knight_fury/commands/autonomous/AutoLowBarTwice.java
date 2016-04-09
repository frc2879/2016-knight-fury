package com.frc2879.knight_fury.commands.autonomous;

import com.frc2879.knight_fury.RobotConfig;
import com.frc2879.knight_fury.commands.DriveForwardDistance;
import com.frc2879.knight_fury.commands.MoveArmDown;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoLowBarTwice extends CommandGroup {
    
    public  AutoLowBarTwice() {
        super("Low Bar Twice");
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        //addSequential(new MoveArmDown(RobotConfig.COMMANDS_AUTOLOWBARTWICE_MOVEARMDOWN_SPEED), 5);
        addSequential(new DriveForwardDistance(RobotConfig.COMMANDS_AUTOLOWBARTWICE_DRIVEFORWARDDIST_1_SPEED, RobotConfig.COMMANDS_AUTOLOWBARTWICE_DRIVEFORWARDDIST_1_DISTANCE), 10);
        addSequential(new WaitCommand(RobotConfig.COMMANDS_AUTOLOWBARTWICE_WAIT));
        addSequential(new DriveForwardDistance(RobotConfig.COMMANDS_AUTOLOWBARTWICE_DRIVEFORWARDDIST_2_SPEED, RobotConfig.COMMANDS_AUTOLOWBARTWICE_DRIVEFORWARDDIST_2_DISTANCE), 10);
    }
}
