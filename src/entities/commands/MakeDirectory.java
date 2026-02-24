package entities.commands;

import java.nio.file.Path;
import java.util.regex.Pattern;

import entities.DirectoryManager;

public class MakeDirectory extends Command{
	private String pathAsString;
	private Path parentPath;
	private DirectoryManager directoryManager = new DirectoryManager();
	
	public MakeDirectory(CommandHandler handler, String pathAsString, Path parentPath) {
		super(handler);
		this.pathAsString = pathAsString;
		this.parentPath = parentPath;
	}

	@Override
	public boolean execute() {
		StringBuilder sb = new StringBuilder();
		
		if (Pattern.matches(".*[B-Z]+:.*", pathAsString)) {
			sb.append(pathAsString);
		} else {
			sb.append(String.format("%s\\%s", parentPath.toString(), pathAsString));
		}
		
		if (directoryManager.create(sb.toString()) == true) {
			return true;
		} else {
			return false;
		}
	}
}
