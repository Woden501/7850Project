package com.woden501.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.woden501.project.models.Adult;
import com.woden501.project.utilities.DatasetUtilities;

public class Dataset1Loader {
	private String fileContents;
	private List<Adult> adults;
	private HashMap<Double, List<Adult>> randomAdultsHash;

	public Dataset1Loader() {
		super();
		this.fileContents = DatasetUtilities.getContents("adult.data");
		this.adults = new ArrayList<Adult>();
		this.randomAdultsHash = new HashMap<>();
//		String lines[] = fileContents.split("\\r?\\n");

		try {
			Stream<String> stream = Files
					.lines(Path.of(Dataset1Loader.class.getClassLoader().getResource("adult.data").toURI()));
			stream.forEach(line -> generateAdult(line));
			stream.close();
		} catch (Exception e) {
			System.out.println("Error encountered reading dataset1. Exception: " + e.getMessage());
			System.out.println("Exiting...");
			System.exit(1);
		}
		
		binarizeAdults();
		toDisk(adults, "binarizedAdults.arff");
		randomizeAdults(0.1);
		toDisk(randomAdultsHash.get(0.1), "0.1RandomAdults.arff");
		randomizeAdults(0.2);
		toDisk(randomAdultsHash.get(0.2), "0.2RandomAdults.arff");
		randomizeAdults(0.3);
		toDisk(randomAdultsHash.get(0.3), "0.3RandomAdults.arff");
		randomizeAdults(0.4);
		toDisk(randomAdultsHash.get(0.4), "0.4RandomAdults.arff");
		randomizeAdults(0.45);
		toDisk(randomAdultsHash.get(0.45), "0.45RandomAdults.arff");
		randomizeAdults(0.51);
		toDisk(randomAdultsHash.get(0.51), "0.51RandomAdults.arff");
		randomizeAdults(0.55);
		toDisk(randomAdultsHash.get(0.55), "0.55RandomAdults.arff");
		randomizeAdults(0.6);
		toDisk(randomAdultsHash.get(0.6), "0.6RandomAdults.arff");
		randomizeAdults(0.7);
		toDisk(randomAdultsHash.get(0.7), "0.7RandomAdults.arff");
		randomizeAdults(0.8);
		toDisk(randomAdultsHash.get(0.8), "0.8RandomAdults.arff");
		randomizeAdults(0.9);
		toDisk(randomAdultsHash.get(0.9), "0.9RandomAdults.arff");
		randomizeAdults(1.0);
		toDisk(randomAdultsHash.get(1.0), "1.0RandomAdults.arff");
		
		System.out.println("Data successfully loaded, modified, randomized, and written to disk");
	}

	private void generateAdult(String line) {
		if (!line.equals("")) {
			String[] splitLine = line.split(", ");
			Adult adult = new Adult(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5],
					splitLine[6], splitLine[7], splitLine[8], splitLine[9], splitLine[10], splitLine[11], splitLine[12],
					splitLine[13], splitLine[14]);
			this.adults.add(adult);
		}
	}
	
	public void randomizeAdults(double seed) {
		List<Adult> randomizedAdults = new ArrayList<>(); 
		
		Random rand = new Random();
		
		for (Adult adult : adults) {
			double randomNumber = rand.nextDouble();
			
			if (randomNumber > seed) {
				randomizedAdults.add(adult.negate());
			}
			else {
				randomizedAdults.add(new Adult(adult));
			}
		};
		
		this.randomAdultsHash.put(seed, randomizedAdults);
	}
	
	public void binarizeAdults() {
		ArrayList<IntegerPair> ageList = new ArrayList<IntegerPair>();
		ArrayList<StringPair> workclassList = new ArrayList<StringPair>();
		ArrayList<IntegerPair> fnlwgtList = new ArrayList<IntegerPair>();
		ArrayList<StringPair> educationList = new ArrayList<StringPair>();
		ArrayList<IntegerPair> educationNumList = new ArrayList<IntegerPair>();
		ArrayList<StringPair> maritalStatusList = new ArrayList<StringPair>();
		ArrayList<StringPair> occupationList = new ArrayList<StringPair>();
		ArrayList<StringPair> relationshipList = new ArrayList<StringPair>();
		ArrayList<StringPair> raceList = new ArrayList<StringPair>();
		ArrayList<StringPair> sexList = new ArrayList<StringPair>();
		ArrayList<IntegerPair> capitalGainList = new ArrayList<IntegerPair>();
		ArrayList<IntegerPair> capitalLossList = new ArrayList<IntegerPair>();
		ArrayList<IntegerPair> hoursPerWeekList = new ArrayList<IntegerPair>();
		ArrayList<StringPair> nativeCountryList = new ArrayList<StringPair>();
		
		// Get Lists of attributes
		for (Adult adult : adults) {
			ageList.add(new IntegerPair(adult.getAge(), adult));
			workclassList.add(new StringPair(adult.getWorkclass(), adult));
			fnlwgtList.add(new IntegerPair(adult.getFnlwgt(), adult));
			educationList.add(new StringPair(adult.getEducation(), adult));
			educationNumList.add(new IntegerPair(adult.getEducationNum(), adult));
			maritalStatusList.add(new StringPair(adult.getMaritalStatus(), adult));
			occupationList.add(new StringPair(adult.getOccupation(), adult));
			relationshipList.add(new StringPair(adult.getRelationship(), adult));
			raceList.add(new StringPair(adult.getRace(), adult));
			sexList.add(new StringPair(adult.getSex(), adult));
			capitalGainList.add(new IntegerPair(adult.getCapitalGain(), adult));
			capitalLossList.add(new IntegerPair(adult.getCapitalLoss(), adult));
			hoursPerWeekList.add(new IntegerPair(adult.getHoursPerWeek(), adult));
			nativeCountryList.add(new StringPair(adult.getNativeCountry(), adult));
		}
		
		// Sort Lists
		Collections.sort(ageList, new IntegerComparator());
		Collections.sort(workclassList, new StringComparator());
		Collections.sort(fnlwgtList, new IntegerComparator());
		Collections.sort(educationList, new StringComparator());
		Collections.sort(educationNumList, new IntegerComparator());
		Collections.sort(maritalStatusList, new StringComparator());
		Collections.sort(occupationList, new StringComparator());
		Collections.sort(relationshipList, new StringComparator());
		Collections.sort(raceList, new StringComparator());
		Collections.sort(sexList, new StringComparator());
		Collections.sort(capitalGainList, new IntegerComparator());
		Collections.sort(capitalLossList, new IntegerComparator());
		Collections.sort(hoursPerWeekList, new IntegerComparator());
		Collections.sort(nativeCountryList, new StringComparator());
		
		// Find median of attributes
		int median = adults.size()/2;
		
		// Set binary values
		for (int i = 0; i < adults.size(); i++) {
			if (i < median) {
				ageList.get(i).adult.setAge(0);
				workclassList.get(i).adult.setWorkclass("0");
				fnlwgtList.get(i).adult.setFnlwgt(0);
				educationList.get(i).adult.setEducation("0");
				educationNumList.get(i).adult.setEducationNum(0);
				maritalStatusList.get(i).adult.setMaritalStatus("0");
				occupationList.get(i).adult.setOccupation("0");
				relationshipList.get(i).adult.setRelationship("0");
				raceList.get(i).adult.setRace("0");
				sexList.get(i).adult.setSex("0");
				capitalGainList.get(i).adult.setCapitalGain(0);
				capitalLossList.get(i).adult.setCapitalLoss(0);
				hoursPerWeekList.get(i).adult.setHoursPerWeek(0);
				nativeCountryList.get(i).adult.setNativeCountry("0");
			} else {
				ageList.get(i).adult.setAge(1);
				workclassList.get(i).adult.setWorkclass("1");
				fnlwgtList.get(i).adult.setFnlwgt(1);
				educationList.get(i).adult.setEducation("1");
				educationNumList.get(i).adult.setEducationNum(1);
				maritalStatusList.get(i).adult.setMaritalStatus("1");
				occupationList.get(i).adult.setOccupation("1");
				relationshipList.get(i).adult.setRelationship("1");
				raceList.get(i).adult.setRace("1");
				sexList.get(i).adult.setSex("1");
				capitalGainList.get(i).adult.setCapitalGain(1);
				capitalLossList.get(i).adult.setCapitalLoss(1);
				hoursPerWeekList.get(i).adult.setHoursPerWeek(1);
				nativeCountryList.get(i).adult.setNativeCountry("1");
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
		Adult adult;
		
		public StringPair(String value, Adult adult) {
			this.value = value;
			this.adult = adult;
		}
	}
	
	private class IntegerPair {
		Integer value;
		Adult adult;
		
		public IntegerPair(Integer value, Adult adult) {
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
	
	public void toDisk(List<Adult> adults, String filename) {
		String output = "@RELATION adult\n";
		output += "@ATTRIBUTE age {0,1}\n";
		output += "@ATTRIBUTE workclass {0,1}\n";
		output += "@ATTRIBUTE fnlwgt {0,1}\n";
		output += "@ATTRIBUTE education {0,1}\n";
		output += "@ATTRIBUTE education-num {0,1}\n";
		output += "@ATTRIBUTE marital-status {0,1}\n";
		output += "@ATTRIBUTE occupation {0,1}\n";
		output += "@ATTRIBUTE relationship {0,1}\n";
		output += "@ATTRIBUTE race {0,1}\n";
		output += "@ATTRIBUTE sex {0,1}\n";
		output += "@ATTRIBUTE capital-gain {0,1}\n";
		output += "@ATTRIBUTE capital-loss {0,1}\n";
		output += "@ATTRIBUTE hours-per-week {0,1}\n";
		output += "@ATTRIBUTE native-country {0,1}\n";
		output += "@ATTRIBUTE class {NO,YES}\n";
		output += "\n@DATA\n";
		
		for (Adult adult : adults) {
			output += adult.toString() + "\n";
		}
		
		try {
			Files.writeString(Path.of(filename), output);
		} catch (IOException e) {
			System.out.println("Unable to write dataset to disk. Filename: " + filename);
		}
	}
}
