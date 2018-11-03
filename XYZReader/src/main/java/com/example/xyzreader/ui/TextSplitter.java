package com.example.xyzreader.ui;

public class TextSplitter {
    private TextSplitter() { }

    public static String[] split_text(String articleBodyFromCursor) {

        final String TAG = TextSplitter.class.getSimpleName();
        String[] splitParagraph = articleBodyFromCursor.split("\r\n\r\n");
        for(int i = 0; i < splitParagraph.length; i++) {
            splitParagraph[i] = organizeString(splitParagraph[i]);
        }
        return splitParagraph;
    }

    private static String organizeString (String string) {
        string = string.replace("\r\n", " ");
        return string.trim();
    }
}
