package ee.taltech.cs.mbt.tdl.commons.utils.files;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collections;
import java.util.Set;

public class FileUtils {
	public static final Set<PosixFilePermission> POSIX_READ_ONLY_PERMS = Collections.unmodifiableSet(CollectionUtils.newSet(
			PosixFilePermission.OTHERS_READ,
			PosixFilePermission.OTHERS_EXECUTE,
			PosixFilePermission.OWNER_WRITE
	));

	public static final Set<PosixFilePermission> POSIX_WRITE_PERMS = Collections.unmodifiableSet(CollectionUtils.newSet(
			PosixFilePermission.OTHERS_READ,
			PosixFilePermission.OTHERS_EXECUTE,
			PosixFilePermission.OTHERS_WRITE
	));

	public static boolean isFilePathString(String str) {
		try {
			Paths.get(str);
		} catch (InvalidPathException | NullPointerException ex) {
			return false;
		}
		return true;
	}

	public static void setReadOnly(Path filePath, boolean readOnly) throws IOException {
		FileStore fileStore = Files.getFileStore(filePath);

		if (fileStore.supportsFileAttributeView(DosFileAttributeView.class)) {
			DosFileAttributeView dosView = Files.getFileAttributeView(filePath, DosFileAttributeView.class);
			dosView.setReadOnly(readOnly);
		} else if (fileStore.supportsFileAttributeView(PosixFileAttributeView.class)) {
			PosixFileAttributeView posixView = Files.getFileAttributeView(filePath, PosixFileAttributeView.class);
			posixView.setPermissions(readOnly ? POSIX_READ_ONLY_PERMS : POSIX_WRITE_PERMS);
		}
	}
}
