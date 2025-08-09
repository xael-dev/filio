package models;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

public class FileItem {
    private final String name;
    private final Path path;
    private final long size;
    private final String extension;
    private final Instant lastModified;

    // Constructor
    public FileItem(Path path, BasicFileAttributes attrs) {
        this.name = path.getFileName().toString();
        this.path = path;
        this.size = attrs.size();
        this.extension = extractExtension(name);
        this.lastModified = attrs.lastModifiedTime().toInstant();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public String getExtension() {
        return extension;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    // Helper methods
    private String extractExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot > 0 && lastDot < filename.length() - 1) {
            return filename.substring(lastDot + 1).toLowerCase();
        } else {
            return "";
        }
    }

    public boolean isImage() {
        return extension.matches("(?i)jpg|jpeg|png|gif|bmp|webp");
    }

    public boolean isOld(long thresholdDays) {
        Instant now = Instant.now();
        return lastModified.isBefore(now.minusSeconds(thresholdDays * 86400));
    }

    @Override
    public String toString() {
        return String.format("FileItem{name='%s', path='%s', size=%d, extension='%s'}",
                name, path, size, extension);
    }
}
