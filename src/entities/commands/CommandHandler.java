package entities.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.exceptions.QuotesException;

public class CommandHandler {
	private Scanner scanner;
	private Path currentDirectory;
	private Path history;
	
	public CommandHandler(Scanner scanner, Path currentDirectory, Path history) {
		this.scanner = scanner;
		this.currentDirectory = currentDirectory;
		this.history = history;
	}
	
	public void run() {
		while(true) {
			System.out.printf("@ %s |> ", currentDirectory.toString());
			String forHistory = scanner.nextLine();
			String[] nextCommand = forHistory.split("\\s+");
			
			ArgumentHandler args = new ArgumentHandler();
			
			for (int i = 1; i < nextCommand.length; i++) {
				args.addArgument(nextCommand[i]);
			}
			
			boolean executed = parse(nextCommand[0], args).execute();
			
			if (executed) {
				List<String> stringList = new ArrayList<>();
				stringList.add(forHistory);
				
				try {
					Files.write(history, stringList, StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setCurrentDirectory(Path path) {
		currentDirectory = path;
	}
	
	public Command parse(String commandName, ArgumentHandler args) {
		switch(commandName) {
		case "pwd":
			return new ShowCurrentDirectory(this, currentDirectory);
		case "ls":
			return new ListResources(this, currentDirectory);
		case "cd":
			try {
				return new ChangeDirectory(this, args.pathParse());
			} catch (QuotesException e) {
					System.out.printf(e.getMessage());
					return new NoOpCommand(this);
			}
		case "mkdir":
			return new MakeDirectory(this, args.pathParse(), currentDirectory);
		case "touch":
			return new CreateFile(this, args.pathParse(), currentDirectory);
		case "rm":
			return new Remove(this, args.pathParse(), currentDirectory);
		case "cat":
			return new Open(this, args.pathParse(), currentDirectory);
		case "echo":
			try {
				return new Echo(this, args.echoParse(), currentDirectory);
			} catch (QuotesException e) {
				System.out.printf(e.getMessage());
				return new NoOpCommand(this);
			}
		case "history":
			return new History(this, history);
		case "exit":
			return new Exit(this, history);
		default:
			System.out.printf("Error: command not found\n");
			return new NoOpCommand(this);
		}
	}
}
