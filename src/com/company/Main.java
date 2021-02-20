package com.company;

import com.company.cipher.Alphabet;
import com.company.cipher.Unicode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String filePath = "C:\\Users\\issat\\Desktop\\road_to_treasure.txt";
        //String filePath = "C:\\Users\\issat\\Desktop\\protected.txt";
        String mode = "enc";
        String alg = "shift";
        String data = null;
        String in = null;
        String out = null;
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-in")) {
                in = "C:\\Users\\issat\\Desktop\\road_to_treasure.txt";
            } else if (args[i].equals("-out")) {
                out = "C:\\Users\\issat\\Desktop\\protected.txt";
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }
        char[] array = setDataToArray(data, in);
        setCryptMode(array, mode, alg, key);
        printResult(array, out);
    }

    public static char[] setDataToArray(String data, String in) {
        char[] arr = null;
        if (data != null && in != null) {
            arr = data.toCharArray();
        } else if (data != null) {
            arr = data.toCharArray();
        } else {
            File file = new File(in);
            try (Scanner scanner = new Scanner(file)) {
                String input = scanner.nextLine();
                arr = input.toCharArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
    public static void setCryptMode(char[] array, String mode, String alg, int key) {

        if (mode.equals("enc") && alg.equals("unicode")) {
            Unicode unicode = new Unicode();
            unicode.encrypt(array, key);
        } else if (mode.equals("dec") && alg.equals("unicode")) {
            Unicode unicode = new Unicode();
            unicode.decrypt(array, key);
        } else if (mode.equals("enc") && alg.equals("shift")) {
            Alphabet alphabet = new Alphabet();
            alphabet.encrypt(array, key);
        } else if (mode.equals("dec") && alg.equals("shift")) {
            Alphabet alphabet = new Alphabet();
            alphabet.decrypt(array, key);
        }
    }

    public static void printResult(char[] array, String out) {
        if (out == null) {
            for (char a : array) {
                System.out.print(a);
            }
        } else {
            String output = String.valueOf(array);
            try (FileWriter fileWriter = new FileWriter(out)) {
                fileWriter.write(output);
            } catch (IOException e) {
                System.out.println("Exception:" + e.getClass().getName());
            }
        }
    }
}


