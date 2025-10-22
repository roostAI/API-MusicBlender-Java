package com.medeiros.SPRINGProject.algorithm;

import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api;
import org.junit.jupiter.api.Assertions;

public class algorithmDataTest {

	// Merged class fields
	private algorithmData algorithmData;

	// Merged test methods

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@BeforeEach
	public void setUp() {
		algorithmData = new algorithmData();
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void defaultRithmPointsValue() {
		assertEquals(0, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void setAndGetRithmPoints() {
		algorithmData.setRithmPoints(50);
		assertEquals(50, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void multipleUpdatesRithmPoints() {
		algorithmData.setRithmPoints(10);
		algorithmData.setRithmPoints(20);
		algorithmData.setRithmPoints(30);
		assertEquals(30, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void rithmPointsWhenBlacklisted() {
		algorithmData.setBlack_list(true);
		assertEquals(0, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void rithmPointsWhenBlocked() {
		algorithmData.setBlocked(true);
		assertEquals(0, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void rithmPointsByLikes() {
		int likes = 5;
		algorithmData.setRithmPoints(algorithmData.rithmPointsByLike(likes));
		assertEquals(50, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void rithmPointsByComments() {
		int comments = 5;
		algorithmData.setRithmPoints(algorithmData.rithmPointsByComents(comments));
		assertEquals(75, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=getRithmPoints_82f961bd0d
	 * ROOST_METHOD_SIG_HASH=getRithmPoints_728e09b79f
	 *
	 */
	@Test
	@Tag("valid")
	public void rithmPointsByLikesAndComments() {
		int likes = 5;
		int comments = 5;
		algorithmData
			.setRithmPoints(algorithmData.rithmPointsByLike(likes) + algorithmData.rithmPointsByComents(comments));
		assertEquals(125, algorithmData.getRithmPoints());
	}

	/*
	 * ROOST_METHOD_HASH=isBlack_list_560ae9db06
	 * ROOST_METHOD_SIG_HASH=isBlack_list_4614434c3f
	 *
	 */
	@Test
	@Tag("valid")
	public void blackListTrue() {
		algorithmData data = new algorithmData();
		data.setBlack_list(true);
		assertTrue(data.isBlack_list());
	}

	/*
	 * ROOST_METHOD_HASH=isBlack_list_560ae9db06
	 * ROOST_METHOD_SIG_HASH=isBlack_list_4614434c3f
	 *
	 */
	@Test
	@Tag("valid")
	public void blackListFalse() {
		algorithmData data = new algorithmData();
		data.setBlack_list(false);
		assertFalse(data.isBlack_list());
	}

	/*
	 * ROOST_METHOD_HASH=isBlack_list_560ae9db06
	 * ROOST_METHOD_SIG_HASH=isBlack_list_4614434c3f
	 *
	 */
	@Test
	@Tag("valid")
	public void blackListNotSet() {
		algorithmData data = new algorithmData();
		assertFalse(data.isBlack_list());
	}

	/*
	 * ROOST_METHOD_HASH=isBlack_list_560ae9db06
	 * ROOST_METHOD_SIG_HASH=isBlack_list_4614434c3f
	 *
	 */
	@Test
	@Tag("valid")
	public void blackListSetMultipleTimes() {
		algorithmData data = new algorithmData();
		data.setBlack_list(true);
		assertTrue(data.isBlack_list());
		data.setBlack_list(true);
		assertTrue(data.isBlack_list());
		data.setBlack_list(true);
		assertTrue(data.isBlack_list());
	}

	/*
	 * ROOST_METHOD_HASH=isBlack_list_560ae9db06
	 * ROOST_METHOD_SIG_HASH=isBlack_list_4614434c3f
	 *
	 */
	@Test
	@Tag("valid")
	public void blackListSetToFalseMultipleTimes() {
		algorithmData data = new algorithmData();
		data.setBlack_list(false);
		assertFalse(data.isBlack_list());
		data.setBlack_list(false);
		assertFalse(data.isBlack_list());
		data.setBlack_list(false);
		assertFalse(data.isBlack_list());
	}

	/*
	 * ROOST_METHOD_HASH=isBlack_list_560ae9db06
	 * ROOST_METHOD_SIG_HASH=isBlack_list_4614434c3f
	 *
	 */
	@Test
	@Tag("valid")
	public void blackListAlternateTrueFalse() {
		algorithmData data = new algorithmData();
		data.setBlack_list(true);
		assertTrue(data.isBlack_list());
		data.setBlack_list(false);
		assertFalse(data.isBlack_list());
		data.setBlack_list(true);
		assertTrue(data.isBlack_list());
	}

	/*
	 * ROOST_METHOD_HASH=isBlack_list_560ae9db06
	 * ROOST_METHOD_SIG_HASH=isBlack_list_4614434c3f
	 *
	 */
	@Test
	@Tag("valid")
	public void blackListAlternateFalseTrue() {
		algorithmData data = new algorithmData();
		data.setBlack_list(false);
		assertFalse(data.isBlack_list());
		data.setBlack_list(true);
		assertTrue(data.isBlack_list());
		data.setBlack_list(false);
		assertFalse(data.isBlack_list());
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByLike_f1d922798a
	 * ROOST_METHOD_SIG_HASH=rithmPointsByLike_817b4e8687
	 *
	 */
	@Test
	@Tag("valid")
	public void rithmPointsByLikePositiveLikes() {
		int result = algorithmData.rithmPointsByLike(5);
		assertEquals(50, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByLike_f1d922798a
	 * ROOST_METHOD_SIG_HASH=rithmPointsByLike_817b4e8687
	 *
	 */
	@Test
	@Tag("valid")
	public void rithmPointsByLikeZeroLikes() {
		int result = algorithmData.rithmPointsByLike(0);
		assertEquals(0, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByLike_f1d922798a
	 * ROOST_METHOD_SIG_HASH=rithmPointsByLike_817b4e8687
	 *
	 */
	@Test
	@Tag("invalid")
	public void rithmPointsByLikeNegativeLikes() {
		int result = algorithmData.rithmPointsByLike(-5);
		assertEquals(-50, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByLike_f1d922798a
	 * ROOST_METHOD_SIG_HASH=rithmPointsByLike_817b4e8687
	 *
	 */
	@Test
	@Tag("boundary")
	public void rithmPointsByLikeMaxInteger() {
		int result = algorithmData.rithmPointsByLike(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE * 10, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByLike_f1d922798a
	 * ROOST_METHOD_SIG_HASH=rithmPointsByLike_817b4e8687
	 *
	 */
	@Test
	@Tag("boundary")
	public void rithmPointsByLikeMinInteger() {
		int result = algorithmData.rithmPointsByLike(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE * 10, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@BeforeEach
	public void setUp_2() {
		algorithmData = new algorithmData();
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("valid")
	public void basicFunctionalityPositiveComments() {
		int result = algorithmData.rithmPointsByComents(5);
		assertEquals(75, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("boundary")
	public void edgeCaseZeroComments() {
		int result = algorithmData.rithmPointsByComents(0);
		assertEquals(0, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("invalid")
	public void edgeCaseNegativeComments() {
		int result = algorithmData.rithmPointsByComents(-3);
		assertEquals(-45, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("valid")
	public void largeNumberOfComments() {
		int result = algorithmData.rithmPointsByComents(1000000);
		assertEquals(15000000, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("boundary")
	public void maximumIntegerValue() {
		int result = algorithmData.rithmPointsByComents(Integer.MAX_VALUE);
		assertEquals((long) Integer.MAX_VALUE * 15, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("boundary")
	public void minimumIntegerValue() {
		int result = algorithmData.rithmPointsByComents(Integer.MIN_VALUE);
		assertEquals((long) Integer.MIN_VALUE * 15, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("integration")
	public void blockedUser() {
		algorithmData.setBlocked(true);
		int result = algorithmData.rithmPointsByComents(5);
		assertEquals(0, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("integration")
	public void blacklistedUser() {
		algorithmData.setBlack_list(true);
		int result = algorithmData.rithmPointsByComents(5);
		assertEquals(0, result);
	}

	/*
	 * ROOST_METHOD_HASH=rithmPointsByComents_bf0560ce74
	 * ROOST_METHOD_SIG_HASH=rithmPointsByComents_16f69f99ca
	 *
	 */
	@Test
	@Tag("valid")
	public void unblockedAndUnblacklistedUser() {
		algorithmData.setBlocked(false);
		algorithmData.setBlack_list(false);
		int result = algorithmData.rithmPointsByComents(5);
		assertEquals(75, result);
	}

}