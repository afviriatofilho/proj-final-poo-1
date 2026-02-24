package entities.commands;

import java.nio.file.Path;

import entities.FileManager;

public class Exit extends Command{
	private Path history;
	private FileManager fileManager = new FileManager();
	
	public Exit(CommandHandler handler, Path history) {
		super(handler);
		this.history = history;
	}
	
	public boolean execute() {
		String historyPath = history.toString();
		
		fileManager.delete(historyPath);
		
		System.exit(0);
		return true;
	}
}
