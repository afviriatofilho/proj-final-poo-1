package entities.commands;

import java.nio.file.Path;

import entities.FileManager;

public class Open extends Command {
	private FileManager fileManager = new FileManager();
	private String name;
	private Path parentPath;
	
	public Open(CommandHandler handler, String name, Path parentPath) {
		super(handler);
		this.name = name;
		this.parentPath = parentPath;
	}

	@Override
	public boolean execute() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%s\\%s", parentPath.toString(), name));
		
		if (fileManager.open(sb.toString())) {
			return true;
		} else {
			return false;
		}
	}
}
