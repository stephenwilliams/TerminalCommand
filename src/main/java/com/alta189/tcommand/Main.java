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

package com.alta189.tcommand;

import com.alta189.tcommand.cmd.CommandManager;
import com.alta189.tcommand.cmd.annotation.EmptyConstructorInjector;
import com.alta189.tcommand.cmd.annotation.SimpleInjector;
import com.alta189.tcommand.test.AnnotatedCommandsTest;
import com.alta189.tcommand.test.Owner;
import com.alta189.tcommand.test.TestCommandExectutor;
import lombok.Getter;

public class Main {

	@Getter
	private static CommandManager commandManager = new CommonCommandManager();

	public static void main(String[] args) {
		TestCommandExectutor testCommandExectutor = new TestCommandExectutor();
		commandManager.registerCommand(testCommandExectutor.getTestCommand());
		commandManager.registerCommand(testCommandExectutor.getSecondCommand());
		commandManager.registerCommands(new Owner(AnnotatedCommandsTest.class.getCanonicalName()),AnnotatedCommandsTest.class, new EmptyConstructorInjector());
		new TerminalThread().start();
	}
	


}
