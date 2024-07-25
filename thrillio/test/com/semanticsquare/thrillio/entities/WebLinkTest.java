package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {

		// test1

		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");

		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("for porn in weblink url isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// test2

		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("for porn in weblink title isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		//test3
		
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld_adult.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("for adult  in weblink host isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		//test4
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming tiger adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertTrue("for adult  in weblink host isKidFriendlyEligible() must return false", isKidFriendlyEligible);
		
		//test5
		
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertTrue("for adult  in weblink host isKidFriendlyEligible() must return false", isKidFriendlyEligible);
	}

}
