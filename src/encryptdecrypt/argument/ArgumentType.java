package encryptdecrypt.argument;

public enum ArgumentType {
	ALGORITHM("-alg"),
	MODE("-mode"),
	KEY("-key"),
	DATA("-data"),
	IN("-in"),
	OUT("-out");

	private String key;

	ArgumentType(String key) {
		this.key = key;
	}

	public String getKey() {
		return this.key;
	}

	public static ArgumentType getArgumentByKey(String key) {
		for (ArgumentType argument : ArgumentType.values()) {
			if (argument.getKey().equals(key)) {
				return argument;
			}
		}
		return null;
	}
}
