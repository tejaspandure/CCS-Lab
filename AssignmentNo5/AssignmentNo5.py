import hashlib

msg = input("Enter the message: ").encode()

md5_hash = hashlib.md5(msg).hexdigest()
sha1_hash = hashlib.sha1(msg).hexdigest()

print("\nMD5: ",md5_hash)
print("\nsha1: ",sha1_hash)

