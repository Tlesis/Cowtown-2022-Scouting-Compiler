package org.usd232.robotics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompilerMain {

    public static void main(String args[]) {
        try {
            List<String> filePaths = getFiles(args[0]);
            for (int i = 0; i < filePaths.size(); i++) {
                Reader csv = new Reader(filePaths.get(i));
                Write.fileWriter(System.getProperty("user.home") + "/Desktop/compiled.csv", csv.getList(), (i == 0) ? true : false);
            }

            /* new Reader("/Users/sjw00237/Desktop/compiled.csv").print(); */

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<String> getFiles(String path) throws Exception {
            Stream<Path> walk = Files.walk(Paths.get(path), 1);
            List<String> result = walk
                    .filter(p -> !Files.isDirectory(p))   // not a directory
                    .map(p -> p.toString().toLowerCase()) // convert path to string
                    .filter(f -> f.endsWith("csv"))       // check end with
                    .collect(Collectors.toList());        // collect all matched to a List
            walk.close();

            return result;
    }
}
