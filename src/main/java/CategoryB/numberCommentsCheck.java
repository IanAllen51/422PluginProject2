package CategoryB;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

//import org.junit.jupiter.api.Test;

public class numberCommentsCheck extends AbstractCheck{


	int count = 0;
	//Need to count the total number of single line comments
	/*
	 * Also need to count the number of block comments
	 */
	
	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
	}
	
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
	}
	
	@Override
	public int[] getRequiredTokens() {
		return new int[] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
	}
	
	@Override
	public void beginTree(DetailAST rootAST) {
		count = 0;
	}
	
	int getResults()
	{
		return count;
	}
	
	@Override
	public void finishTree(DetailAST rootAST) {
		log(rootAST.getLineNo(), "Number of comments: "+ count + "-IA");
		//count = 0;
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		if(ast.getType() == TokenTypes.SINGLE_LINE_COMMENT || ast.getType() == TokenTypes.BLOCK_COMMENT_BEGIN)
		{
			count++;
		}
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
}
