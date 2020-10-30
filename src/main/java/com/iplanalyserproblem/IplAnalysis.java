package com.iplanalyserproblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.iplanalyserproblem.SortedField.Field;
import com.newcsvhandler.CSVBuilderException;
import com.newcsvhandler.CSVBuilderFactory;
import com.newcsvhandler.ICSVBuilder;

public class IplAnalysis 
{
	List<IplCSVBatsman> iplCsvBatsmanList = new ArrayList<>();
	List<IplCSVBowler> iplCsvBowlerList=new ArrayList<>();
	List<IplCSVALLRounder> iplCsvALLRounderList=new ArrayList<>();
	public int loadCricketIPLCSVData(String csvFilePath) throws IplAnalysisException 
	{
		 try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
	            ICSVBuilder csvbuilder = CSVBuilderFactory.createCSVBuilder();
	            iplCsvBatsmanList= csvbuilder.getCSVFileList(reader, IplCSVBatsman.class);
	            return iplCsvBatsmanList.size();

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
	        if (iplCsvBatsmanList == null || iplCsvBatsmanList.size() == 0) {
	            throw new IplAnalysisException("No Census Data", IplAnalysisException.ExceptionType.DATA_NOT_FOUND);
	        }
	        Comparator<IplCSVBatsman> iplFieldComparator = SortedField.getComparatorField(field);
	        iplCsvBatsmanList.sort(iplFieldComparator);
	        return new Gson().toJson(iplCsvBatsmanList);
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
	public String getSortedIPLAllRounderRecords(SortedField.Field field) throws IplAnalysisException
	{
		for(int ibat = 0; ibat < iplCsvBatsmanList.size(); ibat++) 
		{
			for(int ibowl = 0; ibowl < iplCsvBowlerList.size(); ibowl++)
			{
				if(iplCsvBatsmanList.get(ibat).player.matches((iplCsvBowlerList).get(ibowl).player)) 
				{
					IplCSVALLRounder allRounderPlayerData = new IplCSVALLRounder(iplCsvBatsmanList.get(ibat).player, iplCsvBatsmanList.get(ibat).runs,iplCsvBatsmanList.get(ibat).average, iplCsvBowlerList.get(ibowl).average,iplCsvBowlerList.get(ibowl).wickets);
					iplCsvALLRounderList.add(allRounderPlayerData);
				}
			}
		}
		Comparator<IplCSVALLRounder> iplFieldComparator = SortedField.getAllRounderComparatorField(field);
        iplCsvALLRounderList.sort(iplFieldComparator);
        return new Gson().toJson(iplCsvALLRounderList);
	}
	public String getSortedZeroFiftyAndBestAverageRecords(SortedField.Field field) throws IplAnalysisException 
	 {	
		List<IplCSVBatsman> csvZero100and50BestAverageList= iplCsvBatsmanList.stream()
				.filter(batsman -> (batsman.fiftys==0)&& (batsman.hundreds==0))
				.collect(Collectors.toList());
			 Comparator<IplCSVBatsman> iplFieldComparator = SortedField.getComparatorField(field);
	         csvZero100and50BestAverageList.sort(iplFieldComparator);
	         return new Gson().toJson(csvZero100and50BestAverageList);
	}
}
