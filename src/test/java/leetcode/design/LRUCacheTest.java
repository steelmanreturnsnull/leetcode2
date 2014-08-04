package leetcode.design;

import org.testng.Assert;
import org.testng.annotations.Test;

import leetcode.design.LRUCache;

public class LRUCacheTest {

	@Test
	public void test0() {
		LRUCache test = new LRUCache(0);
		test.set(1, 1);
		Assert.assertEquals(test.get(1), -1);
	}

	@Test
	public void test1() {
		LRUCache test = new LRUCache(1);
		test.set(1, 1);
		Assert.assertEquals(test.get(1), 1);
		test.set(2, 2);
		Assert.assertEquals(test.get(1), -1);
		Assert.assertEquals(test.get(2), 2);
	}

	@Test
	public void test2() {
		LRUCache test = new LRUCache(3);
		test.set(1, 1);
		test.set(2, 2);
		test.set(3, 3);
		test.set(4, 4);
		test.set(5, 5);
		Assert.assertEquals(test.get(1), -1);
		Assert.assertEquals(test.get(2), -1);
		Assert.assertEquals(test.get(5), 5);
		Assert.assertEquals(test.get(4), 4);
		Assert.assertEquals(test.get(3), 3);
		test.set(7, 7);
		test.set(6, 6);
		Assert.assertEquals(test.get(5), -1);
		Assert.assertEquals(test.get(4), -1);
		Assert.assertEquals(test.get(3), 3);
	}
}
