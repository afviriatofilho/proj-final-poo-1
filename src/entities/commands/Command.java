package entities.commands;

public abstract class Command {
	private CommandHandler handler;
	
	public Command(CommandHandler handler) {
		this.handler = handler;
	}

	public CommandHandler getHandler() {
		return handler;
	}
	
	public abstract boolean execute();
}