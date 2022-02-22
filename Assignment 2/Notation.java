/**
 * Class that converts infix to postfix, postfix to infix, and it also evaluates
 * postfix expressions.
 * 
 * @author Saad Aulakh
 *
 */
public class Notation {

	/**
	 * Evaluates a postfix expression and returns the solution of the postfix
	 * expression
	 * 
	 * @param postFixExpr - postfix expression that user enters
	 * @return Double value - the evaluation of the postfix expression
	 * @throws InvalidNotationFormatException - thrown if the postfix expression is
	 *                                        in the wrong format
	 */
	public static double evaluatePostfixExpression(String postFixExpr) throws InvalidNotationFormatException {

		MyStack<String> stack = new MyStack<String>();

		try {
			for (int i = 0; i < postFixExpr.length(); i++) {
				if (postFixExpr.charAt(i) == ' ')
					continue;
				if (Character.isDigit(postFixExpr.charAt(i)) || postFixExpr.charAt(i) == '(')
					stack.push(Character.toString(postFixExpr.charAt(i)));

				else if (postFixExpr.charAt(i) == '+' || postFixExpr.charAt(i) == '-' || postFixExpr.charAt(i) == '/'
						|| postFixExpr.charAt(i) == '*') {
					Double second = Double.parseDouble(stack.pop());
					Double first = Double.parseDouble(stack.pop());
					Double answer = 0.0;

					switch (postFixExpr.charAt(i)) {
					case '+':
						answer = first + second;
						stack.push(answer.toString());
						break;
					case '-':
						answer = first - second;
						stack.push(answer.toString());
						break;
					case '/':
						answer = first / second;
						stack.push(answer.toString());
						break;
					case '*':
						answer = first * second;
						stack.push(answer.toString());
						break;
					}
				}

			}
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		if (stack.size() != 1)
			throw new InvalidNotationFormatException();

		return Double.parseDouble(stack.pop());
	}

	/**
	 * Converts infix expression into its postfix version
	 * 
	 * @param infix - infix expression entered by user
	 * @return String - postfix version of the infix expression
	 * @throws InvalidNotationFormatException - thrown if infix expression is in the
	 *                                        wrong format
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyQueue<Character> solutionQueue = new MyQueue<Character>();
		MyStack<Character> operators = new MyStack<Character>();

		try {

			for (int i = 0; i < infix.length(); i++) {
				if (infix.charAt(i) == ' ')
					continue;
				else if (Character.isDigit(infix.charAt(i))) {
					solutionQueue.enqueue(infix.charAt(i));
					continue;
				}

				else if (infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '/'
						|| infix.charAt(i) == '*') {
					while (precedence(infix.charAt(i)) <= precedence(operators.top()) && !operators.isEmpty()) {
						solutionQueue.enqueue(operators.top());
						operators.pop();
					}
					operators.push(infix.charAt(i));
					continue;
				} else if (infix.charAt(i) == '(') {
					operators.push(infix.charAt(i));
					continue;
				} else if (infix.charAt(i) == ')') {
					while (operators.top() != '(' && !operators.isEmpty()) {
						solutionQueue.enqueue(operators.top());
						operators.pop();
					}
					// pops the '('

					operators.pop();
					continue;
				}
				while (!operators.isEmpty()) {
					solutionQueue.enqueue(operators.top());
					operators.pop();
				}

			}
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}

		return solutionQueue.toString();
	}

	/**
	 * Converts postfix expression into its infix version
	 * 
	 * @param postfix - postfix expression entered by user
	 * @return String - infix version of the postfix expression
	 * @throws InvalidNotationFormatException - thrown if postfix expression is in
	 *                                        wrong format
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<String>();
		try {
			for (int i = 0; i < postfix.length(); i++) {
				if (postfix.charAt(i) == ' ')
					continue;
				if (Character.isDigit(postfix.charAt(i)))
					stack.push(Character.toString(postfix.charAt(i)));

				else if (postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '/'
						|| postfix.charAt(i) == '*') {
					String second = stack.pop();
					String first = stack.pop();
					String str = "(" + first + postfix.charAt(i) + second + ")";
					stack.push(str);
				}

			}
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}

		return stack.toString();

	}

	/**
	 * Checks the precedence of the operator
	 * 
	 * @param operator - either '+', '-', '/', '*'
	 * @return 1 - if operator is '/' or '*'
	 * @return 0 - if operator is '+' or '-'
	 * @return -1 - if no operator was given
	 */
	private static int precedence(char operator) {
		if (operator == '/' || operator == '*')
			return 1;
		if (operator == '+' || operator == '-')
			return 0;
		return -1;
	}
}
