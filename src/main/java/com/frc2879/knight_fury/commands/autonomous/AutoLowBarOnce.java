package com.frc2879.knight_fury.commands.autonomous;

import com.frc2879.knight_fury.commands.DriveForwardDistance;
import com.frc2879.knight_fury.commands.MoveArmDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLowBarOnce extends CommandGroup {
    
    public  AutoLowBarOnce() {
        super("Low Bar Once");
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
        
        addSequential(new MoveArmDown(0.5), 5);
        addSequential(new DriveForwardDistance(0.4, 12), 10);
    }
}
