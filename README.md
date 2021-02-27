# Encryption-Decryption
Privacy is an important matter is the realm of the Internet. When sending a message, you want to be sure that no-one but the addressee with the key can read it. The entirety of the modern Web is encrypted - take https for example! Don’t stay behind: hop on the encryption/decryption train and learn the essential basics while implementing this simple project.

## Table of Contents
* [About this program](#about-this-program)
* [Technologies](#technologies)
* [Program Description](#program-description)
* [Example](#example)

## About this program
This project is a solution to the problem of JetBrains Academy - "Encryption-Decryption".

This program works with command-line arguments. The order of the arguments might be different. Note that to pass an argument that contains spaces as a single argument you need to put it in quotes. So `"Welcome to hyperskill!" `becomes a single `Welcome to hyperskill!`

This program uses two different algorithms to encode/decode data. The first one is the shifting algorithm (it shifts each letter by the specified number according to its order in the alphabet in circle). The second one is based on the Unicode table.
## Technologies
- JDK 8

## Program Description
**The program parses such arguments:**
| Argument | Description |
|----------|-------------|
|**-alg**  | the algorithm to encode/decode data (**shift** or **unicode**). |
|**-mode** | determine the program’s mode (**enc** for encryption, **dec** for decryption). |
|**-key**  | an integer key to modify the message. |
|**-data** | a text or ciphertext to encrypt or decrypt. |
|**-in**   | the full name of a file to read data. |
|**-out**  | the full name of a file to write the result. |

**Program rules:**
1. If there is no **-alg** then the **shift** algorithm is used.
2. If there is no **-mode**, the program works in **enc** mode.
3. If there is no **-key**, the program considers that **key** = **0**.
4. If there is no **-data**, and there is no **-in** the program assumes that the data is an empty string.
5. If there is no **-out** argument, the program prints data to the standard output.
6. If there are both **-data** and **-in** arguments, program prefers **-data** over **-in**.

## Example
**Example 1**

```no-highlight
java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode
```

This command must get data from the file  **road_to_treasure.txt**, encrypt the data with the key 5, create a file called  **protected.txt**  and write ciphertext to it.

**Example 2**

Input:

```no-highlight
java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
```

Output:

```
\jqhtrj%yt%m~ujwxpnqq&
```

**Example 3**

Input:

```no-highlight
java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
```

Output:

```
Welcome to hyperskill!
```

**Example 4:**

Input:

```no-highlight
java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc
```

Output:

```no-highlight
Bjqhtrj yt mdujwxpnqq!
```

**Example 5:**

Input:

```no-highlight
java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec
```

Output:

```no-highlight
Welcome to hyperskill!
```
