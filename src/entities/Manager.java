package entities;

public abstract class Manager {
	public abstract boolean create(String path1, String... pathN);
	public abstract boolean delete(String pathAsString);
	public abstract boolean open(String pathAsString);
}
