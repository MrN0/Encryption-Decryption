package encryptdecrypt.encryptor;

public class ShiftingEncryptor extends AbstractEncryptor {

	public ShiftingEncryptor() {
		// number of characters in the English alphabet
		this.characters = 26;
	}

	@Override
	public String encrypt(String text, int key) {
		key = transformKey(this.characters, key);

		StringBuilder sb = new StringBuilder();
		for (char ch : text.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				int firstLetter = Character.isUpperCase(ch) ? 'A' : 'a';
				sb.append((char) ((ch - firstLetter + key) % this.characters + firstLetter));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
