package prop.assignment0;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by matt on 2016-11-02.
 */
public class Parser implements IParser {
	
	private Tokenizer tokenizer;
	private ArrayList<INode> senteces = new ArrayList<>();
	public Parser (){
		
	}
	
    @Override
    public void open(String fileName) throws IOException, TokenizerException {
		tokenizer = new Tokenizer();
		tokenizer.open(fileName);
    }

    @Override
    public INode parse() throws IOException, TokenizerException, ParserException {
//        return parseText;
        return null;
    }
	
	private INode parseText(){
		//while(!EOF){
			//senteces.add(parseSentence());
			//tokenizer.moveNext();
		//}
		// return new textNode(senteces);
		return null;
	}
	
	private INode parseSentence() {
		//NodeClass nodeClass = parseXXNode
        return null;
	}
	
	private INode parseXXNode() {
	//	determinerNode dn = parseDeterminer();
        return null;
	}
	
	private INode parseDeterminer(){
		// if(tokenizer.current().token == Token.Determiner;
//		return new determinerNode(t.current());
		return null;
	}

    @Override
    public void close() throws IOException {

    }
}
