package encryptdecrypt.encryptor;

public class UnicodeEncryptor extends AbstractEncryptor {

	public UnicodeEncryptor() {
		// number of printing characters in the ASCII table (from 32 to 126)
		this.characters = 95;
	}

	@Override
	public String encrypt(String text, int key) {
		key = transformKey(this.characters, key);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = (char) ((text.charAt(i) - ' ' + key) % this.characters + ' ');
			sb.append(c);
		}
		return sb.toString();
	}

}
