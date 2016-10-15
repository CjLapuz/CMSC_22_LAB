package Lab10;

import java.io.*;
import java.util.*;
// Imports from JFrame
import static Lab10.StudentList.sNum;
import static Lab10.StudentList.sFName;
import static Lab10.StudentList.sMName;
import static Lab10.StudentList.sLName;
import static Lab10.StudentList.sCourse;
import static Lab10.StudentList.sYear;
import static Lab10.StudentList.search;
import static Lab10.StudentList.adD;
import static Lab10.StudentList.deletE;
import static Lab10.StudentList.updatE;
import static Lab10.StudentList.indx;

public class StudentRegistry {
    List<Student> studentList = new ArrayList<Student>();
    Student stud = new Student();
    
    public StudentRegistry(){}
    
    public void searchMode(){ // Search Mode
        search.setEnabled(true);
        sNum.setEnabled(true);
        sFName.setEnabled(false);
        sMName.setEnabled(false);
        sLName.setEnabled(false);
        sCourse.setEnabled(false);        
        sYear.setEnabled(false);
        adD.setEnabled(false);
        deletE.setEnabled(true);
        updatE.setEnabled(false);
    }    
    public void addMode(){ // Add Mode
        search.setEnabled(false);
        sNum.setEnabled(true);
        sFName.setEnabled(true);
        sMName.setEnabled(true);
        sLName.setEnabled(true);
        sCourse.setEnabled(true);        
        sYear.setEnabled(true);
        adD.setEnabled(true);
        deletE.setEnabled(false);
        updatE.setEnabled(false);
    }
    public void updateMode(){ // Update Mode
        search.setEnabled(false);
        sNum.setEnabled(false);
        sFName.setEnabled(true);
        sMName.setEnabled(true);
        sLName.setEnabled(true);
        sCourse.setEnabled(true);        
        sYear.setEnabled(true);
        adD.setEnabled(false);
        deletE.setEnabled(false);
        updatE.setEnabled(true);
    }
    // Adds a student to the List
    public void add(){
        char mid = sMName.getText().charAt(0);
        int yr = Integer.parseInt(sYear.getText());
        stud = new Student(sNum.getText(), sFName.getText(), mid, sLName.getText(), sCourse.getText(), yr);
        addDataToFile();
        studentList.add(stud);
    }
    // Deletes a student from the List
    public void delete(){
        int index = Integer.parseInt(indx.getText());
        studentList.remove(index);
        reWriteFile();
    }
    // Searches for the indicated student number
    public boolean search(String num){
        int index = 0;
        for (Student st: studentList) {
            indx.setText(String.valueOf(index));
            if(st.getStudentNumber().equals(num)){
                sFName.setText(st.getFirstName());
                String mid = String.valueOf(st.getMiddleInitial());
                sMName.setText(mid);
                sLName.setText(st.getLastName());
                sCourse.setText(st.getCourse());
                String yr = String.valueOf(st.getYearLevel());
                sYear.setText(yr);
                return true;
            }
            index++;
	}
        return false;
    }
    // Searches for the indicated student number
    public void update(){
        int index = Integer.parseInt(indx.getText());
        Student stdnt = studentList.get(index);
        stdnt.setFirstName(sFName.getText());
        stdnt.setMiddleInitial((sMName.getText().charAt(0)));
        stdnt.setLastName(sLName.getText());
        stdnt.setCourse(sCourse.getText());
        stdnt.setYearLevel(Integer.parseInt(sYear.getText()));
        reWriteFile();
    }
    // Checks for repeated Studnet numbers
    public boolean ifRepetition(String num){
        for (Student st: studentList) {
            if(st.getStudentNumber().equals(num)){
                return true;
            }
	}
        return false;
    }
    //Writes Student data to file
    public void addDataToFile() {
    try {
        File file = new File("C:\\Users\\Jeremy\\Desktop\\studentListing.txt");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.newLine();
        bw.write(sNum.getText());
        bw.newLine();
        bw.write(sFName.getText());
        bw.newLine();
        bw.write(sMName.getText());
        bw.newLine();
        bw.write(sLName.getText());
        bw.newLine();
        bw.write(sCourse.getText());
        bw.newLine();
        bw.write(sYear.getText());
        
        // better use finally here...
        bw.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    //Writes Student data to file
    public void reWriteFile() {
    try {
        File file = new File("C:\\Users\\Jeremy\\Desktop\\studentListing.txt");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
        for (Student st: studentList) {
            int i = 0;
            bw.write(st.getStudentNumber());
            bw.newLine();
            bw.write(st.getFirstName());
            bw.newLine();
            bw.write(st.getMiddleInitial());
            bw.newLine();
            bw.write(st.getLastName());
            bw.newLine();
            bw.write(st.getCourse());
            bw.newLine();
            String year = String.valueOf(st.getYearLevel());
            bw.write(year);
            if (++i != studentList.size()) {bw.newLine();}
        }
        // better use finally here...
        bw.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    // Done when starting the JFrame, reads an initial file containing student information
    public void addFileData() {
	BufferedReader br = null;	

	try {
            String sCurrentLine;
            int ctr = 1;
            br = new BufferedReader(new FileReader("C:\\Users\\Jeremy\\Desktop\\studentListing.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                switch(ctr){
                case 1:
                    stud.setStudentNumber(sCurrentLine);
                    ctr++;
                    break;
                case 2:
                    stud.setFirstName(sCurrentLine);
                    ctr++;
                    break;
                case 3:
                    if (sCurrentLine.length() == 0) {
                        stud.setMiddleInitial((char) 54321);
                    } else {
                        stud.setMiddleInitial(sCurrentLine.charAt(0));
                    }
                    ctr++;
                    break;
                case 4:
                    stud.setLastName(sCurrentLine);
                    ctr++;
                    break;
                case 5:
                    stud.setCourse(sCurrentLine);
                    ctr++;
                    break;
                default:
                    stud.setYearLevel(Integer.parseInt(sCurrentLine));
                    studentList.add(stud);
                    ctr = 1;
                    stud = new Student();
                }
	    }
	} catch (IOException e) {
            e.printStackTrace();
	} finally {
            try {
		if (br != null) {
                    br.close();
		}
            } catch (IOException e){
            e.printStackTrace();
            }
	}
	}
}
