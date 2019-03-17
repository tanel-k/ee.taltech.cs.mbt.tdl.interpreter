package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model;

import java.util.List;

public interface IHashableTreeNode<NodeType> {
	NodeType getParent();
	NodeType[] getChildren();
	int localHash();
}
