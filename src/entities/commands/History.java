package entities.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class History extends Command {
	private Path file;
	
	public History(CommandHandler handler, Path file) {
		super(handler);
		this.file = file;
	}
	
	public boolean execute() {
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(file);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		for (String s : lines) {
			System.out.printf("%s\n", s);
		}
		
		return true;
	}
}
