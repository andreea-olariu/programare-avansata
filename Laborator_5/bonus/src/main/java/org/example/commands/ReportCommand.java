package org.example.commands;

import freemarker.core.ParseException;
import freemarker.template.*;
import org.example.models.Catalog;
import org.example.exceptions.GenerateHTMLReportException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class ReportCommand extends Command {

    ReportCommand() {
        super(1);
    }

    @Override
    public String getHelp() {
        return "Get a HTML report about the catalog.\n";
    }

    public static void action(Catalog catalog) throws GenerateHTMLReportException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        try {
            cfg.setDirectoryForTemplateLoading(new File("./src/templates"));
        } catch (IOException e) {
            throw new GenerateHTMLReportException();
        }

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("documents", catalog.getDocuments());

        Writer fileWriter = null;
        try {
            Template template = cfg.getTemplate("index.ftl");
            fileWriter = new FileWriter(new File("output.html"));
            template.process(input, fileWriter);
            fileWriter.close();
        } catch (TemplateException | IOException e) {
            throw new GenerateHTMLReportException();
        }
    }
}
