package entities.commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChangeDirectory extends Command {
	private Path path;
	
	public ChangeDirectory(CommandHandler handler, String pathForChange) {
		super(handler);
		path = Paths.get(pathForChange);
	}

	public boolean execute() {
		if (Files.notExists(path)) {
			System.out.printf("Specified path does not exist, returning to previous path.\n");
			return false;
		} else {
			getHandler().setCurrentDirectory(path);
		}
		
		return true;
	}
}
