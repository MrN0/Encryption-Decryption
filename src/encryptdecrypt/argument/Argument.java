package encryptdecrypt.argument;

abstract class Argument {
	protected final String argument;

	Argument(String argument) {
		this.argument = argument;
	}

	String getArgument() throws Exception {
		return argument == null ? "" : argument;
	}

}
