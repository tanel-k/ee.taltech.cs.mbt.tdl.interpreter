package ee.taltech.cs.mbt.tdl.commons.st_utils.generator;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class STRegistry {
	public static STRegistry fromGroupFilePath(String groupPath) {
		STGroup.verbose = false;
		STGroupFile groupFile = new STGroupFile(groupPath);
		return new STRegistry(groupFile);
	}

	public static class MissingSTException extends Exception {
		private MissingSTException(String groupName, String templateName) {
			super("Template group '" + groupName + "' does not contain template '" + templateName + "'.");
		}
	}

	private STGroup stGroup;
	private Map<String, ST> templateProtoMap = new HashMap<>();

	private STRegistry(STGroup stGroup) {
		if (stGroup == null || stGroup.getTemplateNames().isEmpty())
			throw new IllegalArgumentException("Expecting a non-empty STGroup instance.");
		this.stGroup = stGroup;
	}

	public ST getTemplate(String name) throws MissingSTException {
		Optional<ST> stOpt = getTemplateOptional(name);
		if (!stOpt.isPresent())
			throw new MissingSTException(stGroup.getName(), name);
		return stOpt.get();
	}

	public Optional<ST> getTemplateOptional(String name) {
		ST prototype = templateProtoMap.computeIfAbsent(name, n -> stGroup.getInstanceOf(n));
		if (prototype == null)
			return Optional.empty();
		return Optional.of(new ST(prototype));
	}

	public boolean hasTemplate(String name) {
		return stGroup.isDefined(name);
	}

	public String getGroupName() {
		return stGroup.getName();
	}

	public Set<String> getTemplateNames() {
		return stGroup.getTemplateNames();
	}
}
