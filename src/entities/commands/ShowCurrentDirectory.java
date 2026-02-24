package entities.commands;

import java.nio.file.Path;

public class ShowCurrentDirectory extends Command {
	private Path currentPath;
	
	public ShowCurrentDirectory(CommandHandler handler, Path currentPath) {
		super(handler);
		this.currentPath = currentPath;
	}
	
	public boolean execute() {
		System.out.printf("Current directory is: %s\n", currentPath);
		return true;
	}
}
