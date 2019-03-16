package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ExpressionAssignOpAdditionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ExpressionBinaryOpAdditionContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Test {
	public static class CommentShifter extends UTALanguageBaseListener {
		BufferedTokenStream tokens;
		TokenStreamRewriter rewriter;
		/** Create TokenStreamRewriter attached to token stream
		 * sitting between the Cymbol lexer and parser.
		 */
		public CommentShifter(BufferedTokenStream tokens) {
			this.tokens = tokens;
			rewriter = new TokenStreamRewriter(tokens);
		}

		@Override
		public void exitExpressionBinaryOpAddition(ExpressionBinaryOpAdditionContext ctx) {
			System.out.println("Exiting");
			Token semi = ctx.getStop();
			int i = semi.getTokenIndex();
			List<Token> cmtChannel =
					tokens.getHiddenTokensToRight(i, UTALanguageLexer.CHAN_COMMENTS);
			if ( cmtChannel!=null ) {
				Token cmt = cmtChannel.get(0);
				if ( cmt!=null ) {
					System.out.println(cmt.getText());
					String txt = cmt.getText().substring(2);
					String newCmt = "/* " + txt.trim() + " */\n";
					rewriter.insertBefore(ctx.start, newCmt);
					rewriter.replace(cmt, "\n");
				}
			}
		}
	}

	public static void main(String... args) throws IOException {
		InputStream in = new ByteArrayInputStream(
				"a + b /*\ntest \ntest test\n*/"
			.getBytes(StandardCharsets.UTF_8));
		ANTLRInputStream input = new ANTLRInputStream(in);
		UTALanguageLexer lexer = new UTALanguageLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		UTALanguageParser parser = new UTALanguageParser(tokens);

		ParseTree tree = parser.expression();
		ParseTreeWalker walker = new ParseTreeWalker();
		CommentShifter shifter = new CommentShifter(tokens);
		walker.walk(shifter, tree);
		System.out.print(shifter.rewriter.getText());
	}
}
