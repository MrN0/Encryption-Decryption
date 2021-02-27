package encryptdecrypt.argument;

class KeyArgument extends Argument {

	KeyArgument(String argument) {
		super(argument);
	}

	@Override
	String getArgument() throws Exception {
		if (this.argument == null) {
			return "0";
		} else if (this.argument.matches("\\d+")) {
			return this.argument;
		} else {
			throw new Exception("There is no mode for the mode argument");
		}
	}

}
