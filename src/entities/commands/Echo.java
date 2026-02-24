package entities.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Echo extends Command{
	private Path path;
	private List<String> strings = new ArrayList<>();
	private Path parentPath;
	
	public Echo(CommandHandler handler, String[] args, Path parentPath) {
		super(handler);
		this.path = Paths.get(String.format("%s\\%s", parentPath.toString(), args[1]));
		strings.add(args[0]);
	}

	@Override
	public boolean execute() {
		try {
			Files.write(path, strings, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
}
