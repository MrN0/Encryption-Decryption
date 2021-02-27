package encryptdecrypt.encryptor;

public class Encryptor {
	private IEncryptor encryptor;

	public Encryptor(IEncryptor encryptor) {
		this.encryptor = encryptor;
	}

	public String encrypt(String text, int key) {
		return encryptor.encrypt(text, key);
	}

	public String decrypt(String text, int key) {
		return encryptor.decrypt(text, key);
	}
}
