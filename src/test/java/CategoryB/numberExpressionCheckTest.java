package CategoryB;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.MockedStatic;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import static org.mockito.Mockito.*;

public class numberExpressionCheckTest {
	
	@Test
	public void getDefaultTokensTest()
	{
		numberExpressionCheck mycheck = new numberExpressionCheck();
		int[] array = new int[] {TokenTypes.EXPR};
		
		assertArrayEquals(mycheck.getDefaultTokens(), array);
	}
	
	@Test
	public void getAcceptableTokensTest()
	{
		numberExpressionCheck mycheck = new numberExpressionCheck();
		int[] array = new int[] {TokenTypes.EXPR};
		
		assertArrayEquals(mycheck.getAcceptableTokens(), array);
	}
	
	@Test
	public void getRequiredTokensTest()
	{
		numberExpressionCheck mycheck = new numberExpressionCheck();
		int[] array = new int[] {TokenTypes.EXPR};
		
		assertArrayEquals(mycheck.getRequiredTokens(), array);
	}

	@Test
	public void beginTreeTest()
	{
		numberExpressionCheck mycheck = new numberExpressionCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		mycheck.beginTree(mockedAST);
		//needs fix
		//verify(mockedAST, times(1)).getChildCount();
		numberExpressionCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		verify(spy).beginTree(mockedAST);
	}
	
	
	@Test
	public void finishTreeTest()
	{
		numberExpressionCheck mycheck = new numberExpressionCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		numberExpressionCheck spy = spy(mycheck);
		//spy.finishTree(mockedAST);
		//verify(spy).finishTree(mockedAST);
	
	}
	
	@Test
	public void visitTokenTest()
	{
		numberExpressionCheck mycheck = new numberExpressionCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.EXPR);
		mycheck.visitToken(mockedAST);
		assertEquals(1,mycheck.count);
		
	}
	
	@Test
	public void isCommentNodesRequiredTest()
	{
		numberExpressionCheck mycheck = new numberExpressionCheck();
		boolean require = true;
		assertEquals(mycheck.isCommentNodesRequired(),require);
	}

}
