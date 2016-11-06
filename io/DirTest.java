package io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.stream.Stream;

import static java.nio.file.Files.newDirectoryStream;

public class DirTest {
  public static void main(String[] args) throws IOException {
    Stream.of(FileSystems.getDefault().
        getRootDirectories()).forEach(dir -> System.out.println(dir));
    Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxr-x---");
    FileAttribute< Set<PosixFilePermission> > attrs = PosixFilePermissions.asFileAttribute(permissions);

//    Files.createDirectory(Paths.get("./log"), attrs);

    DirectoryStream.Filter filter = path -> Files.isDirectory((Path)path);
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("../springtest"), filter)) {
      directoryStream.forEach(file -> System.out.println(file.getFileName()));
    }

    Files.createSymbolicLink(Paths.get("link"), Paths.get("newFile"));
  }
}
