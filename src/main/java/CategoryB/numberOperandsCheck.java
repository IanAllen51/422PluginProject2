package CategoryB;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

//import org.junit.jupiter.api.Test;

public class numberOperandsCheck extends AbstractCheck{


	int count = 0;
	
	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE};
	}
	
	@Override
	public int[] getAcceptableTokens() {
		return new int[] { TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE};
	}
	
	@Override
	public int[] getRequiredTokens() {
		return new int[] { TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE};
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
		log(rootAST.getLineNo(), "Number of Operands: "+ count + "-IA");
		//count = 0;
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		if(ast.getType() == TokenTypes.IDENT ||ast.getType() == TokenTypes.NUM_INT || ast.getType() == TokenTypes.NUM_FLOAT ||ast.getType() == TokenTypes.NUM_LONG || ast.getType() == TokenTypes.NUM_DOUBLE)
		{
			count++;
		}
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
}
