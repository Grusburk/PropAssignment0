package prop.assignment0;

import java.io.IOException;

/**
 * Created by matt on 2016-11-02.
 */
public class Parser implements IParser {

	private Tokenizer tokenizer;

	public Parser() {

	}

	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		tokenizer = new Tokenizer();
		tokenizer.open(fileName);
	}

	@Override
	public INode parse() throws IOException, TokenizerException, ParserException {
		tokenizer.moveNext();
		INode rootNode = constructBlockNode();
		return rootNode;
	}

//    // block = '{' , stmts , '}' ;
//
	private INode constructBlockNode() throws IOException, ParserException, TokenizerException {
		BlockNode blockNode = new BlockNode();
		if (tokenizer.current().token() == Token.LEFT_CURLY){
			blockNode.setLexemeLeftCurly(tokenizer.current());
			tokenizer.moveNext();
		}else {
			throwParserExcep();
		}

		blockNode.setStmtNode(constructStmtsNode());

		if (tokenizer.current().token() == Token.RIGHT_CURLY){
			blockNode.setLexemeRightCurly(tokenizer.current());
		}else {
			throwParserExcep();
		}
		return blockNode;
	}
//
//	// stmts = [ assign , stmts ] ;
//
	private INode constructStmtsNode() throws TokenizerException, ParserException, IOException {
		StatementsNode statementsNode = new StatementsNode();
		switch (tokenizer.current().token()){
			case IDENT:
			statementsNode.setAssignNode(constructAssignNode());
	 		statementsNode.setStmtsNode(constructStmtsNode());
				break;
			case RIGHT_CURLY:
				break;
			default:
				throwParserExcep();
		}
		return statementsNode;
	}

	private INode constructAssignNode() throws IOException, TokenizerException, ParserException {
		AssignmentNode assignNode = new AssignmentNode();
		switch (tokenizer.current().token()){
			case IDENT:
			case ASSIGN_OP:
			case SEMICOLON:
				if (tokenizer.current().token() == Token.IDENT) {
					assignNode.setLexemeCurrent(tokenizer.current());
					tokenizer.moveNext();
				}
				if (tokenizer.current().token() == Token.ASSIGN_OP){
					assignNode.setLexemeOp(tokenizer.current());
					tokenizer.moveNext();
				}
				assignNode.setChild(constructExprNode());
				if (tokenizer.current().token() == Token.SEMICOLON){
					assignNode.setLexemeId(tokenizer.current());
					tokenizer.moveNext();
				}
				break;
			default:
				throwParserExcep();
		}
		return assignNode;
	}

	private INode constructExprNode() throws IOException, TokenizerException, ParserException {
		ExpressionNode exprNode = new ExpressionNode();
		exprNode.setTermNode(constructTermNode());
		if(tokenizer.current().token() == Token.ADD_OP || tokenizer.current().token() == Token.SUB_OP) {
				exprNode.setLexeme(tokenizer.current());
				tokenizer.moveNext();
				exprNode.setExprNode(constructExprNode());
		} else if (tokenizer.current().token() != Token.RIGHT_PAREN && tokenizer.current().token() != Token.SEMICOLON ){
			throwParserExcep();
		}
		return exprNode;
	}


	private INode constructTermNode() throws IOException, TokenizerException, ParserException {
		TermNode termNode = new TermNode();
		termNode.setFactorNode(constructFactorNode());
		switch (tokenizer.current().token()){
			case MULT_OP:
			case DIV_OP:
				termNode.setLexeme(tokenizer.current());
				tokenizer.moveNext();
				termNode.setTermNode(constructTermNode());
				break;
			case LEFT_CURLY:
			case RIGHT_CURLY:
			case LEFT_PAREN:
			case NULL:
			case EOF:
			case ASSIGN_OP:
				throwParserExcep();
				break;
			default:
		}
		return termNode;
	}

	private INode constructFactorNode() throws IOException, TokenizerException, ParserException {
		FactorNode factorNode = new FactorNode();

		switch (tokenizer.current().token()){
			case INT_LIT:
			case IDENT:
				factorNode.setLexemeId(tokenizer.current());
				tokenizer.moveNext();
				break;
			case LEFT_PAREN:
				factorNode.setLexemeId(tokenizer.current());
				tokenizer.moveNext();
				factorNode.setExprNode(constructExprNode());
				if (tokenizer.current().token() == Token.RIGHT_PAREN){
					factorNode.setLexemeOp(tokenizer.current());
					tokenizer.moveNext();
				}
				break;
			default:
				throwParserExcep();
			break;
		}
		return factorNode;
	}

	private void throwParserExcep() throws ParserException{
		throw new ParserException(tokenizer.current().token() + " This token is in the wrong node.");
	}

    @Override
    public void close() throws IOException {
		tokenizer.close();
    }
}
