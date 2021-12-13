package CategoryA;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.*;

import org.mockito.MockedStatic;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import CategoryB.numberComLinesCheck;
import CategoryB.numberCommentsCheck;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import static org.mockito.Mockito.*;

public class halsteadDifficultyCheckTest {

	@Test
	public void getDefaultTokenTest()
	{
		halsteadDifficultyCheck mycheck = new halsteadDifficultyCheck();
		int[] array = new int[] { TokenTypes.ASSIGN,TokenTypes.BAND,TokenTypes.BAND_ASSIGN, TokenTypes.BNOT,TokenTypes.BOR,TokenTypes.BOR_ASSIGN,
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
		
		assertArrayEquals(mycheck.getDefaultTokens(), array);
	}
	
	@Test
	public void getAcceptableTokensTest()
	{
	
		halsteadDifficultyCheck mycheck = new halsteadDifficultyCheck();
		int[] array = new int[] {TokenTypes.ASSIGN,TokenTypes.BAND,TokenTypes.BAND_ASSIGN, TokenTypes.BNOT,TokenTypes.BOR,TokenTypes.BOR_ASSIGN,
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
		
		assertArrayEquals(mycheck.getAcceptableTokens(), array);
	}
	
	@Test
	public void getRequiredTokensTest()
	{
		halsteadDifficultyCheck mycheck = new halsteadDifficultyCheck();
		int[] array = new int[] {TokenTypes.ASSIGN,TokenTypes.BAND,TokenTypes.BAND_ASSIGN, TokenTypes.BNOT,TokenTypes.BOR,TokenTypes.BOR_ASSIGN,
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
		
		assertArrayEquals(mycheck.getRequiredTokens(), array);
	}
	
	@Test
	public void beginTreeTest()
	{
		halsteadDifficultyCheck mycheck = new halsteadDifficultyCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		mycheck.beginTree(mockedAST);
		halsteadDifficultyCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		verify(spy).beginTree(mockedAST);
	}
	
	
	@Test
	public void finishTreeTest()
	{
		halsteadDifficultyCheck mycheck = new halsteadDifficultyCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		halsteadDifficultyCheck spy = spy(mycheck);
		spy.uniqueOperators.add("+");
		spy.uniqueOperators.add("-");
		spy.uniqueOperands.add("a");
		spy.uniqueOperands.add("i");
		assertEquals(2,mycheck.uniqueOperands.size());
		assertEquals(2,mycheck.uniqueOperators.size());
		//need to figure out difficulty
	
	}
	
	@Test
	public void visitTokenTest()
	{
		halsteadDifficultyCheck mycheck = new halsteadDifficultyCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.IDENT);
		when(mockedAST.getText()).thenReturn("x");
		mycheck.visitToken(mockedAST);
		assertEquals(1,mycheck.uniqueOperands.size());
		assertEquals(0,mycheck.uniqueOperators.size());
		assertEquals(1,mycheck.countOperands);
		assertEquals(0,mycheck.countOperators);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.NUM_INT);
		when(mockedAST.getText()).thenReturn("5");
		mycheck.visitToken(mockedAST);
		assertEquals(2,mycheck.uniqueOperands.size());
		assertEquals(0,mycheck.uniqueOperators.size());
		assertEquals(2,mycheck.countOperands);
		assertEquals(0,mycheck.countOperators);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.NUM_FLOAT);
		when(mockedAST.getText()).thenReturn("5f");
		mycheck.visitToken(mockedAST);
		assertEquals(3,mycheck.uniqueOperands.size());
		assertEquals(0,mycheck.uniqueOperators.size());
		assertEquals(3,mycheck.countOperands);
		assertEquals(0,mycheck.countOperators);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.NUM_DOUBLE);
		when(mockedAST.getText()).thenReturn("5.0");
		mycheck.visitToken(mockedAST);
		assertEquals(4,mycheck.uniqueOperands.size());
		assertEquals(0,mycheck.uniqueOperators.size());
		assertEquals(4,mycheck.countOperands);
		assertEquals(0,mycheck.countOperators);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.NUM_LONG);
		when(mockedAST.getText()).thenReturn("5L");
		mycheck.visitToken(mockedAST);
		assertEquals(5,mycheck.uniqueOperands.size());
		assertEquals(0,mycheck.uniqueOperators.size());
		assertEquals(5,mycheck.countOperands);
		assertEquals(0,mycheck.countOperators);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.STRING_LITERAL);
		when(mockedAST.getText()).thenReturn("IAN");
		mycheck.visitToken(mockedAST);
		assertEquals(6,mycheck.uniqueOperands.size());
		assertEquals(0,mycheck.uniqueOperators.size());
		assertEquals(6,mycheck.countOperands);
		assertEquals(0,mycheck.countOperators);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.CHAR_LITERAL);
		when(mockedAST.getText()).thenReturn("I");
		mycheck.visitToken(mockedAST);
		assertEquals(7,mycheck.uniqueOperands.size());
		assertEquals(0,mycheck.uniqueOperators.size());
		assertEquals(7,mycheck.countOperands);
		assertEquals(0,mycheck.countOperators);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.STAR);
		when(mockedAST.getText()).thenReturn("*");
		mycheck.visitToken(mockedAST);
		assertEquals(7,mycheck.uniqueOperands.size());
		assertEquals(1,mycheck.uniqueOperators.size());
		assertEquals(7,mycheck.countOperands);
		assertEquals(1,mycheck.countOperators);
	}
}
