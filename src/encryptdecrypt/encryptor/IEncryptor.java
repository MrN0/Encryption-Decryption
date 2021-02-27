package encryptdecrypt.encryptor;

public interface IEncryptor {

    String encrypt(String text, int key);

    String decrypt(String text, int key);

}
