package encryptdecrypt.argument;

class ModeArgument extends Argument {

	ModeArgument(String argument) {
		super(argument);
	}

	@Override
	String getArgument() throws Exception {
		if (this.argument == null) {
			return "enc";
		} else if (this.argument.matches("enc|dec")) {
			return this.argument;
		} else {
			throw new Exception("There is no mode for the mode argument");
		}
	}

}
