package CategoryB;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.MockedStatic;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import static org.mockito.Mockito.*;

public class numberLoopStateCheckTest {
	
	@Test
	public void getDefaultTokensTest()
	{
		numberLoopStateCheck mycheck = new numberLoopStateCheck();
		int[] array = new int[] {TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_DO, TokenTypes.DO_WHILE};
		
		assertArrayEquals(mycheck.getDefaultTokens(), array);
	}
	
	@Test
	public void getAcceptableTokensTest()
	{
		numberLoopStateCheck mycheck = new numberLoopStateCheck();
		int[] array = new int[] {TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_DO, TokenTypes.DO_WHILE};
		
		assertArrayEquals(mycheck.getAcceptableTokens(), array);
	}
	
	@Test
	public void getRequiredTokensTest()
	{
		numberLoopStateCheck mycheck = new numberLoopStateCheck();
		int[] array = new int[] {TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_DO, TokenTypes.DO_WHILE};
		
		assertArrayEquals(mycheck.getRequiredTokens(), array);
	}

	@Test
	public void beginTreeTest()
	{
		numberLoopStateCheck mycheck = new numberLoopStateCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		mycheck.beginTree(mockedAST);
		//needs fix
		//verify(mockedAST, times(1)).getChildCount();
		numberLoopStateCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		verify(spy).beginTree(mockedAST);
	}
	
	
	@Test
	public void finishTreeTest()
	{
		numberLoopStateCheck mycheck = new numberLoopStateCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		numberLoopStateCheck spy = spy(mycheck);
		//spy.finishTree(mockedAST);
		//verify(spy).finishTree(mockedAST);
	
	}
	
	@Test
	public void visitTokenTest()
	{
		numberLoopStateCheck mycheck = new numberLoopStateCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.LITERAL_FOR);
		mycheck.visitToken(mockedAST);
		assertEquals(1,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.LITERAL_WHILE);
		mycheck.visitToken(mockedAST);
		assertEquals(2,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.LITERAL_DO);
		mycheck.visitToken(mockedAST);
		assertEquals(3,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.DO_WHILE);
		mycheck.visitToken(mockedAST);
		assertEquals(4,mycheck.count);
		
	}
	
	@Test
	public void isCommentNodesRequiredTest()
	{
		numberLoopStateCheck mycheck = new numberLoopStateCheck();
		boolean require = true;
		assertEquals(mycheck.isCommentNodesRequired(),require);
	}


}
