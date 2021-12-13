package CategoryB;

import java.util.Hashtable;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

//import org.junit.jupiter.api.Test;

public class numberLoopStateCheck extends AbstractCheck{


	int count = 0;
	
	@Override
	public int[] getDefaultTokens() {
		return new int[] {TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_DO, TokenTypes.DO_WHILE};
	}
	
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_DO, TokenTypes.DO_WHILE};
	}
	
	@Override
	public int[] getRequiredTokens() {
		return new int[] {TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_DO, TokenTypes.DO_WHILE};
	}
	
	@Override
	public void beginTree(DetailAST rootAST) {
		count = 0;
	}
	
	//created for Deliverable 3
	//public Hashtable<String,Integer> getResults()
	//{
	//	Hashtable<String,Integer> results = new Hashtable<String,Integer>();
	//	results.put("LoopCount", count);
	//	return results;
	//}
	
	public int getResults()
	{
		return count;
	}
	
	@Override
	public void finishTree(DetailAST rootAST) {
		log(rootAST.getLineNo(), "Number of Loop Statements: "+ count + "-IA");
		//count = 0;
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		if(ast.getType() == TokenTypes.LITERAL_FOR ||ast.getType() == TokenTypes.LITERAL_WHILE || ast.getType() == TokenTypes.LITERAL_DO ||ast.getType() == TokenTypes.DO_WHILE)
		{
			count++;
		}
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
}
