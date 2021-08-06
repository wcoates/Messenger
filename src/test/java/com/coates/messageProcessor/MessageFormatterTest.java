
package com.coates.messageProcessor;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class MessageFormatterTest {
	private final MessageFormatter messageFormatter;

	final int width = 20;
	final int userWidth = 5;
	final String leftBorderPattern = "\"|";
	final String rightBorderPattern = "|\"";
	final String centerBorderPattern = "*";
	final String message = "A message";
	final int padAmount = 5;

	private MessageFormatterTest() {
		this.messageFormatter = new MessageFormatter(leftBorderPattern, rightBorderPattern,
				centerBorderPattern, width);
	}

	@Test
	void testGeneratePadding() {
		assertEquals("     ", messageFormatter.generatePadding(padAmount));
	}

	@Test
	void testAddLeftRightBorder() {
		assertEquals(leftBorderPattern + message + rightBorderPattern,
				messageFormatter.addLeftRightBorder(message));
	}

	@Test
	void testCreateOutsideBorder() {
		assertEquals(leftBorderPattern + "****************" + rightBorderPattern,
				messageFormatter.createOutsideBorder());
	}

	@Test
	void testDuplicateCharacters() {
		assertEquals("*****", messageFormatter.duplicateCharacters("*", 5));
	}

	@Test
	void testGetCenterSize() {
		assertEquals(width - leftBorderPattern.length() - rightBorderPattern.length(),
				messageFormatter.getCenterSize());
	}

	@Test
	void testAlignText() {
		assertEquals("A message       ", messageFormatter.alignText(message, 1));
		assertEquals("       A message", messageFormatter.alignText(message, 2));
	}
}
