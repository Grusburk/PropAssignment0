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
		tokenizer.moveNext();
    }

    @Override
    public INode parse() throws IOException, TokenizerException, ParserException {
//        return parseText;
        return null;
    }
	
	private INode parseText(){
		//while(!EOF){
			//sentences.add(parseSentence());
			//tokenizer.moveNext();
		//}
		// return new textNode(sentences);
		return null;
	}
	
	private INode constructAssignNode() {
		AssignNode assignNode = new AssignNode();
        return null;
	}
	
	private INode constructBlockNode() {
		BlockNode blockNode = new BlockNode();
        return null;
	}
	
	private INode constructExprNode(){
		ExprNode exprNode = new ExprNode();
		return null;
	}

	private INode constructFactorNode(){
		FactorNode factorNode = new FactorNode();
		return null;
	}

	private INode constructStmtsNode(){
		StmtsNode stmtsNode = new StmtsNode();
		return null;
	}

	private INode constructTermNode(){
		TermNode termNode = new TermNode();
		return null;
	}

    @Override
    public void close() throws IOException {

    }
}
