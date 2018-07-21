package main;

import view.interfaces.ICommand;

public class Command implements ICommand {

	Command command;
	public Command(Command x) {
		this.command = x;
	}
	@Override
	public void run() {
		command.run();
	}
	
	public void undo() {
		
	}
	
	public void redo() {
		
	}

}
