package com.woden501.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import com.woden501.project.models.AutismAdult;
import com.woden501.project.utilities.DatasetUtilities;

import weka.core.Debug.Random;

public class Dataset2Loader {
	private String fileContents;
	private List<AutismAdult> adults;
	private HashMap<Double, List<AutismAdult>> randomAutismAdultHash;

	public Dataset2Loader() {
		super();
		this.fileContents = DatasetUtilities.getContents("Autism-Adult-Data.arff");
		this.adults = new ArrayList<>();
		this.randomAutismAdultHash = new HashMap<>();
		
		try {
			Stream<String> stream = Files
					.lines(Path.of(Dataset2Loader.class.getClassLoader().getResource("Autism-Adult-Data.arff").toURI()));
			stream.forEach(line -> generateAdult(line));
			stream.close();
		} catch (Exception e) {
			System.out.println("Error encountered reading dataset2. Exception: " + e.getMessage());
			System.out.println("Exiting...");
			System.exit(1);
		}
		
		binarizeAdults();
		toDisk(adults, "binarizedAutismAdults.arff");
		randomizeAdults(0.1);
		toDisk(randomAutismAdultHash.get(0.1), "0.1RandomAutismAdults.arff");
		randomizeAdults(0.2);
		toDisk(randomAutismAdultHash.get(0.2), "0.2RandomAutismAdults.arff");
		randomizeAdults(0.3);
		toDisk(randomAutismAdultHash.get(0.3), "0.3RandomAutismAdults.arff");
		randomizeAdults(0.4);
		toDisk(randomAutismAdultHash.get(0.4), "0.4RandomAutismAdults.arff");
		randomizeAdults(0.45);
		toDisk(randomAutismAdultHash.get(0.45), "0.45RandomAutismAdults.arff");
		randomizeAdults(0.51);
		toDisk(randomAutismAdultHash.get(0.51), "0.51RandomAutismAdults.arff");
		randomizeAdults(0.55);
		toDisk(randomAutismAdultHash.get(0.55), "0.55RandomAutismAdults.arff");
		randomizeAdults(0.6);
		toDisk(randomAutismAdultHash.get(0.6), "0.6RandomAutismAdults.arff");
		randomizeAdults(0.7);
		toDisk(randomAutismAdultHash.get(0.7), "0.7RandomAutismAdults.arff");
		randomizeAdults(0.8);
		toDisk(randomAutismAdultHash.get(0.8), "0.8RandomAutismAdults.arff");
		randomizeAdults(0.9);
		toDisk(randomAutismAdultHash.get(0.9), "0.9RandomAutismAdults.arff");
		randomizeAdults(1.0);
		toDisk(randomAutismAdultHash.get(1.0), "1.0RandomAutismAdults.arff");
		
		System.out.println("Data successfully loaded, modified, randomized, and written to disk");
	}
	
	private void generateAdult(String line) {
		if (!line.equals("") && !line.startsWith("@")) {
			String[] splitLine = line.split(",");
			AutismAdult adult = new AutismAdult(splitLine[0], splitLine[1], splitLine[2], splitLine[3],
										splitLine[4], splitLine[5], splitLine[6], splitLine[7],
										splitLine[8], splitLine[9], splitLine[10], splitLine[11],
										splitLine[12], splitLine[13], splitLine[14], splitLine[15],
										splitLine[16], splitLine[17], splitLine[18], splitLine[19],
										splitLine[20]);
			this.adults.add(adult);
		}
	}
	
	public void randomizeAdults(double seed) {
		List<AutismAdult> randomizedAdults = new ArrayList<>();
		
		Random rand = new Random();
		
		for (AutismAdult adult : adults) {
			double randomNumber = rand.nextDouble();
			
			if (randomNumber > seed) {
				randomizedAdults.add(adult.negate());
			} else {
				randomizedAdults.add(new AutismAdult(adult));
			}
		};
		
		this.randomAutismAdultHash.put(seed, randomizedAdults);
	}
	
	public void binarizeAdults() {
		ArrayList<IntegerPair> ageList = new ArrayList<>();
		ArrayList<StringPair> genderList = new ArrayList<>();
		ArrayList<StringPair> ethnicityList = new ArrayList<>();
		ArrayList<StringPair> jaundiceList = new ArrayList<>();
		ArrayList<StringPair> autismList = new ArrayList<>();
		ArrayList<StringPair> countryOfResList = new ArrayList<>();
		ArrayList<StringPair> usedAppBeforeList = new ArrayList<>();
		ArrayList<IntegerPair> resultList = new ArrayList<>();
		ArrayList<StringPair> ageDescList = new ArrayList<>();
		ArrayList<StringPair> relationList = new ArrayList<>();
		
		// Get lists of attributes
		for (AutismAdult adult : adults) {
			ageList.add(new IntegerPair(adult.getAge(), adult));
			genderList.add(new StringPair(adult.getGender(), adult));
			ethnicityList.add(new StringPair(adult.getEthnicity(), adult));
			jaundiceList.add(new StringPair(adult.getJaundice(), adult));
			autismList.add(new StringPair(adult.getAutism(), adult));
			countryOfResList.add(new StringPair(adult.getCountryOfRes(), adult));
			usedAppBeforeList.add(new StringPair(adult.getUsedAppBefore(), adult));
			resultList.add(new IntegerPair(adult.getResult(), adult));
			ageDescList.add(new StringPair(adult.getAgeDesc(), adult));
			relationList.add(new StringPair(adult.getRelation(), adult));
		}
		
		// Sort Lists
		Collections.sort(ageList, new IntegerComparator());
		Collections.sort(genderList, new StringComparator());
		Collections.sort(ethnicityList, new StringComparator());
		Collections.sort(jaundiceList, new StringComparator());
		Collections.sort(autismList, new StringComparator());
		Collections.sort(countryOfResList, new StringComparator());
		Collections.sort(usedAppBeforeList, new StringComparator());
		Collections.sort(resultList, new IntegerComparator());
		Collections.sort(ageDescList, new StringComparator());
		Collections.sort(relationList, new StringComparator());
		
		// Find median value
		int median = adults.size()/2;
		
		// Set binary values
		for (int i = 0; i < adults.size(); i++) {
			if (i < median) {
				ageList.get(i).adult.setAge(0);
				genderList.get(i).adult.setGender("0");
				ethnicityList.get(i).adult.setEthnicity("0");
				jaundiceList.get(i).adult.setJuandice("0");
				autismList.get(i).adult.setAutism("0");
				countryOfResList.get(i).adult.setCountryOfRes("0");
				usedAppBeforeList.get(i).adult.setUsedAppBefore("0");
				resultList.get(i).adult.setResult(0);
				ageDescList.get(i).adult.setAgeDesc("0");
				relationList.get(i).adult.setRelation("0");
			} else {
				ageList.get(i).adult.setAge(1);
				genderList.get(i).adult.setGender("1");
				ethnicityList.get(i).adult.setEthnicity("1");
				jaundiceList.get(i).adult.setJuandice("1");
				autismList.get(i).adult.setAutism("1");
				countryOfResList.get(i).adult.setCountryOfRes("1");
				usedAppBeforeList.get(i).adult.setUsedAppBefore("1");
				resultList.get(i).adult.setResult(1);
				ageDescList.get(i).adult.setAgeDesc("1");
				relationList.get(i).adult.setRelation("1");
			}
		}
	}

	public String getFileContents() {
		return fileContents;
	}

	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}
	

	
	private class StringPair {
		String value;
		AutismAdult adult;
		
		public StringPair(String value, AutismAdult adult) {
			this.value = value;
			this.adult = adult;
		}
	}
	
	private class IntegerPair {
		Integer value;
		AutismAdult adult;
		
		public IntegerPair(Integer value, AutismAdult adult) {
			this.value = value;
			this.adult = adult;
		}
	}
	
	private class StringComparator implements Comparator<StringPair>{
		@Override
		public int compare(StringPair pair1, StringPair pair2) {
			return pair1.value.compareTo(pair2.value);
		}
	}
	
	private class IntegerComparator implements Comparator<IntegerPair>{
		@Override		
		public int compare(IntegerPair pair1, IntegerPair pair2) {
			return Integer.compare(pair1.value, pair2.value);
		}
	}
	
	public void toDisk(List<AutismAdult> adults, String filename) {
		String output = "@RELATION autism_adult\n";
		output += "@ATTRIBUTE A1_Score {0,1}\n";
		output += "@ATTRIBUTE A2_Score {0,1}\n";
		output += "@ATTRIBUTE A3_Score {0,1}\n";
		output += "@ATTRIBUTE A4_Score {0,1}\n";
		output += "@ATTRIBUTE A5_Score {0,1}\n";
		output += "@ATTRIBUTE A6_Score {0,1}\n";
		output += "@ATTRIBUTE A7_Score {0,1}\n";
		output += "@ATTRIBUTE A8_Score {0,1}\n";
		output += "@ATTRIBUTE A9_Score {0,1}\n";
		output += "@ATTRIBUTE A10_Score {0,1}\n";
		output += "@ATTRIBUTE age {0,1}\n";
		output += "@ATTRIBUTE gender {0,1}\n";
		output += "@ATTRIBUTE ethnicity {0,1}\n";
		output += "@ATTRIBUTE jaundice {0,1}\n";
		output += "@ATTRIBUTE autism {0,1}\n";
		output += "@ATTRIBUTE country_of_res {0,1}\n";
		output += "@ATTRIBUTE used_app_before {0,1}\n";
		output += "@ATTRIBUTE result {0,1}\n";
		output += "@ATTRIBUTE age_desc {0,1}\n";
		output += "@ATTRIBUTE relation {0,1}\n";
		output += "@ATTRIBUTE class {NO,YES}\n";
		output += "\n@DATA\n";
		
		for (AutismAdult adult : adults) {
			output += adult.toString() + "\n";
		}
		
		try {
			Files.writeString(Path.of(filename), output);
		} catch (IOException e) {
			System.out.println("Unable to write dataset to disk. Filename: \" + filename");
		}
	}
}
