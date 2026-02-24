package entities.commands;

import java.nio.file.Path;

import entities.FileManager;

public class CreateFile extends Command {
	private String pathAsString;
	private Path parentPath;
	private FileManager fileManager = new FileManager();
	
	public CreateFile(CommandHandler handler, String pathAsString, Path parentPath) {
		super(handler);
		this.pathAsString = pathAsString;
		this.parentPath = parentPath;
	}

	@Override
	public boolean execute() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%s\\%s", parentPath.toString(), pathAsString));
		
		if (fileManager.create(sb.toString()) == true) {
			return true;
		} else {
			return false;
		}
	}
}