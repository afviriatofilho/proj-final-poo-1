package entities.commands;

public class NoOpCommand extends Command{
	public NoOpCommand(CommandHandler handler) {
		super(handler);
	}

	@Override
	public boolean execute() {
		return true;
	}
}
