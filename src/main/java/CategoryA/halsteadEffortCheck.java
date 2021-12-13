package CategoryA;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import java.util.*;
import java.io.*;
import java.lang.*;

//import org.junit.jupiter.api.Test;

public class halsteadEffortCheck extends AbstractCheck{

	int countOperators = 0;
	int countOperands = 0;
	double effort = 0;
	HashSet<String> uniqueOperators = new HashSet<String>();
	HashSet<String> uniqueOperands = new HashSet<String>();

	
	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.ASSIGN,TokenTypes.BAND,TokenTypes.BAND_ASSIGN, TokenTypes.BNOT,TokenTypes.BOR,TokenTypes.BOR_ASSIGN,
				TokenTypes.BSR,TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN, TokenTypes.COLON, TokenTypes.COMMA,
				TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN,TokenTypes.DOT, TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT,
				TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LNOT,
				TokenTypes.LOR, TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL,
				TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION, TokenTypes.SL,
				TokenTypes.SL_ASSIGN, TokenTypes.SR, TokenTypes.SR_ASSIGN, TokenTypes.STAR, TokenTypes.STAR_ASSIGN,TokenTypes.UNARY_MINUS,
				TokenTypes.UNARY_PLUS, TokenTypes.IDENT,  TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE,
				TokenTypes.LITERAL_SWITCH, TokenTypes.RBRACK, TokenTypes.RCURLY, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_RETURN, TokenTypes.LITERAL_IF,
				TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_ELSE, TokenTypes.LITERAL_DO, TokenTypes.LCURLY, TokenTypes.LAMBDA, TokenTypes.DO_WHILE,
				TokenTypes.ARRAY_DECLARATOR, TokenTypes.LITERAL_TRUE, TokenTypes.LITERAL_FALSE, TokenTypes.STRING_LITERAL, TokenTypes.CHAR_LITERAL};
	}
	
	@Override
	public int[] getAcceptableTokens() {
		return new int[] {TokenTypes.ASSIGN,TokenTypes.BAND,TokenTypes.BAND_ASSIGN, TokenTypes.BNOT,TokenTypes.BOR,TokenTypes.BOR_ASSIGN,
				TokenTypes.BSR,TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN, TokenTypes.COLON, TokenTypes.COMMA,
				TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN,TokenTypes.DOT, TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT,
				TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LNOT,
				TokenTypes.LOR, TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL,
				TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION, TokenTypes.SL,
				TokenTypes.SL_ASSIGN, TokenTypes.SR, TokenTypes.SR_ASSIGN, TokenTypes.STAR, TokenTypes.STAR_ASSIGN,TokenTypes.UNARY_MINUS,
				TokenTypes.UNARY_PLUS,TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE,
				TokenTypes.LITERAL_SWITCH, TokenTypes.RBRACK, TokenTypes.RCURLY, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_RETURN, TokenTypes.LITERAL_IF,
				TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_ELSE, TokenTypes.LITERAL_DO, TokenTypes.LCURLY, TokenTypes.LAMBDA, TokenTypes.DO_WHILE,
				TokenTypes.ARRAY_DECLARATOR, TokenTypes.LITERAL_TRUE, TokenTypes.LITERAL_FALSE, TokenTypes.STRING_LITERAL, TokenTypes.CHAR_LITERAL};
	}
	
	@Override
	public int[] getRequiredTokens() {
		return new int[] {TokenTypes.ASSIGN,TokenTypes.BAND,TokenTypes.BAND_ASSIGN, TokenTypes.BNOT,TokenTypes.BOR,TokenTypes.BOR_ASSIGN,
				TokenTypes.BSR,TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN, TokenTypes.COLON, TokenTypes.COMMA,
				TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN,TokenTypes.DOT, TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT,
				TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LNOT,
				TokenTypes.LOR, TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL,
				TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION, TokenTypes.SL,
				TokenTypes.SL_ASSIGN, TokenTypes.SR, TokenTypes.SR_ASSIGN, TokenTypes.STAR, TokenTypes.STAR_ASSIGN,TokenTypes.UNARY_MINUS,
				TokenTypes.UNARY_PLUS,TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE,
				TokenTypes.LITERAL_SWITCH, TokenTypes.RBRACK, TokenTypes.RCURLY, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_RETURN, TokenTypes.LITERAL_IF,
				TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_ELSE, TokenTypes.LITERAL_DO, TokenTypes.LCURLY, TokenTypes.LAMBDA, TokenTypes.DO_WHILE,
				TokenTypes.ARRAY_DECLARATOR, TokenTypes.LITERAL_TRUE, TokenTypes.LITERAL_FALSE, TokenTypes.STRING_LITERAL, TokenTypes.CHAR_LITERAL};
	}
	
	@Override
	public void beginTree(DetailAST rootAST) {
		countOperators = 0;
		countOperands = 0;
	}
	
	double getResults()
	{
		return effort;
	}
	@Override
	public void finishTree(DetailAST rootAST) {
		int vocab = uniqueOperators.size() + uniqueOperands.size();
		int baseTwo = (int)(Math.log(vocab) / Math.log(2));
		int length = countOperators + countOperands;
		int volume = length * baseTwo;
		
		//if (uniqueOperands.size() == 0)
		//{
		//	uniqueOperands.add("a");
		//}
		double difficulty = (uniqueOperators.size() / 2) * (countOperands / uniqueOperands.size());
		effort = difficulty * volume;
		countOperands = 0;
		countOperators = 0;
		//uniqueOperators.clear();
		//uniqueOperands.clear();
		log(rootAST.getLineNo(), "Halstead Difficulty: "+ effort + "-IA");
		
		
	}
	
	@Override
	public void visitToken(DetailAST ast) {
		
		int sample = ast.getType();
		switch(sample) {
		case TokenTypes.IDENT:
			countOperands++;
			uniqueOperands.add(ast.getText());
			break;
		case TokenTypes.NUM_INT:
			countOperands++;
			uniqueOperands.add(ast.getText());
			break;
		case TokenTypes.NUM_FLOAT:
			countOperands++;
			uniqueOperands.add(ast.getText());
			break;
		case TokenTypes.NUM_DOUBLE:
			countOperands++;
			uniqueOperands.add(ast.getText());
			break;
		case TokenTypes.NUM_LONG:
			countOperands++;
			uniqueOperands.add(ast.getText());
			break;
		case TokenTypes.STRING_LITERAL:
			countOperands++;
			uniqueOperands.add(ast.getText());
			break;
		case TokenTypes.CHAR_LITERAL:
			countOperands++;
			uniqueOperands.add(ast.getText());
			break;
		default:
			countOperators++;
			uniqueOperators.add(ast.getText());
			
		}
	}


}
