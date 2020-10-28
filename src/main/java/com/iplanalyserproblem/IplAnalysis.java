package com.iplanalyserproblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IplAnalysis 
{
	public int loadCricketIPLData(String csvFilePath) throws IplAnalysisException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IplCSVBatsman> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IplCSVBatsman.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IplCSVBatsman> csvToBean = csvToBeanBuilder.build();
            Iterator<IplCSVBatsman> IPLCsvIterator = csvToBean.iterator();
            Iterable<IplCSVBatsman> csvIterable = () -> IPLCsvIterator;
            int playerCounts = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return playerCounts;
        	} 
        catch (IOException e) {
            throw new IplAnalysisException(e.getMessage(),
                    IplAnalysisException.ExceptionType.DATA_NOT_FOUND);
        }
    }
}
