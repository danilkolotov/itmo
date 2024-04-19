package md2html;

import java.util.Scanner;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Md2Html {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(
                new InputStreamReader(
                        new FileInputStream(args[0]),
                        StandardCharsets.UTF_8
                )
        );
        StringBuilder result = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        while (scanner.hasNext()) {
            StringBuilder currentParagraph = new StringBuilder();
            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                if (currentLine.equals(lineSeparator)) break;
                currentParagraph.append(currentLine);
                currentParagraph.append(lineSeparator);
            }
            if (currentParagraph.isEmpty()) {
                continue;
            }
            currentParagraph.setLength(currentParagraph.length() - lineSeparator.length());
            result.append(MarkdownParser.parseParagraph(currentParagraph.toString()));
        }
        scanner.close();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(args[1]),
                        StandardCharsets.UTF_8
                )
        );
        writer.write(result.toString());
        writer.close();
    }
}