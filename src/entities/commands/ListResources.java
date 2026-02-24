package entities.commands;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListResources extends Command {
	private Path parentPath;
	
	public ListResources(CommandHandler handler, Path parentPath) {
		super(handler);
		this.parentPath = parentPath;
	}

	@Override
	public boolean execute() {
		try {
			Files.walk(parentPath, 1, FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
