package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Main {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int countWordInstances(final String webpage, final String word) {
        int wordCount = 0;
        Scanner pageScanner = new Scanner(webpage);
        while (pageScanner.hasNextLine()) {
            String currentLine = pageScanner.nextLine();
            int index = currentLine.indexOf(word);
            while (index != -1) {
                wordCount++;
                currentLine = currentLine.substring(index + 1);
                index = currentLine.indexOf(word);
            }
        }
        return wordCount;
    }
    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(countWordInstances(urlToString("http://erdani.com/tdpl/hamlet.txt"), "bid"));
    }
}
