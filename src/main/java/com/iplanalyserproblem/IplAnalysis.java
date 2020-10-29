package com.iplanalyserproblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.newcsvhandler.CSVBuilderException;
import com.newcsvhandler.CSVBuilderFactory;
import com.newcsvhandler.ICSVBuilder;

public class IplAnalysis 
{
	List<IplCSVBatsman> iplCsvList = new ArrayList<>();
	List<IplCSVBowler> iplCsvBowlerList=new ArrayList<>();
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
	 public String getSortIPLCricketRecords(SortedField.Field field) throws IplAnalysisException 
	 {
	        if (iplCsvList == null || iplCsvList.size() == 0) {
	            throw new IplAnalysisException("No Census Data", IplAnalysisException.ExceptionType.DATA_NOT_FOUND);
	        }
	        Comparator<IplCSVBatsman> iplFieldComparator = SortedField.getComparatorField(field);
	        iplCsvList.sort(iplFieldComparator);
	        return new Gson().toJson(iplCsvList);
	}
	public int loadCricketBowlerIPLCSVData(String csvBowlerFilePath) throws IplAnalysisException
	{
		 try (Reader reader = Files.newBufferedReader(Paths.get(csvBowlerFilePath));) {
	            ICSVBuilder csvbuilder = CSVBuilderFactory.createCSVBuilder();
	            iplCsvBowlerList= csvbuilder.getCSVFileList(reader, IplCSVBowler.class);
	            return iplCsvBowlerList.size();

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
	public String getSortIPLBowlerRecords(SortedField.Field field) throws IplAnalysisException 
	 {
	        if (iplCsvBowlerList == null || iplCsvBowlerList.size() == 0) {
	            throw new IplAnalysisException("No Census Data", IplAnalysisException.ExceptionType.DATA_NOT_FOUND);
	        }
	        Comparator<IplCSVBowler> iplFieldComparator = SortedField.getBowlingComparatorField(field);
	        iplCsvBowlerList.sort(iplFieldComparator);
	        return new Gson().toJson(iplCsvBowlerList);
	}
}
