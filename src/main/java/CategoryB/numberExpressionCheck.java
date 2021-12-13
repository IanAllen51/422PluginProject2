package CategoryB;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

//import org.junit.jupiter.api.Test;

public class numberExpressionCheck extends AbstractCheck{


	int count = 0;
	
	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.EXPR};
	}
	
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.EXPR};
	}
	
	@Override
	public int[] getRequiredTokens() {
		return new int[] {TokenTypes.EXPR};
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
		log(rootAST.getLineNo(), "Number of Expressions: "+ count + "-IA");
		//count = 0;
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		if (ast.getType() == TokenTypes.EXPR)
		{
			count++;
		}
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
}
