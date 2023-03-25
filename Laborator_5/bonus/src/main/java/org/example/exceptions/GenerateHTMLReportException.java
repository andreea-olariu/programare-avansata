package org.example.exceptions;

public class GenerateHTMLReportException extends Exception{
    public GenerateHTMLReportException() {
        super("Problem at generating the HTML report for the catalog.");
    }
}
