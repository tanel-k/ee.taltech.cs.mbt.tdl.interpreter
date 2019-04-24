import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.Map;

public class TestPropertyFile {
    public static class PropertyFileLoader extends PropertyFileBaseVisitor<Void> {
        Map<String,String> props = new OrderedHashMap<String, String>();
        @Override
        public Void visitProp(PropertyFileParser.PropContext ctx) {
            String id = ctx.ID().getText();
            String value = ctx.STRING().getText();
            props.put(id, value);
            return null;
        }
    }

    public static void main(String... args) throws Exception {
        String inputFile = null;

        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }

        ANTLRInputStream input = new ANTLRInputStream(is);
        PropertyFileLexer lexer = new PropertyFileLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PropertyFileParser parser = new PropertyFileParser(tokens);
        ParseTree tree = parser.file();

        PropertyFileLoader loader = new PropertyFileLoader();
        loader.visit(tree);
        System.out.println(loader.props);
    }
}