package Dao;

import POJO.Employee;

import java.io.*;
import java.util.HashMap;

public class StoreFile {
    public HashMap<String,Employee> getAllData(){
        HashMap<String,Employee> empMap=new HashMap<>();
        try {

            File file = new File("Users.dat");
            if (!file.exists()) {
                return null;
            }
            else{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                empMap = (HashMap<String,Employee>) ois.readObject();
                ois.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empMap;
    }

    public Employee getEmployee(String id){
        HashMap<String,Employee> empMap=getAllData();
        return empMap.get(id);
    }
    public void addEmployee(Employee emp){
        HashMap<String,Employee> empMap=getAllData();
        if(empMap==null){
            empMap=new HashMap<>();

        }
        empMap.put(emp.getId(),emp);
        saveUserMap(empMap);

    }

    private void saveUserMap(HashMap<String,Employee> empMap){
        try {
            File file = new File("Users.dat");
            FileOutputStream fos;

            fos = new FileOutputStream(file);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empMap);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
