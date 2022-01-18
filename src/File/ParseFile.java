package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.StudentDAO;
import DAO.SubjectDAO;
import pojo.Class_Subject;
import pojo.Class_Subject_Student;
import pojo.Student;
import pojo.Subject;

public class ParseFile {
	public static List<String[]> ParseCSV(String filename) {

		String line = "";
		String[] record;
		List<String[]> records = new ArrayList<String[]>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))){
			br.read();

			while ((line = br.readLine()) != null) {
				record = line.split(",");
				records.add(record);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return records;
	}

	public static List<Class_Subject_Student> To_Class_Subject_Student_by_dangky(String filename) {
		List<String[]> records = ParseCSV(filename);
		List<Class_Subject_Student> list = new ArrayList<Class_Subject_Student>();
		Class_Subject_Student x;

		Iterator<String[]> it = records.iterator();
		while (it.hasNext()) {
			String[] strings = it.next();
			x = new Class_Subject_Student(strings[4], strings[5], strings[0], 0, 0, 0, 0);
			list.add(x);
		}
		return list;
	}

	public static List<Class_Subject_Student> to_Class_Subject_Student_by_diem(String filename) {
		List<String[]> records = ParseCSV(filename);
		List<Class_Subject_Student> list = new ArrayList<Class_Subject_Student>();
		Class_Subject_Student x;

		Iterator<String[]> it = records.iterator();
		while (it.hasNext()) {
			String[] strings = it.next();

			x = new Class_Subject_Student(strings[6], strings[7], strings[0], Float.parseFloat(strings[2]),
					Float.parseFloat(strings[3]), Float.parseFloat(strings[4]), Float.parseFloat(strings[5]));
			list.add(x);
		}
		return list;
	}

	public static List<Class_Subject> to_Class_Subject(String filename) {
		List<String[]> records = ParseCSV(filename);
		List<Class_Subject> list = new ArrayList<Class_Subject>();
		Class_Subject x;

		Iterator<String[]> it = records.iterator();
		while (it.hasNext()) {
			String[] strings = it.next();
			x = new Class_Subject(strings[3], strings[0], strings[2]);
			list.add(x);
		}
		return list;
	}

	public static List<Student> to_Student(String filename) {
		List<String[]> records = ParseCSV(filename);
		List<Student> list = new ArrayList<Student>();
		Student x;

		Iterator<String[]> it = records.iterator();
		while (it.hasNext()) {
			String[] strings = it.next();
			x = new Student(strings[0], strings[1] + " " + strings[2] + " " + strings[3], strings[4], strings[5],
					strings[6]);

			list.add(x);
		}
		return list;
	}

	public static void Export_by_Student(String filename, List<Student> list) {

		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))){
			br.write('\ufeff');

			Iterator<Student> it = list.iterator();

			while (it.hasNext()) {
				Student x = it.next();

				String[] name = x.getName().split(" ");

				br.write(x.getStudentID());
				br.write(",");
				br.write(name[0]);
				br.write(",");
				br.write(name[1]);
				br.write(",");
				br.write(name[2]);
				br.write(",");
				br.write(x.getGender());
				br.write(",");
				br.write(x.getiD());
				br.write(",");
				br.write(x.getClassID());
				br.write("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void Export_by_Class_Subject_Student_diem(String filename, List<Class_Subject_Student> list) {

		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))){
			br.write('\ufeff');

			Iterator<Class_Subject_Student> it = list.iterator();

			while (it.hasNext()) {
				Class_Subject_Student x = it.next();
				
				String name = StudentDAO.Find(new Student(x.getStudentID(),"","","","")).get(0).getName();

				br.write(x.getStudentID());
				br.write(",");
				br.write(name);
				br.write(",");
				br.write(String.valueOf(x.getDiemGK()));
				br.write(",");
				br.write(String.valueOf(x.getDiemCK()));
				br.write(",");
				br.write(String.valueOf(x.getDiemCong()));
				br.write(",");
				br.write(String.valueOf(x.getDiemTB()));
				br.write(",");
				br.write(x.getClassID());
				br.write(",");
				br.write(x.getSubjectID());
				br.write("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void Export_by_Class_Subject_Student_dangky(String filename, List<Class_Subject_Student> list) {
		
		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))){
			br.write('\ufeff');

			Iterator<Class_Subject_Student> it = list.iterator();
			
			while (it.hasNext()) {
				Class_Subject_Student x = it.next();
				
				String name = StudentDAO.Find(new Student(x.getStudentID(),"","","","")).get(0).getName();
				String gender = StudentDAO.Find(new Student(x.getStudentID(),"","","","")).get(0).getGender();
				String id = StudentDAO.Find(new Student(x.getStudentID(),"","","","")).get(0).getiD();

				
				br.write(x.getStudentID());
				br.write(",");
				br.write(name);
				br.write(",");
				br.write(gender);
				br.write(",");
				br.write(id);
				br.write(",");
				br.write(x.getClassID());
				br.write(",");
				br.write(x.getSubjectID());
				br.write("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void Export_by_Class_Subject(String filename, List<Class_Subject> list) {
		
		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))){
			br.write('\ufeff');
			Iterator<Class_Subject> it = list.iterator();
			
			while (it.hasNext()) {
				Class_Subject x = it.next();
				
				String name = SubjectDAO.Find(new Subject(x.getSubjectID(),"")).get(0).getName();
				
				br.write(x.getSubjectID());
				br.write(",");
				br.write(name);
				br.write(",");
				br.write(x.getClassRoom());
				br.write(",");
				br.write(x.getClassID());
				br.write("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
