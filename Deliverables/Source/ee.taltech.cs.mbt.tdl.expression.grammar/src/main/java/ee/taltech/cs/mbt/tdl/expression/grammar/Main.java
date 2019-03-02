package ee.taltech.cs.mbt.tdl.expression.grammar;

import ee.taltech.cs.mbt.tdl.expression.grammar.TDLExpressionLanguageParser.SampleContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if ( args.length > 0 ) inputFile = args[0];
		InputStream is = System.in;
		if ( inputFile != null) is = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(is);

		TDLExpressionLanguageLexer lexer = new TDLExpressionLanguageLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TDLExpressionLanguageParser parser = new TDLExpressionLanguageParser(tokens);
		ExampleVisitor visitor = new ExampleVisitor();
		SampleContext sampleCtx = parser.sample();
		visitor.visit(sampleCtx);
	}
}