package com.frc2879.knight_fury.util;

import jaci.openrio.toast.core.command.AbstractCommand;
import jaci.openrio.toast.core.command.IHelpable;

public abstract class HelpableAbstractCommand extends AbstractCommand implements IHelpable {

    @Override
    public abstract String getHelp();

    @Override
    public abstract String getCommandName();

    @Override
    public abstract void invokeCommand(int argLength, String[] args, String command);

}
