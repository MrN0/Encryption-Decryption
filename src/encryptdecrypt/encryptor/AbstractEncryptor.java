package encryptdecrypt.encryptor;

abstract class AbstractEncryptor implements IEncryptor {
	protected int characters;

	@Override
	public String decrypt(String text, int key) {
		key = transformKey(characters, key);
		// shift back 'n' times - the same as shift forward (characters - 'n') times
		return encrypt(text, characters - key);
	}

	protected int transformKey(int step, int key) {
		return key < 0 ? step - (Math.abs(key) % step) : key % step;
	}
}
