package com.pulkit.DsAlgo;

public class ContactAppViaTrie {
    public static void main(String[] args) {
        TrieNode rootNode = new TrieNode();
        rootNode.value = '.';
        rootNode.isLeaf = false;

        //Another Test case
        String pulkitb = "pulkitb";

        //Another Test case
        String pulkita = "pulkita";

        addContact(pulkitb, rootNode, 0, pulkitb.length(), "9711253132");
        addContact(pulkita, rootNode, 0, pulkita.length(), "8802491779");
    }

    private static void addContact(String name, TrieNode rootNode, int index, int size,
                                   String phoneNumber) {
        if (rootNode == null)
            return;

        else {
            if (index < size) {
                Character characterValue = name.charAt(index);
                int alphabeticSequenceValueOfCharacter = characterValue - 'a';

                if (rootNode.alphabets[alphabeticSequenceValueOfCharacter] == null) {
                    TrieNode trieNode = new TrieNode();
                    trieNode.value = characterValue;
                    rootNode.alphabets[alphabeticSequenceValueOfCharacter] = trieNode;

                    if (index == size - 1) {
                        trieNode.isLeaf = true;
                        trieNode.phoneNumber = phoneNumber;
                    } else {
                        trieNode.isLeaf = false;
                    }
                }

                index++;

                addContact(name,
                        rootNode.alphabets[alphabeticSequenceValueOfCharacter],
                        index, size, phoneNumber);
            }
        }
    }
}


class TrieNode {
    Boolean isLeaf;
    String phoneNumber;
    Character value;
    TrieNode[] alphabets = new TrieNode[26];
}