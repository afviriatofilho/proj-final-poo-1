package entities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryManager extends Manager {
	public boolean create(String path1, String... pathN) {
		Path path = Paths.get(path1, pathN);
		
		try {
			Files.createDirectories(path);
			return true;
		} catch (IOException e) {
			StringBuilder sb = new StringBuilder();
			sb.append(path1);
			
			for (String s : pathN) {
				sb.append(s);
			}
			
			System.out.printf("Error creating directory %s:\n", sb.toString());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(String pathAsString) {
		Path path = Paths.get(pathAsString);
		
		try {
			Files.deleteIfExists(path);
			return true;
		} catch (IOException e) {
			System.out.printf("Error deleting file or directory %s:\n", pathAsString);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean open(String pathAsString) {
		return true;
	}
}
