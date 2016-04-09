package com.frc2879.knight_fury.addon;

import com.frc2879.knight_fury.RobotModule;

import edu.wpi.first.wpilibj.Timer;
import jaci.openrio.module.blackbox.BlackBox;
import jaci.openrio.module.blackbox.BlackBoxContext;
import jaci.openrio.toast.core.Environment;
import jaci.openrio.toast.core.Toast;
import jaci.openrio.toast.core.thread.Async;
import jaci.openrio.toast.core.thread.Heartbeat;

public class BlackBoxLogger {

    public BlackBoxLogger() {
        // TODO Auto-generated constructor stub
    }

    public static void init() {
        BlackBoxContext talonclosedloop = BlackBox.context(RobotModule.moduleName + "_" + "TalonClosedLoop");

        talonclosedloop.add("left talon get", RobotModule.drivetrain.getLeftTalon()::get);
        talonclosedloop.add("right talon get", RobotModule.drivetrain.getRightTalon()::get);
        talonclosedloop.add("left talon speed", RobotModule.drivetrain.getLeftTalon()::getSpeed);
        talonclosedloop.add("right talon speed", RobotModule.drivetrain.getRightTalon()::getSpeed);
        talonclosedloop.add("left talon pos", RobotModule.drivetrain.getLeftTalon()::getPosition);
        talonclosedloop.add("right talon pos", RobotModule.drivetrain.getRightTalon()::getPosition);
        talonclosedloop.add("left talon encpos", RobotModule.drivetrain.getLeftTalon()::getEncPosition);
        talonclosedloop.add("right talon encpos", RobotModule.drivetrain.getRightTalon()::getEncPosition);
        talonclosedloop.add("left talon encvel", RobotModule.drivetrain.getLeftTalon()::getEncVelocity);
        talonclosedloop.add("right talon encvel", RobotModule.drivetrain.getRightTalon()::getEncVelocity);

        Heartbeat.add(skipped -> {
            if (Toast.getToast().isEnabled())
                talonclosedloop.tick();
        });
        
    }

}
