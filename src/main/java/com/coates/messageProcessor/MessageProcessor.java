
package com.coates.messageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Formats messages for user 1 and user 2.
 * 
 * @param messages the messages to be formatted (in the form of [String msg][int user])
 * @param width the maximum screen width
 * @param userWidth maximum length for words before needing wrap
 * @param leftBorderPattern appended to the left side of the message line or center border
 * @param rightBorderPattern appended to the right side of the message line or center border
 * @param centerBorderPattern fills the center space of the outside screen borders
 */
public class MessageProcessor {
	private final String[][] messages;
	private final int userWidth;
	private final MessageFormatter formatter;

	public MessageProcessor(final String[][] messages, final int width, final int userWidth,
			final String leftMessageBorder, final String rightMessageBorder,
			final String centerBorderPattern)
	{
		this.messages = messages;
		this.formatter =
				new MessageFormatter(leftMessageBorder, rightMessageBorder, centerBorderPattern, width);
		this.userWidth = userWidth;

	}

	public final String[] processMessages() {
		final List<String> displayMessages = new ArrayList<>();
		final String outsideBorder = formatter.createOutsideBorder();

		for (int i = 0; i < messages.length; i++) {
			final String messageToProcess = messages[i][0];
			final int user = Integer.parseInt(messages[i][1]);

			wrapWords(messageToProcess).forEach(wrappedMessage -> {
				displayMessages.add(
						formatter.addLeftRightBorder(formatter.alignText(wrappedMessage, user)));
			});
		}
		// add top and bottom borders
		displayMessages.add(0, outsideBorder);
		displayMessages.add(outsideBorder);

		return displayMessages.toArray(new String[displayMessages.size()]);
	}

	private final List<String> wrapWords(String message) {
		final List<String> messagesWithWrapping = new ArrayList<>();
		String previousWord = "";

		if (message.length() <= userWidth) {
			messagesWithWrapping.add(message);
			return messagesWithWrapping;
		}

		/**
		 * TODO: improve this logic; Logic is to determine how many words can go into the line
		 * before exceeding the // userWidth
		 */
		for (String word : message.split(" ")) {
			int combinedWordLength = previousWord.isEmpty() ? word.length()
					: previousWord.length() + word.length() + 1;

			if (combinedWordLength > userWidth) {
				if (!previousWord.isEmpty()) {
					messagesWithWrapping.add(previousWord);
					previousWord = word;
				}
			} else {
				previousWord = previousWord.isEmpty() ? word : previousWord + " " + word;
			}
		}

		if (!previousWord.isEmpty()) {
			messagesWithWrapping.add(previousWord);
		}

		return messagesWithWrapping;
	}



}
