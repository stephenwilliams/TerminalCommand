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

package com.alta189.tcommand.test;

import com.alta189.tcommand.cmd.Command;
import com.alta189.tcommand.cmd.CommandContext;
import com.alta189.tcommand.cmd.CommandException;
import com.alta189.tcommand.cmd.CommandExecutor;
import com.alta189.tcommand.cmd.CommandSource;
import lombok.Getter;

public class TestCommandExectutor implements CommandExecutor {

	@Getter
	private Command testCommand;
	@Getter
	private Command secondCommand;
	
	public TestCommandExectutor() {
		testCommand = new Command(new Owner(TestCommandExectutor.class.getCanonicalName()), "test");
		testCommand.setDesc("A lovely description!");
		testCommand.setExecutor(this);
		testCommand.getAliases().add("t");
		testCommand.getAliases().add("tt");
		secondCommand = new Command(new Owner(TestCommandExectutor.class.getCanonicalName()), "tt");
	    secondCommand.setDesc("A wonderful work!");
		secondCommand.setExecutor(this);
	}

	@Override
	public boolean processCommand(CommandSource source, Command command, CommandContext context) throws CommandException {
		System.out.println("Recieved command!");
		System.out.println("Command: " + command.getCommand());
		System.out.println("Description: " + command.getDesc());
		
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String alias : command.getAliases()) {
			if (first) {
				first = false;
			} else {
				builder.append(", ");
			}
			builder.append(alias);
		}
		System.out.println("Aliases: " + builder.toString());

		if (context.getArgs() != null) {
			StringBuilder args = new StringBuilder();
			first = true;
			for (String arg : context.getArgs()) {
				if (first) {
					first = false;
				} else {
					args.append(", ");
				}
				args.append(arg);
			}

			System.out.println("Args: " + args.toString());
		}
		
		return false;
	}
}
