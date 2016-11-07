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
		switch (inputChar){
			case 'a':
//				current = produceDeterminer();
				break;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
				// bla bla bla
				break;
			default:
		}
    }
	
//	private char produceDeterminer(){
//		if (char != 'a'){
//			return null;
//		}
//		return inputChar;
//	}

    @Override
    public void close() throws IOException {

    }
	
	private void removeWhiteSpace () throws IOException {
		while (scanner.current() == WHITESPACE){
			scanner.moveNext();
		}
	}
}
