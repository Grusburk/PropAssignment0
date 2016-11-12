package prop.assignment0;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by matt on 2016-11-02.
 */
public class Parser implements IParser {
	
	private Tokenizer tokenizer;
	private ArrayList<INode> senteces = new ArrayList<>();
	private AssignNode assignNode;
	ExprNode exprNode;
	TermNode termNode;
	FactorNode factorNode;
	public Parser (){
		
	}
	
    @Override
    public void open(String fileName) throws IOException, TokenizerException {
		tokenizer = new Tokenizer();
		tokenizer.open(fileName);
    }

    @Override
    public INode parse() throws IOException, TokenizerException, ParserException {
		tokenizer.moveNext();
		INode node = assignNode;
		return assignNode;
    }

	// assign = id , '=' , expr , ';' ;

	private INode constructAssignNode() throws IOException, TokenizerException {
		assignNode = new AssignNode();
		assignNode.setLexemeId(tokenizer.current());
		tokenizer.moveNext();
		if (tokenizer.current().token() == Token.ASSIGN_OP){
			assignNode.setLexemeOp(tokenizer.current());
			tokenizer.moveNext();
		}
		assignNode.setChild(constructExprNode());
		return assignNode;
	}

	//expr = term , [ ( '+' | '-' ) , expr ] ;

	private INode constructExprNode() throws IOException, TokenizerException {
		exprNode = new ExprNode();
		exprNode.setTermNode(constructTermNode());
		if (tokenizer.current().token() == Token.SUB_OP || tokenizer.current().token() == Token.ADD_OP) {
			exprNode.setLexeme(tokenizer.current());
			tokenizer.moveNext();
			exprNode.setExprNode(constructExprNode());
		}
		return exprNode;
	}

	// term = factor , [ ( '*' | '/') , term] ;

	private INode constructTermNode() throws IOException, TokenizerException {
		termNode = new TermNode();
		termNode.setLexeme(tokenizer.current());
		if (tokenizer.current().token() == Token.DIV_OP || tokenizer.current().token() == Token.MULT_OP) {
			termNode.setLexeme(tokenizer.current());
			tokenizer.moveNext();
			termNode.setTermNode(constructTermNode());
		}
		return termNode;
	}

	// factor = int | '(' , expr , ')' ;

	private INode constructFactorNode() throws IOException, TokenizerException {
		factorNode = new FactorNode();

		if(tokenizer.current().token() == Token.INT_LIT) {
			factorNode.setLexemeId(tokenizer.current());
			tokenizer.moveNext();
		}

		factorNode.setExprNode(constructExprNode());
		tokenizer.moveNext();
//		factorNode.setRightNode(exprNode.getRightNode());
		return factorNode;
	}

//	private INode constructBlockNode() {
//		//BlockNode blockNode = new BlockNode();
//        return null;
//	}
//
//	private INode constructStmtsNode(){
//		StmtsNode stmtsNode = new StmtsNode();
//		return null;
//	}


    @Override
    public void close() throws IOException {

    }
}
