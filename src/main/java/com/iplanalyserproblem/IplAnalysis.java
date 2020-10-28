package com.iplanalyserproblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.newcsvhandler.CSVBuilderException;
import com.newcsvhandler.CSVBuilderFactory;
import com.newcsvhandler.ICSVBuilder;

public class IplAnalysis 
{
	List<IplCSVBatsman> iplCsvList = new ArrayList<>();
	public int loadCricketIPLCSVData(String csvFilePath) throws IplAnalysisException 
	{
		 try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
	            ICSVBuilder csvbuilder = CSVBuilderFactory.createCSVBuilder();
	            iplCsvList= csvbuilder.getCSVFileList(reader, IplCSVBatsman.class);
	            return iplCsvList.size();

	        }
		 	catch (IOException e) {
	            throw new IplAnalysisException(e.getMessage(),IplAnalysisException.ExceptionType.DATA_NOT_FOUND);
	        } 
		 	catch (RuntimeException e) {
	            throw new IplAnalysisException(e.getMessage(), IplAnalysisException.ExceptionType.FILE_ISSUE);
	        } 
		 	catch (CSVBuilderException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }
}
