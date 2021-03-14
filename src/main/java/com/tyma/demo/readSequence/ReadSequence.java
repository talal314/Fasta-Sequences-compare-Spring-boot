package com.tyma.demo.readSequence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadSequence {
    static String line ;
    static boolean first;

    public static String SecuenciaA(String fileName) throws FileNotFoundException {
        first=true;

        Scanner sc = new Scanner(new File(fileName));
        StringBuilder Sequence = new StringBuilder();
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if (line.trim().length() > 0) {
                if (line.charAt(0) == '>') {
                    if (first)
                        first = false;

                } else {
                    Sequence.append(line);

                }
            }
        }
        return Sequence.toString();


    }


}
