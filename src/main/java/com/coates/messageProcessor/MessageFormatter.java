
package com.coates.messageProcessor;

/**
 * Utility for formatting a given message or adding screen borders.
 */
class MessageFormatter {
	private final String leftBorderPattern;
	private final String rightBorderPattern;
	private final String centerBorderPattern;
	private final int width;

	public MessageFormatter(String leftBorderPattern, String rightBorderPattern,
			String centerBorderPattern, int width)
	{
		this.leftBorderPattern = leftBorderPattern;
		this.rightBorderPattern = rightBorderPattern;
		this.centerBorderPattern = centerBorderPattern;
		this.width = width;
	}

	public final String generatePadding(int padAmount) {
		return duplicateCharacters(" ", padAmount);
	}

	public final String addLeftRightBorder(String message) {
		return leftBorderPattern + message + rightBorderPattern;
	}

	public final String createOutsideBorder() {
		return leftBorderPattern + duplicateCharacters(centerBorderPattern, getCenterSize())
				+ rightBorderPattern;
	}

	public final String duplicateCharacters(String duplicateCharacter, int timesToDuplicate) {
		String duplicatedCharacters = "";

		for (int i = 0; i < timesToDuplicate; i++) {
			duplicatedCharacters += duplicateCharacter;
		}

		return duplicatedCharacters;
	}

	public final int getCenterSize() {
		return width - leftBorderPattern.length() - rightBorderPattern.length();
	}

	public final String alignText(final String text, final int user) {
		final int requiredPadding =
				width - leftBorderPattern.length() - rightBorderPattern.length() - text.length();
		final String padding = generatePadding(requiredPadding);

		return user == 1 ? text + padding : padding + text;
	}
}
