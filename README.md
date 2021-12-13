# 422PluginProject2

Firstly i would like to appologize for the sloppy submission of the the project. I Had issues loading files to my original repo and created a mess of files. I chose to upload files in attempt to not alter your access to the information.


My initial code that from Deliverable2 contained five Halstead checks (length,vocab,volume,difficulty and effort) as well as six checks for number of comments, commentLines, expressions, loop statements, Operands and Operators. Each of these 11 checks had a matching test file to test all components including:getDefaultTokens(), getAcceptableTokens(), getRequiredTokens(), beginTree(), finishTree(),visitToken(),and for comment checks isCommentNodesRequired().

Operands were defined as either an IDENT, NUM_INT, NUM_LONG, or NUM_DOUBLE. These 5 token types make up all potential variables to be used in an equation/expression.
Operators were defined as any token that contained the 'operator' tag in the checkstyle API. These tokens make up the non variables in an equation/expression.
NOTE: Deliverable2 was stated to have incorrect definition for Operator/Operand. I was not able to figure out the correct combination by submission date.
Halstead metrics:
  Length: Length = total operators + total operands
  Vocabulary: Vocabulary = unique operators + unique operands
  Volume: Volume = Length * (log2 vocabulary)
  Difficulty: Difficulty = (unique operators/2) * (total operands/unique operands)
  Effort: Effort = Difficulty * Volume
 
Initial Results:
  Running Pit Test Coverage on the Deliverable2 code resulted in an 83% line coverage and 59% Mutation Coverage, broken into 89%   and 59% respectively for categoryA and 74% and 69% respectively for categoryB. See PitclipseTest1.PNG in the results file in     repo.

BlackBox Testing Fault Models:
  CategoryA:
    HalsteadLength:
      counting pairs as two (),[],{}
    HalsteadVocabulary/HalsteadVolume/HalsteadDifficulty/HalsteadEffort:
      y = -2 +3
      unique operator -2 being counted as 2.
      As all halstead metrics excluding length rely on unique operators and operands, a slip in Vocab will cause error in all others.
  
  CategoryB:
    numberComments:
      // //
      check to see if test will pick up a commented comment
    numberCommentLines:
      /* */
      check to see if test will return single comment
    looping:
      while()
      {
        if(){}
      }
      check internal loop is picked up
    Expressions:
      ((3+4)+((3+4)-(3+4)))
      check that expression reads internal expressions
    Operand/Operator
      a = -2+3
      check both that -2 is not - 2

NOTE:TESTED POST WHITEBOX      
Results of blackbox testing for CategoryB. Testing for category a resulted in passing tests for all tests except for the Operator check. The check returns - 2 vs -2.
There was not enough time to thoroughly test CategoryA, however given the Operator check returned an incorrect value in the initial testing, i am lead to believe i have an issue in the design of my halstead metrics as well.

While working on the project, i decided to work on the test engine prior to writing the blackbox fault tests. I used the mirroring check for each of the engine tests. While working on the engine design, i realized that i would need to write a getResults() method to return the incremented count for each check. Working with a fellow student, we discovered that the JavaParser for the DetailAST root needed to be altered with .appendHiddenCommentNodes to be able to read comment lines in the code. This was implemented following the parsing of the file. This lead to the realization that my engine was producing vastly higher values than should be returned. This was tested by printing lines in the helper method provided. I realized that the issue came from the fact that the function was invoking my counter on each line of the file. This lead me to change my approach to counting and inserted my count in an if statement, only incrementing if tokens matched, vs simply if a token was visited. This process was repeated for all checks. The halstead metrics were correctly counting and did not require much alteration.

Upon completion of the functional testEngine classes(marked with Junit naming), i decided to run a PIT Test to see how the code lined up with this integration. By making the changes inorder to get the engine running correctly, i fixed some of the issues with my Coverage, resulting in 100% line coverage and 85% mutation coverage. 82% and 89% mutation coverage for CategoryA and CategoryB respectively. This marks a coverage increase of 26% and mutation coverage increase of 30%. See PitclipseTestpostEngine.PNG in the results file in repo.

Looking into PIT Summary, i was able to discover that a large portion of the survinging mutatants was due to the fact that i included a clear() command for two of my HashSets in four of the five halstead checks. This action is not necessary and removal will not alter the results the TestEngine produces (minus the addition of a comment for each). By removing these portions of the code, i was able to increase my PIT Test Coverage to 100% line coverage and 91% Mutation coverage. Looking into each of the summarie, the remaining mutation is in the log() function in each of the checkTests. I was not able to figure out how to cover this mutant.

Because i had achieved full coverage excluding the log() function, i did not write any additional tests.

Class Testing:


