package CategoryB;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.MockedStatic;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import static org.mockito.Mockito.*;

public class numberOperandsCheckTest {

	@Test
	public void getDefaultTokenTest()
	{
		numberOperandsCheck mycheck = new numberOperandsCheck();
		int[] array = new int[] { TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE};
		
		assertArrayEquals(mycheck.getDefaultTokens(), array);
	}
	
	@Test
	public void getAcceptableTokensTest()
	{
	
		numberOperandsCheck mycheck = new numberOperandsCheck();
		int[] array = new int[] { TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE};
		
		assertArrayEquals(mycheck.getAcceptableTokens(), array);
	}
	
	@Test
	public void getRequiredTokensTest()
	{
		numberOperandsCheck mycheck = new numberOperandsCheck();
		int[] array = new int[] { TokenTypes.IDENT, TokenTypes.NUM_INT, TokenTypes.NUM_FLOAT, TokenTypes.NUM_LONG, TokenTypes.NUM_DOUBLE};
		
		assertArrayEquals(mycheck.getRequiredTokens(), array);
	}
	
	@Test
	public void beginTreeTest()
	{
		numberOperandsCheck mycheck = new numberOperandsCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		mycheck.beginTree(mockedAST);
		numberOperandsCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		verify(spy).beginTree(mockedAST);
	}
	
	
	@Test
	public void finishTreeTest()
	{
		numberOperandsCheck mycheck = new numberOperandsCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		numberOperandsCheck spy = spy(mycheck);
		//spy.finishTree(mockedAST);
		//verify(spy).finishTree(mockedAST);
	
	}
	
	@Test
	public void visitTokenTest()
	{
		numberOperandsCheck mycheck = new numberOperandsCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.IDENT);
		mycheck.visitToken(mockedAST);
		assertEquals(1,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.NUM_INT);
		mycheck.visitToken(mockedAST);
		assertEquals(2,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.NUM_FLOAT);
		mycheck.visitToken(mockedAST);
		assertEquals(3,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.NUM_DOUBLE);
		mycheck.visitToken(mockedAST);
		assertEquals(4,mycheck.count);
		
	}
	
	@Test
	public void isCommentNodesRequiredTest()
	{
		numberOperandsCheck mycheck = new numberOperandsCheck();
		boolean require = true;
		assertEquals(mycheck.isCommentNodesRequired(),require);
	}
}
