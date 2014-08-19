package leetcode.word;

import java.util.Arrays;
import java.util.HashSet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WorldLadderTest {

	WordLadder	test	= new WordLadder();
	String		start	= "hit";
	String		end		= "cog";

	String[]	dict1	=
						{
			"hot", "dot", "dog", "lot", "log"
						};
	String[]	dict2	=
						{
			"hot", "log"
						};

	@Test
	public void test() {
		Assert.assertEquals(test.ladderLength(start, start, new HashSet<>(Arrays.asList(dict1))), 2);
		Assert.assertEquals(test.ladderLength(start, end, new HashSet<>(Arrays.asList(dict1))), 5);
		Assert.assertEquals(test.ladderLength(start, end, new HashSet<>(Arrays.asList(dict2))), 0);

		Assert.assertEquals(test.ladderLengthII(start, start, new HashSet<>(Arrays.asList(dict1))), 2);
		Assert.assertEquals(test.ladderLengthII(start, end, new HashSet<>(Arrays.asList(dict1))), 5);
		Assert.assertEquals(test.ladderLengthII(start, end, new HashSet<>(Arrays.asList(dict2))), 0);
	}
}
