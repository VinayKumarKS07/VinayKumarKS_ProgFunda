package com.Question_2;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.Question_1.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Thread1 {
    private BlockingQueue<Map<Project, ArrayList<Employee>>> queue;

    public Thread1() {
        this.queue = new LinkedBlockingQueue<>();
    }

    public void serializeMap(Map<Project, ArrayList<Employee>> map) {
        try {
            queue.put(map); // Put the map into the queue
            System.out.println("Serialize called by Producer");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public Map<Project, ArrayList<Employee>> deserializeMap() {
        try {
            System.out.println("DeSerialize Called by Consumer");
            return queue.take(); // Take the map from the queue
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return null;
        }
    }

    static void displayMap(Map<Project, ArrayList<Employee>> map) {
    	
        for(Map.Entry<Project, ArrayList<Employee>> m : map.entrySet()) {
      	  Project pobj = m.getKey();
      	  ArrayList<Employee> e = m.getValue();
      	  System.out.println(pobj);
      	  for(Employee emp:e) {
      		  
      		  System.out.println(emp);
      	  }
        }
      	
      }
  }

    // ... (other methods remain the same)


class Producer extends Thread {
    private Thread1 obj;
    private Map<Project, ArrayList<Employee>> map;

    public Producer(Thread1 obj, Map<Project, ArrayList<Employee>> map) {
        this.obj = obj;
        this.map = map;
    }

    @Override
    public void run() {
        obj.serializeMap(map);
    }
}

class Consumer extends Thread {
    private Thread1 obj;

    public Consumer(Thread1 obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        Map<Project, ArrayList<Employee>> deserializedMap = obj.deserializeMap();
        if (deserializedMap != null) {
            Thread1.displayMap(deserializedMap);
        }
    }
}
public class InterThreadCom {
    public static void main(String[] args) {

        HashMap<Project, ArrayList<Employee>> hMap1 = new HashMap<>();
        HashMap<Project, ArrayList<Employee>> hMap2 = new HashMap<>();
        HashMap<Project, ArrayList<Employee>> hMap3 = new HashMap<>();
                

        ArrayList <Employee> eList1 = new ArrayList<Employee>();
        ArrayList <Employee> eList2 = new ArrayList<Employee>();
        ArrayList <Employee> eList3 = new ArrayList<Employee>();
        ArrayList <Employee> eList4 = new ArrayList<Employee>();
        ArrayList <Employee> eList5 = new ArrayList<Employee>();
        ArrayList <Employee> eList6 = new ArrayList<Employee>();
        Employee e1 = new Employee("E001","Harsha","9383993933","RTNagar",1000);
        Employee e2 = new Employee("E002","Harish","9354693933","Jayanagar",2000);
        Employee e3 = new Employee("E003","Meenal","9383976833","Malleswaram",1500);
        Employee e4 = new Employee("E004","Sundar","9334593933","Vijayanagar",3000);
        Employee e5 = new Employee("E005","Suman","9383678933","Indiranagar",2000);
        Employee e6 = new Employee("E006","Suma","9385493933","KRPuram",1750);
        Employee e7 = new Employee("E007","Chitra","9383978933","Koramangala",4000);
        Employee e8 = new Employee("E008","Suraj","9383992133","Malleswaram",3000);
        Employee e9 = new Employee("E009","Manu","9345193933","RTNagar",2000);
        Employee e10 = new Employee("E010","Kiran","9383975673","Koramangala",4000);
        Employee e11 = new Employee("E011","Mrinal","9383992789","Malleswaram",3000);
        Employee e12 = new Employee("E012","Mahesh","9345193763","RTNagar",2000);
        eList1.add(e1);
        eList1.add(e2);
        eList2.add(e3);
        eList2.add(e4);
        eList3.add(e5);
        eList3.add(e6);
        eList4.add(e7);
        eList4.add(e8);
        eList5.add(e9);
        eList5.add(e10);
        eList6.add(e11);
        eList6.add(e12);
        Project project1 = new Project("P1","Music Synthesizer",23);
        Project project2 = new Project("P2","Vehicle Movement Tracker",13);
        Project project3 = new Project("P3","Liquid Viscosity Finder",15);
        Project project4 = new Project("P4","InsuranceTool",23);
        Project project5 = new Project("P5","BankingTool",13);
        Project project6 = new Project("P6","PayrollTool",15);
        hMap1.put(project1, eList1);
        hMap1.put(project2, eList2);
        hMap2.put(project3, eList3);
        hMap2.put(project4, eList4);
        hMap3.put(project5, eList5);
        hMap3.put(project6, eList6);


        Thread1 obj = new Thread1();

        Producer p1 = new Producer(obj, hMap1);
        Consumer c1 = new Consumer(obj);

        Producer p2 = new Producer(obj, hMap2);
        Consumer c2 = new Consumer(obj);

        Producer p3 = new Producer(obj, hMap3);
        Consumer c3 = new Consumer(obj);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
        p3.start();
        c3.start();
    }
}