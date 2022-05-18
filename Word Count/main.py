import string

file = open("D:\gutenberg.txt", "r")

dictionary = dict()

for sentence in file:
    # Remove the leading spaces and newline character
    sentence = sentence.strip()

    sentence = sentence.lower()

    sentence = sentence.translate(sentence.maketrans("", "", string.punctuation))

    words = sentence.split(" ")

    for word in words:
        if word in dictionary:
            dictionary[word] = dictionary[word] + 1
        else:
            dictionary[word] = 1

for key in list(dictionary.keys()):
    print(key, ":", dictionary[key])
