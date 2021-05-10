package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import utilities.*;

/**
 * XML Paser class
 * This class to print all lines that are not properly constructed in the order in which the erros occur.
 * 
 * Firstly, read each line by using bufferedReader and just store tags to stack(closing tags) and queue(opening tag).
 * By using peek methods, each object from stack and queue are compared and then if they are match, they are deleted or
 * if they are not match, they are stored to errorQueue and errorStack to compare to next tags.
 * If even the next comparing fails, they are printed as a failed construction.
 * 
 * @author Jaehan Kim, Donghyun Kim, Maria Laura Diaz Pena
 * @version April 2, 2021
 */
public class XMLParser {

	/**
	 * XMLParser main method to check the validity whether XML tags are well
	 * structured.
	 * 
	 * @param args xml file to read
	 */
	public static void main(String[] args) {

		MyStack stack = new MyStack();
		MyQueue queue = new MyQueue();
		MyQueue errorQueue = new MyQueue();
		MyStack errorStack = new MyStack();

		// Set the default directory to load a file
		String filePath = "res/" + args[0];
		String curLine, input, collector = "";
		char curChar;
		boolean open = false;
		boolean openingTag = true;
		boolean closingTag = false;
		boolean ignore = false;
		int errorCount = 0;
		File file = new File(filePath);

		// Load a file
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);

			// Read Each line
			while ((input = bufReader.readLine()) != null) {
				curLine = input.trim();

				// Read each character to get tags
				for (int i = 0; i < curLine.length(); i++) {
					curChar = curLine.charAt(i);

					// Identify closing, opening, selfclosing tags
					switch (curChar) {
					case '<': {
						if (!open) {
							collector += "<";
							open = true;
						} else
							break;
					}
						break;
					case '>': {
						if (open) {
							String[] tokens = collector.split(" ");
							String tokenLastSplit = tokens[tokens.length - 1];
							if (tokenLastSplit.contains("/") && tokenLastSplit.indexOf("/") != 1) {
								collector = tokens[0] + "/>";
							} else {
								collector = tokens[0] + ">";
							}
							if (openingTag) {
								queue.enqueue(collector);
							} else if (closingTag) {

								if (collector.indexOf("/") == 1) {
									collector = collector.replace("/", "");
									stack.push(collector);
								}
							}
							open = false;
							closingTag = false;
							openingTag = true;
							collector = "";
						} else
							break;
					}
						break;
					case '/': {
						if (open) {
							collector += "/";
							closingTag = true;
							openingTag = false;
						}
					}
						break;
					case '?': {
						ignore = true;
					}
						break;
					default: {
						if (open) {
							collector += Character.toString(curChar);
						} else
							break;
					}
					}
					if (ignore) {
						ignore = false;
						break;
					}
				}
			}

			// If closing and opening tags are not matched, they are stored errorQueue and
			// errorStack to compare to next tags.
			while (!stack.isEmpty() && !queue.isEmpty()) {
				if (queue.peek().equals(stack.peek())) {
					queue.dequeue();
					stack.pop();
				} else {
					if (!errorQueue.isEmpty() || !errorStack.isEmpty()) {

						if (errorQueue.peek().equals(stack.peek()) && errorStack.peek().equals(queue.peek())) {
							errorCount = 0;
							System.out.println("Error Tag is " + (String) errorQueue.dequeue());
							StringBuffer sb = new StringBuffer();
							sb.append((String) errorStack.pop());
							sb.insert(1, "/");
							System.out.println("Error Tag is " + sb);
						}

						else if (errorQueue.peek().equals(stack.peek())) {
							errorQueue.dequeue();
							stack.pop();
							errorCount = 0;
							StringBuffer sb = new StringBuffer();
							sb.append((String) errorStack.pop());
							sb.insert(1, "/");
							System.out.println("Error Tag is " + sb);
						}

						else if (errorStack.peek().equals(queue.peek())) {
							errorStack.pop();
							queue.dequeue();
							errorCount = 0;
							System.out.println("Error Tag is " + (String) errorQueue.dequeue());
						} else {
							errorCount++;
							System.out.println("Error Tag is " + (String) errorQueue.dequeue());
							StringBuffer sb = new StringBuffer();
							sb.append((String) errorStack.pop());
							sb.insert(1, "/");
							System.out.println("Error Tag is " + sb);
							errorQueue.enqueue(queue.dequeue());
							errorStack.push(stack.pop());
						}

					} else {
						errorQueue.enqueue(queue.dequeue());
						errorStack.push(stack.pop());
						errorCount++;
					}
				}
			}

			// If there is any error stored in the error stack or error queue, the error
			// message is printed out.
			while (!errorStack.isEmpty() && !errorQueue.isEmpty()) {
				int errorStackIndex;
				for (int i = 0; i < errorQueue.size(); i++) {
					errorStackIndex = errorStack.search(errorQueue.peek());
					if (errorStackIndex != -1) {
					} else {
						System.out.println("Error Tag is " + (String) errorQueue.dequeue());
					}
				}
				while (errorStack.isEmpty()) {
					StringBuffer sb = new StringBuffer();
					sb.append((String) errorStack.pop());
					sb.insert(1, "/");
					System.out.println("Error Tag is " + sb);
				}
			}

			// If the xml file does not have any error, the confirmation message is printed
			// out.
			if (errorCount == 0) {
				System.out.println("Clean XML Code.");
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}