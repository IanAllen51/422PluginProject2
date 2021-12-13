package CategoryB;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.MockedStatic;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import static org.mockito.Mockito.*;

public class numberComLinesCheckTest {
	
	@Test
	public void getDefaultTokenTest()
	{
		numberComLinesCheck mycheck = new numberComLinesCheck();
		int[] array = new int[] { TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		
		assertArrayEquals(mycheck.getDefaultTokens(), array);
	}
	
	@Test
	public void getAcceptableTokensTest()
	{
	
		numberComLinesCheck mycheck = new numberComLinesCheck();
		int[] array = new int[] { TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		
		assertArrayEquals(mycheck.getAcceptableTokens(), array);
	}
	
	@Test
	public void getRequiredTokensTest()
	{
		numberComLinesCheck mycheck = new numberComLinesCheck();
		int[] array = new int[] {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		
		assertArrayEquals(mycheck.getRequiredTokens(), array);
	}
	
	@Test
	public void beginTreeTest()
	{
		numberComLinesCheck mycheck = new numberComLinesCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		mycheck.beginTree(mockedAST);
		numberComLinesCheck spy = spy(mycheck);
		spy.beginTree(mockedAST);
		verify(spy).beginTree(mockedAST);
	}
	
	
	@Test
	public void finishTreeTest()
	{
		numberComLinesCheck mycheck = new numberComLinesCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		numberComLinesCheck spy = spy(mycheck);
		//mycheck.finishTree(mockedAST);
		//verify(mycheck).finishTree(mockedAST);
	
	}
	
	@Test
	//@Disabled 
	public void visitTokenTest()
	{
		numberComLinesCheck mycheck = new numberComLinesCheck();
		DetailAST mockedAST = mock(DetailAST.class);
		
		when(mockedAST.getType()).thenReturn(TokenTypes.SINGLE_LINE_COMMENT);
		mycheck.visitToken(mockedAST);
		assertEquals(1,mycheck.count);

		//need to fix. spy?
		DetailAST spy = spy(DetailAST.class);
		when(mockedAST.getType()).thenReturn(TokenTypes.BLOCK_COMMENT_BEGIN);
		when(mockedAST.getLineNo()).thenReturn(2);
		//when(spy.findFirstToken(TokenTypes.BLOCK_COMMENT_END).getLineNo()).thenReturn(3);
		when(mockedAST.findFirstToken(TokenTypes.BLOCK_COMMENT_END)).thenReturn(mockedAST);
		when(mockedAST.findFirstToken(TokenTypes.BLOCK_COMMENT_END).getLineNo()).thenReturn(3);
		mycheck.visitToken(mockedAST);
		assertEquals(3,mycheck.count);
		
	}
	
	@Test
	public void isCommentNodesRequiredTest()
	{
		numberComLinesCheck mycheck = new numberComLinesCheck();
		boolean require = true;
		assertEquals(mycheck.isCommentNodesRequired(),require);
	}

}
