from Crypto.Cipher import DES
from secrets import token_bytes

key = token_bytes(8)

cipher = DES.new(key, DES.MODE_EAX)

message =input("Enter the Messge: ").encode()

nonce = cipher.nonce

ciphertext = cipher.encrypt(message)
print("Message is: ", ciphertext)

cipher = DES.new(key, DES.MODE_EAX, nonce=nonce)

plaintext = cipher.decrypt(ciphertext)
print("Plain text : ",plaintext)

