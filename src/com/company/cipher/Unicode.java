package com.company.cipher;

public class Unicode extends Cryptography {
    @Override
    public void encrypt(char[] arr, int x) {
        char[] unicode = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < unicode.length; j++) {
                if (arr[i] == unicode[j]) {
                    int a = j + x;
                    if (a < unicode.length) {
                        arr[i] = unicode[a];
                    } else if (a > unicode.length) {
                        arr[i] = unicode[a - unicode.length];
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void decrypt(char[] arr, int x) {
        char[] unicode = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < unicode.length; j++) {
                if (arr[i] == unicode[j]) {
                    int a = j - x;
                    if (a <= unicode.length && a >= 0) {
                        arr[i] = unicode[a];
                    } else if (a < 0) {
                        arr[i] = unicode[unicode.length + a];
                    }
                    break;
                }
            }
        }
    }
}


