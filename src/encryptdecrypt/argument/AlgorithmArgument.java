package encryptdecrypt.argument;

class AlgorithmArgument extends Argument {

	AlgorithmArgument(String argument) {
		super(argument);
	}

	@Override
	String getArgument() throws Exception {
		if (this.argument == null) {
			return "shift";
		} else if (this.argument.matches("shift|unicode")) {
			return this.argument;
		} else {
			throw new Exception("There is no algorithm for the algorithm argument");
		}
	}

}
