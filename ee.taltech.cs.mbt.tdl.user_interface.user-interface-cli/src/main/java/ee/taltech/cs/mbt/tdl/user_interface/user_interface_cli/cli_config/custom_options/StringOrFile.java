package ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.cli_config.custom_options;

import ee.taltech.cs.mbt.tdl.commons.utils.files.FileUtils;

import java.io.File;
import java.util.Optional;

public class StringOrFile {
	private String string;

	public StringOrFile(String string) {
		this.string = string;
	}

	public Optional<File> getFile() {
		if (FileUtils.isFilePathString(string))
			return Optional.of(new File(string));
		return Optional.empty();
	}

	public String getString() {
		return string;
	}
}
