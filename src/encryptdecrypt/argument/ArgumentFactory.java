package encryptdecrypt.argument;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ArgumentFactory {
	private final Map<ArgumentType, String> args;

	public ArgumentFactory(String[] args) throws Exception {
		this.args = extractArguments(args);
	}

	public String get(ArgumentType argument) throws Exception {
		switch (argument) {
		case ALGORITHM:
			Argument algorithm = new AlgorithmArgument(args.get(argument));
			return algorithm.getArgument();
		case MODE:
			Argument mode = new ModeArgument(args.get(argument));
			return mode.getArgument();
		case DATA:
			Argument data = new DataArgument(args.get(argument));
			return data.getArgument();
		case KEY:
			Argument key = new KeyArgument(args.get(argument));
			return key.getArgument();
		case IN:
			Argument in = new InArgument(args.get(argument));
			return in.getArgument();
		case OUT:
			Argument out = new OutArgument(args.get(argument));
			return out.getArgument();
		default:
			return "";
		}
	}

	private Map<ArgumentType, String> extractArguments(String[] args) throws Exception {
		Map<ArgumentType, String> arguments = new HashMap<>();

		String argumentKeys = createRegexWithArgumentKeys();
		Pattern pattern = Pattern.compile(argumentKeys);

		int i = 0;
		while (i < args.length) {
			if (pattern.matcher(args[i]).matches()) {
				if (i + 1 < args.length) {
					ArgumentType argument = ArgumentType.getArgumentByKey(args[i]);
					arguments.put(argument, args[i + 1]);
					i += 2;
				} else {
					throw new Exception("There is no argument for the '" + args[i] + "' key");
				}
			} else {
				throw new Exception(args[i] + " - key doesn't exist");
			}
		}
		return arguments;
	}

	private String createRegexWithArgumentKeys() {
		StringBuilder sb = new StringBuilder();
		for (ArgumentType argument : ArgumentType.values()) {
			sb.append(argument.getKey()).append("|");
		}

		if (sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
