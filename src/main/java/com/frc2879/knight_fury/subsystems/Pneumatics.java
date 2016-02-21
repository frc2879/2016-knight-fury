package com.frc2879.knight_fury.subsystems;

import com.frc2879.knight_fury.RobotConfig;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class Pneumatics extends Subsystem {
   
   // Put methods for controlling this subsystem
   // here. Call these from Commands.
   
   final Compressor compressor;
   
   public Pneumatics() {
       super("Pneumatics");
       
       compressor = new Compressor(RobotConfig.PNEUMATICS_PCM);
       compressor.setClosedLoopControl(true);
   }
   
   public Compressor getCompressor() {
       return compressor;
   }

   public void initDefaultCommand() {
       // Set the default command for a subsystem here.
       //setDefaultCommand(new MySpecialCommand());
   }
}

