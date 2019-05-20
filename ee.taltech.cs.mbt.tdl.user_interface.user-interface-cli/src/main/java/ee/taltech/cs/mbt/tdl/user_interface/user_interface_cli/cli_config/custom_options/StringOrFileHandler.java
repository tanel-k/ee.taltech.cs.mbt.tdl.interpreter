package ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli.cli_config.custom_options;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OneArgumentOptionHandler;
import org.kohsuke.args4j.spi.Setter;

public class StringOrFileHandler extends OneArgumentOptionHandler<StringOrFile> {
	public StringOrFileHandler(CmdLineParser parser, OptionDef option, Setter<? super StringOrFile> setter) {
		super(parser, option, setter);
	}

	@Override
	protected StringOrFile parse(String s) {
		return new StringOrFile(s);
	}
}
