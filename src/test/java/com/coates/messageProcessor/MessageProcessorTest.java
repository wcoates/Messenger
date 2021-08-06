
package com.coates.messageProcessor;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class MessageProcessorTest {
	private final MessageProcessor messageProcessor;

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
					{"I don't understand why quotes are escaped here differently than there", "1"}};

	private MessageProcessorTest() {
		this.messageProcessor = new MessageProcessor(messages, width, userWidth, leftBorderPattern,
				rightBorderPattern, centerBorderPattern);
	}

	@Test
	void testProcessMessages() {
		String[] processedMessages = messageProcessor.processMessages();

		assertEquals("\"|**********************************************|\"", processedMessages[0]);
		assertEquals("\"|Hi, how are you?                              |\"", processedMessages[1]);
		assertEquals("\"|                         I'm doing pretty good|\"", processedMessages[2]);
		assertEquals("\"|Perfect                                       |\"", processedMessages[3]);
		assertEquals("\"|I don't understand why                        |\"", processedMessages[4]);
		assertEquals("\"|quotes are escaped here                       |\"", processedMessages[5]);
		assertEquals("\"|differently than there                        |\"", processedMessages[6]);
		assertEquals("\"|**********************************************|\"", processedMessages[7]);
	}
}
