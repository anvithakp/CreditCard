package parser;

import org.apache.commons.io.FilenameUtils;

public class ParserFactory {

    public static Parser getParser(String inputFile, String outPutFile) throws Exception {

        String extension = FilenameUtils.getExtension(inputFile);

        if (extension == null || extension.isEmpty())
            throw new Exception("Invalid file format");

        switch (extension.toLowerCase()) {
            case "json" :
                return new JsonParser(inputFile, outPutFile);
            case "xml" :
                return new XmlParser(inputFile, outPutFile);
            case "csv" :
                return new CsvParser(inputFile, outPutFile);
            default:
                throw new Exception("Invalid file format");
        }

    }
}
