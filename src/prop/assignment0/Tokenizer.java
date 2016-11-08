package prop.assignment0;

import java.io.IOException;

/**
 * Created by matt on 2016-11-02.
 */
public class Tokenizer implements ITokenizer {
	private Scanner scanner;
	private Lexeme current;
	
	public Tokenizer() {
		
	}
	
    @Override
    public void open(String fileName) throws IOException, TokenizerException {
		scanner = new Scanner();
		scanner.open(fileName);
		scanner.moveNext();
    }

    @Override
    public Lexeme current() {
        return current;
    }

    public void skipWhiteSpace() throws IOException {
		while (Character.isWhitespace(scanner.current())){
			scanner.moveNext();
		}
	}

    @Override
    public void moveNext() throws IOException, TokenizerException {
		skipWhiteSpace();
		char inputChar = scanner.current();
		setLexeme(inputChar);
		scanner.moveNext();
    }

	private void setLexeme(char inputChar) throws IOException, TokenizerException {
		if (inputChar >= 'a' && inputChar <='z') {
			current = new Lexeme(inputChar, Token.IDENT);
		}else if(inputChar >= '0' && inputChar <='9'){
			current = new Lexeme(inputChar, Token.INT_LIT);
		}else if (inputChar == Scanner.EOF) {
			current = new Lexeme(inputChar, Token.EOF);
		} else{
			switch (inputChar) {
				case '{':
					current = new Lexeme('{', Token.LEFT_CURLY);
					break;
				case '}':
					current = new Lexeme('}', Token.RIGHT_CURLY);
					break;
				case '(':
					current = new Lexeme('(', Token.LEFT_PAREN);
					break;
				case ')':
					current = new Lexeme(')', Token.RIGHT_PAREN);
					break;
				case ';':
					current = new Lexeme(';', Token.SEMICOLON);
					break;
				case '+':
					current = new Lexeme('+',Token.ADD_OP);
					break;
				case '=':
					current = new Lexeme('=',Token.ASSIGN_OP);
					break;
				case '-':
					current = new Lexeme('-',Token.SUB_OP);
					break;
				case '*':
					current = new Lexeme('*',Token.MULT_OP);
					break;
				case '/':
					current = new Lexeme('/',Token.DIV_OP);
					break;
				default:
					throw new TokenizerException("Wrong input " + inputChar);
			}
		}
	}

	@Override
    public void close() throws IOException {

    }
}
