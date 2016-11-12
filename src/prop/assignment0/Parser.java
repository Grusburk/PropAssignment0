package prop.assignment0;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by matt on 2016-11-02.
 */
public class Parser implements IParser {
	
	private Tokenizer tokenizer;
	private ArrayList<INode> senteces = new ArrayList<>();
	private AssignmentNode assignNode;
	ExpressionNode exprNode;
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
		INode node = constructAssignNode();
		return node;
    }

	// assign = id , '=' , expr , ';' ;

	private INode constructAssignNode() throws IOException, TokenizerException {
		assignNode = new AssignmentNode(tokenizer.current());
		tokenizer.moveNext();
		if (tokenizer.current().token() == Token.ASSIGN_OP){
			assignNode.setLexemeOp(tokenizer.current());
			tokenizer.moveNext();
		}

		assignNode.setChild(constructExprNode());

		if (tokenizer.current().token() == Token.SEMICOLON){
			assignNode.setLexemeId(tokenizer.current());
			tokenizer.moveNext();
		}

		return assignNode;
	}

	//expr = term , [ ( '+' | '-' ) , expr ] ;

	private INode constructExprNode() throws IOException, TokenizerException {
		exprNode = new ExpressionNode();
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
		termNode.setFactorNode(constructFactorNode());

		if (tokenizer.current().token() == Token.MULT_OP || tokenizer.current().token() == Token.DIV_OP){
			termNode.setLexeme(tokenizer.current());
			tokenizer.moveNext();
			termNode.setTermNode(constructTermNode());
		}

		return termNode;
	}

	// factor = int | '(' , expr , ')' ;

	private INode constructFactorNode() throws IOException, TokenizerException {
		factorNode = new FactorNode();

		switch (tokenizer.current().token()){
			case INT_LIT:
			case IDENT:
				factorNode.setLexemeId(tokenizer.current());
				tokenizer.moveNext();
				break;
			case LEFT_PAREN:
				factorNode.setLexemeOp(tokenizer.current());
				tokenizer.moveNext();
				factorNode.setExprNode(constructExprNode());
			if (tokenizer.current().token() == Token.RIGHT_PAREN){
				factorNode.setLexemeOp(tokenizer.current());
				tokenizer.moveNext();
			}
			break;
		}
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
