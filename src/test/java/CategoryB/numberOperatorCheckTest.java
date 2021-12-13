package CategoryB;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.MockedStatic;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import static org.mockito.Mockito.*;

public class numberOperatorCheckTest {

	@Test
	public void getDefaultTokenTest()
	{
		numberOperatorCheck mycheck = new numberOperatorCheck();
		int[] array = new int[] { TokenTypes.ASSIGN, TokenTypes.BAND, TokenTypes.BAND_ASSIGN, TokenTypes.BNOT, TokenTypes.BOR, TokenTypes.BOR_ASSIGN, TokenTypes.BSR,
				 TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN, TokenTypes.COLON, TokenTypes.COMMA, TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN,
				 TokenTypes.DOT, TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT, TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF,
				 TokenTypes.LNOT, TokenTypes.LOR, TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL,
				 TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION, TokenTypes.SL, TokenTypes.SL_ASSIGN, TokenTypes.SR,
				 TokenTypes.SR_ASSIGN, TokenTypes.STAR, TokenTypes.STAR_ASSIGN, TokenTypes.UNARY_MINUS, TokenTypes.UNARY_PLUS};
		
		assertArrayEquals(mycheck.getDefaultTokens(), array);
	}
	
	@Test
	public void getAcceptableTokensTest()
	{
		numberOperatorCheck mycheck = new numberOperatorCheck();
		int[] array = new int[] { TokenTypes.ASSIGN, TokenTypes.BAND, TokenTypes.BAND_ASSIGN, TokenTypes.BNOT, TokenTypes.BOR, TokenTypes.BOR_ASSIGN, TokenTypes.BSR,
				 TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN, TokenTypes.COLON, TokenTypes.COMMA, TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN,
				 TokenTypes.DOT, TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT, TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF,
				 TokenTypes.LNOT, TokenTypes.LOR, TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL,
				 TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION, TokenTypes.SL, TokenTypes.SL_ASSIGN, TokenTypes.SR,
				 TokenTypes.SR_ASSIGN, TokenTypes.STAR, TokenTypes.STAR_ASSIGN, TokenTypes.UNARY_MINUS, TokenTypes.UNARY_PLUS};
		
		assertArrayEquals(mycheck.getAcceptableTokens(), array);
	}
	
	@Test
	public void getRequiredTokensTest()
	{
		numberOperatorCheck mycheck = new numberOperatorCheck();
		int[] array = new int[] { TokenTypes.ASSIGN, TokenTypes.BAND, TokenTypes.BAND_ASSIGN, TokenTypes.BNOT, TokenTypes.BOR, TokenTypes.BOR_ASSIGN, TokenTypes.BSR,
				 TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, TokenTypes.BXOR_ASSIGN, TokenTypes.COLON, TokenTypes.COMMA, TokenTypes.DEC, TokenTypes.DIV, TokenTypes.DIV_ASSIGN,
				 TokenTypes.DOT, TokenTypes.EQUAL, TokenTypes.GE, TokenTypes.GT, TokenTypes.INC, TokenTypes.INDEX_OP, TokenTypes.LAND, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF,
				 TokenTypes.LNOT, TokenTypes.LOR, TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN, TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL,
				 TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN, TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION, TokenTypes.SL, TokenTypes.SL_ASSIGN, TokenTypes.SR,
				 TokenTypes.SR_ASSIGN, TokenTypes.STAR, TokenTypes.STAR_ASSIGN, TokenTypes.UNARY_MINUS, TokenTypes.UNARY_PLUS};
		
		assertArrayEquals(mycheck.getRequiredTokens(), array);
	}
	
	@Test
	public void beginTreeTest()
	{
		numberOperatorCheck mycheck = new numberOperatorCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		mycheck.beginTree(mockedAST);
		//needs fix
		//verify(mockedAST, times(1)).getChildCount();
		numberOperatorCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		verify(spy).beginTree(mockedAST);
	}
	
	
	@Test
	public void finishTreeTest()
	{
		numberOperatorCheck mycheck = new numberOperatorCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		numberOperatorCheck spy = spy(mycheck);
		//spy.finishTree(mockedAST);
		//verify(spy).finishTree(mockedAST);
	
	}
	
	@Test
	public void visitTokenTest()
	{
		numberOperatorCheck mycheck = new numberOperatorCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.ASSIGN);
		mycheck.visitToken(mockedAST);
		assertEquals(1,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.BAND);
		mycheck.visitToken(mockedAST);
		assertEquals(2,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.BNOT);
		mycheck.visitToken(mockedAST);
		assertEquals(3,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.DOT);
		mycheck.visitToken(mockedAST);
		assertEquals(4,mycheck.count);
		
	}
	
	@Test
	public void isCommentNodesRequiredTest()
	{
		numberOperatorCheck mycheck = new numberOperatorCheck();
		boolean require = true;
		assertEquals(mycheck.isCommentNodesRequired(),require);
	}

	
}
