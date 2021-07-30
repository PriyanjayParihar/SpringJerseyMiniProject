package Dao;

import POJO.Employee;

import java.util.HashMap;

public class DataStore {
    private static HashMap<String, Employee> empMap=new HashMap<>();
    public static HashMap<String, Employee> getEmpMap() {
        return empMap;
    }
    public static Employee addEmp(Employee emp){
        return empMap.put(emp.getId(),emp);
    }
    public static  Employee getEmp(String id){
        System.out.println(empMap.get(id));
        return empMap.get(id);
    }
    public static HashMap<String, Employee> getAllEmp(){
        return empMap;
    }
    public static Employee delEmp(String id){
        return empMap.remove(id);

    }
    public static Employee updateEmp(Employee emp){
        Employee e=null;
        if (delEmp(emp.getId())==null){
            return emp;
        }
        e=addEmp(emp);
        return e;
    }
}
