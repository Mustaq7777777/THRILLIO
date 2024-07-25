package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// test1
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);

		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("for moive of genre thrillers isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// test2

		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);

		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("for moive of genre horror isKidFriendlyEligible() must return false", isKidFriendlyEligible);

	}

}
