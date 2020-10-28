package com.iplanalyserproblem;

public class IplAnalysisException extends Exception{
	 enum ExceptionType
	    {
	        ENTERED_NULL,DATA_NOT_FOUND;
	    }
	    ExceptionType type;
	    public IplAnalysisException(String message, String name) {
	        super(message);
	        this.type = ExceptionType.valueOf(name);
	    }

	    public IplAnalysisException(String message, ExceptionType type) {
	        super(message);
	        this.type = type;
	    }
	    public IplAnalysisException(String message, ExceptionType type, Throwable cause) {
	        super(message,cause);
	        this.type = type;
	    }
}
