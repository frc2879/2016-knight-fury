package com.frc2879.knight_fury;

import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public class RobotModule extends IterativeModule {

    public static Logger logger;

    @Override
    public String getModuleName() {
        return "2016-knight-fury";
    }

    @Override
    public String getModuleVersion() {
        return "0.0.1";
    }

    @Override
    public void robotInit() {
        logger = new Logger("2016-knight-fury", Logger.ATTR_DEFAULT);
        //TODO: Module Init
    }
}
