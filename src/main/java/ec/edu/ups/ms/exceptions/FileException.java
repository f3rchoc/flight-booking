package ec.edu.ups.ms.exceptions;

public class FileException extends RuntimeException {

    private final String fileName;

    public FileException(String message, Throwable cause, String fileName) {
        super(message, cause);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
