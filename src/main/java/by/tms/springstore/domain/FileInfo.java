package by.tms.springstore.domain;

public class FileInfo {
    private String filename;
    private String filepath;

    public FileInfo(String filename, String filepath) {
        this.filename = filename;
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}