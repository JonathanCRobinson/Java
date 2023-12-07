import java.util.Date;
import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;

// Jonathan Robinson
// COP2552.0M1
// Write a Java program using good object-oriented programming principles 
// that will read from three input files and will write information to two output files.

public class Patient {
	
	public static void main(String[] args) throws IOException {
		
		openFiles();	
	}
	
	// Methods
	//Gets the current Patient ID without changing the date of entry
	public static void getCurrentPatient(PatientInfo patient, Scanner source) {
		patient.setiD(Integer.parseInt(source.nextLine()));
		patient.setName(source.nextLine());
		patient.setDob(source.nextLine());
		patient.setYearAdded(source.nextLine());
	}
	
	//Gets the new or remove patient info while adding a current date to the object
	public static void getPatient(PatientInfo patient, Scanner source) {
		String pattern = "yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		
		patient.setiD(Integer.parseInt(source.nextLine()));
		patient.setName(source.nextLine());
		patient.setDob(source.nextLine());
		patient.setYearAdded(date);
	}
	public static void writeDate(PrintWriter update, PrintWriter error)
	{
		String pattern = "yyyyMMd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		
		update.println(date);
		error.println(date);
	}
	// opens the files and runs through the methods
	public static void openFiles() throws IOException {
		
		//Opens the files
		File patientFile = new File("C:/SFC/COP2552/Project2/PatientListW3.txt");
		File removePatientFile = new File("C:/SFC/COP2552/Project2/RemovePatientList.txt");
		File newPatientFile = new File("C:/SFC/COP2552/Project2/NewPatientList.txt");
		
		//Creates the 3 scanners for the files while skipping the first line in the first file
		Scanner patient = new Scanner(patientFile);
		patient.nextLine();
		Scanner nPatient = new Scanner(newPatientFile);
		Scanner rPatient = new Scanner(removePatientFile);
		
		// Creates the files to be written to while giving them the current date at the top
		PrintWriter updatedFile = new PrintWriter("C:/SFC/COP2552/Project2/PatientListW4.txt");
		PrintWriter errorFile = new PrintWriter("C:/SFC/COP2552/Project2/PatientErrorsW4.txt");
		writeDate(updatedFile, errorFile);
		
		// Creates instances of the PatientInfo class to hold data from the files.
		PatientInfo currentPatient = new PatientInfo();
		PatientInfo newPatient = new PatientInfo();
		PatientInfo removePatient = new PatientInfo();
		
		// Gets the first set of data from each scanner
		readInFiles(patient, nPatient, rPatient, currentPatient, newPatient, removePatient);
		
		//Loop to read through the data and create the W4 and Error files.
		while(patient.hasNext()) {
			removePatient(patient, rPatient, currentPatient, removePatient);
			addNewPatient(currentPatient, removePatient, newPatient, nPatient, rPatient, updatedFile);
			addCurrentPatient(currentPatient, newPatient, patient, nPatient, updatedFile);
			removePatientErrorCatch(removePatient, currentPatient, rPatient, errorFile);
			newPatientErrorCatch(newPatient, currentPatient, nPatient, patient, errorFile, updatedFile);
		}
		//Catches the last patient entry in the W3 Scanner
		removePatient(patient, rPatient, currentPatient, removePatient);
		addNewPatient(currentPatient, removePatient, newPatient, nPatient, rPatient, updatedFile);
		addCurrentPatient(currentPatient, newPatient, patient, nPatient, updatedFile);
		newPatientErrorCatch(newPatient, currentPatient, nPatient, patient, errorFile, updatedFile);
		closeFiles(patient,nPatient,rPatient,errorFile,updatedFile);
	}
	
	// If the current patient is the same as the remove patient, don't add to any file and get next patients
	public static void removePatient(Scanner current, Scanner remove, PatientInfo currentP, PatientInfo removeP )
	{
		if(currentP.iD == removeP.iD) {
			if(current.hasNext()) {
				getCurrentPatient(currentP, current);
			}
			if(remove.hasNext()) {
				getPatient(removeP, remove);
			}
		}
	}
	
	// If removePatient scanner doesn't have a next line or the current pt ID is less than the remove ID. Then if the newID is less than the current ID, add it to the W4 file.
	public static void addNewPatient(PatientInfo currentP, PatientInfo removeP, PatientInfo newP,Scanner newPatient, Scanner removePatient, PrintWriter w4)
	{
		if(!removePatient.hasNext() || currentP.iD < removeP.iD) {
			if(newP.iD < currentP.iD){
				w4.print(newP.iD + "\n" + newP.name + "\n" + newP.dob + "\n" + newP.yearAdded + "\n");
				if(newPatient.hasNext()) {
					getPatient(newP, newPatient);
				}
			}
		}
	}
	
	// if the Patient in the W3 file is less than the Patient in the New file, add the W3 patient to the W4 file, get next current patient
	public static void addCurrentPatient(PatientInfo currentP, PatientInfo newP, Scanner current, Scanner newPatient, PrintWriter w4)
	{	
		if(currentP.iD >= newP.iD && newPatient.hasNext()) {
			w4.print(currentP.iD + "\n" + currentP.name + "\n" + currentP.dob + "\n" + currentP.yearAdded + "\n");
			if(current.hasNext()) {
				getCurrentPatient(currentP, current);
			}
		}
		if(currentP.iD < newP.iD) {
			w4.print(currentP.iD + "\n" + currentP.name + "\n" + currentP.dob + "\n" + currentP.yearAdded + "\n");
			if(current.hasNext()) {
				getCurrentPatient(currentP, current);
			}
		}
	}
	
	// If the patient remove ID doesn't match any of the current patients, add the remove patient 
	public static void removePatientErrorCatch(PatientInfo removeP, PatientInfo currentP, Scanner remove, PrintWriter error)
	{
		// if the remove id doesn't match any of the current id
		if(removeP.iD < currentP.iD && removeP.iD != currentP.iD)
		{
			error.print(removeP.iD + "\n" + removeP.name + "\n" + removeP.dob + "\n" + removeP.yearAdded + "\n");
		}
	}
	
	// If the new patient matches the current patient, add the new patient to the Error File and the current Patient to the W44 file
	public static void newPatientErrorCatch(PatientInfo newP, PatientInfo currentP, Scanner newPatient, Scanner current, PrintWriter error, PrintWriter w4)
	{
		if(newP.iD == currentP.iD) {
			error.print(newP.iD + "\n" + newP.name + "\n" + newP.dob + "\n" + newP.yearAdded + "\n");
			w4.print(currentP.iD + "\n" + currentP.name + "\n" + currentP.dob + "\n" + currentP.yearAdded + "\n");
			if(newPatient.hasNext()) {
				getPatient(newP, newPatient);
			}
			if(current.hasNext()) {
				getCurrentPatient(currentP, current);
			}
		}
	}
	
	// Reads in the first entry in every file.
	public static void readInFiles(Scanner current, Scanner newP, Scanner remove, PatientInfo currentP, PatientInfo newPatient, PatientInfo removeP)
	{
		if(current.hasNext())
		{
			getCurrentPatient(currentP, current);
		}
		if(newP.hasNext())
		{
			getPatient(newPatient, newP);
		}
		if(remove.hasNext())
		{
			getPatient(removeP, remove);
		}
	}
	
	// Closes all the files
	public static void closeFiles(Scanner current, Scanner newP, Scanner remove, PrintWriter error, PrintWriter w4)
	{
		current.close();
		newP.close();
		remove.close();
		error.close();
		w4.close();
	}
	
}