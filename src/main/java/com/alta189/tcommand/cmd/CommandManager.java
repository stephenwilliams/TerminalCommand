/*
 * Copyright (C) 2012 CyborgDev <cyborg@alta189.com>
 *
 * This file is part of TerminalCommand
 *
 * TerminalCommand is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TerminalCommand is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alta189.tcommand.cmd;

import com.alta189.tcommand.Named;
import com.alta189.tcommand.cmd.annotation.Injector;
import lombok.Getter;

public abstract class CommandManager {

	@Getter
	private final CommandMap commandMap = new CommandMap();
	
	public abstract void execute(CommandSource source, String raw) throws CommandException;
	
	public abstract void execute(CommandSource source, Command command, CommandContext context) throws CommandException;
	
	public abstract void registerCommand(Command command);
	
	public abstract void registerCommands(Named owner, Class<?> clazz, Injector injector);
	
}
