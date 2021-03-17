package com.tyma.demo.readSequence;

import java.io.*;
//methods in c language from estebanpw, ortrelles
//https://github.com/estebanpw/TYMA-2021/

public class ReadFasta {
    public static void CompareSequence(String first,String second) {
        try {
            File file = new File("matrix.txt");
            if (file.exists()){
                file.delete();
            }
            FileWriter myWriter = new FileWriter(file);
            for(int i=0;i<first.length();i++) {
                for(int j=0;j<second.length();j++) {
                    if(first.charAt(i)==second.charAt(j)) {
                        myWriter.write("1");
                    }
                    else {
                        myWriter.write("0");
                    }
                    if(j<second.length()-1) {
                        myWriter.write(" ");
                    }
                    else {
                        myWriter.write("\n");
                    }
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void CompareSequenceThresh(String first,String second,int w, int t) {
        try {
            FileWriter myWriter = new FileWriter("matrix.txt");
            int score;
            for(int i=0;i<first.length();i++) {
                for(int j=0;j<second.length();j++) {
                    score =0;
                    for(int k=0;k<w;k++) {
                        if((j+k)<second.length() && (i+k) <first.length() && first.charAt(i+k)==second.charAt(j+k)  )
                            score++;
                    }

                    if(score>=t) {
                        myWriter.write("1");
                    }
                    else {
                        myWriter.write("0");
                    }
                    if(j<second.length()-1) {
                        myWriter.write(" ");
                    }
                    else {
                        myWriter.write("\n");
                    }
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
