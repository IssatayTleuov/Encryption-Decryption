package com.company.cipher;

public class Alphabet extends Cryptography {
    @Override
    public void encrypt(char[] arr, int x) {
        char[] alpLowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alpUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < alpLowerCase.length; j++) {
                if (arr[i] == alpLowerCase[j]) {
                    int shift = j + x;
                    if (shift > alpLowerCase.length) {
                        arr[i] = alpLowerCase[shift - alpLowerCase.length];
                    } else if (shift < alpLowerCase.length) {
                        arr[i] = alpLowerCase[shift];
                    }
                    break;
                } else if (arr[i] == alpUpperCase[j]) {
                    int shift = j + x;
                    if (shift > alpUpperCase.length) {
                        arr[i] = alpUpperCase[shift - alpUpperCase.length];
                    } else if (shift < alpUpperCase.length) {
                        arr[i] = alpUpperCase[shift];
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void decrypt(char[] arr, int x) {
        char[] alpLowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alpUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < alpLowerCase.length; j++) {
                if (arr[i] == alpLowerCase[j]) {
                    int shift = j - x;
                    if (shift <= alpLowerCase.length && shift >= 0) {
                        arr[i] = alpLowerCase[shift];
                    } else if (shift < 0) {
                        arr[i] = alpLowerCase[alpLowerCase.length + shift];
                    }
                    break;
                } else if (arr[i] == alpUpperCase[j]) {
                    int shift = j - x;
                    if (shift <= alpUpperCase.length && shift >= 0) {
                        arr[i] = alpUpperCase[shift];
                    } else if (shift < 0) {
                        arr[i] = alpUpperCase[alpUpperCase.length + shift];
                    }
                    break;
                }
            }
        }
    }
}

