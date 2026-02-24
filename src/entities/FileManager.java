package entities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager extends Manager {
	public FileManager() {
	}
	
	@Override
	public boolean create(String path1, String... pathN) {
		Path path = Paths.get(path1, pathN);
		
		try {
			Files.createFile(path);
			return true;
		} catch (Throwable e) {
			StringBuilder sb = new StringBuilder();
			sb.append(path1);
			
			for (String s : pathN) {
				sb.append("\\");
				sb.append(s);
			}
			
			System.out.printf("Error creating file %s:\n", sb.toString());
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
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
	
	@Override
	public boolean open(String pathAsString) {
		Path path = Path.of(pathAsString);
		File file = path.toFile();
		
		try {
			Desktop.getDesktop().open(file);
			return true;
		} catch (IOException e) {
			System.out.printf("Error opening file %s:\n", pathAsString);
			e.printStackTrace();
			return false;
		}
	}
}
