package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import entities.commands.CommandHandler;

public class Terminal {
	public static void main(String[] args) throws IOException {
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		Path history = Files.createFile(Paths.get(String.format("%s\\history.dat", System.getProperty("user.dir"))));
		CommandHandler handler = new CommandHandler(new Scanner(System.in), currentPath, history);
		
		handler.run();
	}
}
