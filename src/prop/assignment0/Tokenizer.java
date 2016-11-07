package prop.assignment0;

import java.io.IOException;

import static java.awt.font.GlyphMetrics.WHITESPACE;

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

    @Override
    public void moveNext() throws IOException, TokenizerException {
		removeWhiteSpace();
		char inputChar = scanner.current();
		if (inputChar >= 'a' && inputChar <='z') {
			current = produceIdentifier(inputChar);
		}else if(inputChar >= '0' && inputChar <='9'){
			current = produceInt(inputChar);
		}else{
			switch (inputChar) {
				case '+':
					current = produceAddOp(inputChar);
					break;
				case '=':
					current = produceAssign(inputChar);
					break;
				case '-':
					current = produceSubOp(inputChar);
					break;
				case '*':
					current = produceMultOp(inputChar);
					break;
				case '/':
					current = produceDivOp(inputChar);
					break;
				default:
					break;
			}
		}
    }

	private Lexeme produceInt(char inputChar) {
		return new Lexeme(0,Token.INT_LIT);
	}

	private Lexeme produceAddOp(char inputChar) {
		return new Lexeme(0,Token.ADD_OP);
	}

	private Lexeme produceMultOp(char inputChar) {
		return new Lexeme(0,Token.MULT_OP);
	}

	private Lexeme produceSubOp(char inputChar) {
		return new Lexeme(0,Token.SUB_OP);
	}

	private Lexeme produceDivOp(char inputChar) {
		return new Lexeme(0,Token.DIV_OP);
	}

	private Lexeme produceIdentifier(char inputChar) {
		return new Lexeme(0,Token.IDENT);
	}

	private Lexeme produceAssign(char input){
		return new Lexeme(0,Token.ASSIGN_OP);
	}

    @Override
    public void close() throws IOException {

    }
	
	private void removeWhiteSpace () throws IOException {
		while (scanner.current() == WHITESPACE){
			scanner.moveNext();
		}
	}
}
