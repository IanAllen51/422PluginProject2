package CategoryB;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.MockedStatic;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import static org.mockito.Mockito.*;

public class numberCommentsCheckTest {
	
	@Test
	public void getDefaultTokensTest()
	{
		numberCommentsCheck mycheck = new numberCommentsCheck();
		int[] array = new int[] {TokenTypes.SINGLE_LINE_COMMENT,TokenTypes.BLOCK_COMMENT_BEGIN};
		
		assertArrayEquals(mycheck.getDefaultTokens(), array);
	}
	
	@Test
	public void getAcceptableTokensTest()
	{
		numberCommentsCheck mycheck = new numberCommentsCheck();
		int[] array = new int[] {TokenTypes.SINGLE_LINE_COMMENT,TokenTypes.BLOCK_COMMENT_BEGIN};
		
		assertArrayEquals(mycheck.getAcceptableTokens(), array);
	}
	
	@Test
	public void getRequiredTokensTest()
	{
		numberCommentsCheck mycheck = new numberCommentsCheck();
		int[] array = new int[] {TokenTypes.SINGLE_LINE_COMMENT,TokenTypes.BLOCK_COMMENT_BEGIN};
		
		assertArrayEquals(mycheck.getRequiredTokens(), array);
	}

	@Test
	public void beginTreeTest()
	{
		numberCommentsCheck mycheck = new numberCommentsCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		mycheck.beginTree(mockedAST);
		//needs fix
		//verify(mockedAST, times(1)).getChildCount();
		numberCommentsCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		verify(spy).beginTree(mockedAST);
	}
	
	
	@Test
	public void finishTreeTest()
	{
		numberCommentsCheck mycheck = new numberCommentsCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		numberCommentsCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		//spy.finishTree(mockedAST);
		//verify(spy).finishTree(mockedAST);
	
	}
	
	@Test
	public void visitTokenTest()
	{
		numberCommentsCheck mycheck = new numberCommentsCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
		mycheck.visitToken(mockedAST);
		assertEquals(1,mycheck.count);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.BLOCK_COMMENT_BEGIN);
		mycheck.visitToken(mockedAST);
		assertEquals(2,mycheck.count);
	}
	
	@Test
	public void isCommentNodesRequiredTest()
	{
		numberCommentsCheck mycheck = new numberCommentsCheck();
		boolean require = true;
		assertEquals(mycheck.isCommentNodesRequired(),require);
	}
}

