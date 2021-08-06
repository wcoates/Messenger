
package com.coates.messenger;

import com.coates.messageProcessor.MessageProcessor;

public class Main {
	public static void main(String[] args) {
		final int width = 50;
		final int userWidth = 23;
		final String leftBorderPattern = "\"|";
		final String rightBorderPattern = "|\"";
		final String centerBorderPattern = "*";
		final String[][] messages =
				{
						{"Hi, how are you?", "1"},
						{"I'm doing pretty good", "2"},
						{"Perfect", "1"},
						{"I don't understand why quotes are escaped here differently than there",
								"1"}};

		MessageProcessor messageProcessor = new MessageProcessor(messages, width, userWidth,
				leftBorderPattern, rightBorderPattern, centerBorderPattern);

		for (final String messageLine : messageProcessor.processMessages()) {
			System.out.println(messageLine);
		}
	}
}
