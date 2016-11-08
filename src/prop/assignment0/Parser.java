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
		//
		AssignNode rootNode = new AssignNode();
		rootNode.setLeftNode(new AssignNode(tokenizer.current()));
		tokenizer.moveNext();
		rootNode.setValue(tokenizer.current());

		// while loop, kolla typ(tokenizer.current().token(), assigna vänster, value eller höger beroende på typ och regel.

		//tokenizer.moveNext();
		//rootNode.setRightNode(new ExprNode(tokenizer.current()));

		switch (tokenizer.current().token()) {
			case LEFT_CURLY:
			case RIGHT_CURLY:

				break;
			case ASSIGN_OP:
			case SEMICOLON:
			case IDENT:

				break;
			case ADD_OP:
			case SUB_OP:

				break;
			case DIV_OP:
			case MULT_OP:

				break;
			case LEFT_PAREN:
			case RIGHT_PAREN:
			case INT_LIT:

				break;
		}
        return rootNode;
    }

	private INode constructAssignNode() {
		AssignNode assignNode = new AssignNode();
        return null;
	}
	
	private INode constructBlockNode() {
		//BlockNode blockNode = new BlockNode();
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
