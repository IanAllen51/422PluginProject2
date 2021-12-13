package CategoryB;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

//import org.junit.jupiter.api.Test;

public class numberComLinesCheck extends AbstractCheck{


	int count = 0;
	
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
	
	public int getResults()
	{
		return count;
	}
	
	@Override
	public void finishTree(DetailAST rootAST) {
		log(rootAST.getLineNo(), "Number of comment lines: "+ count + "-IA");
		//count = 0;
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		if(ast.getType() == TokenTypes.SINGLE_LINE_COMMENT || ast.getType() == TokenTypes.BLOCK_COMMENT_BEGIN)
		{
			if(ast.getType() == TokenTypes.BLOCK_COMMENT_BEGIN)
			{
				int start = ast.getLineNo();
				int end = ast.findFirstToken(TokenTypes.BLOCK_COMMENT_END).getLineNo();
				int blockComments = end - start;
				for(int i=0; i <= blockComments; i++)
				{
					count++;
				}
			}
			count++;
		}
		
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
}
