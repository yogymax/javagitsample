/*
 * package com.scp.java.coll;
 * 
 * import java.util.ArrayList; import java.util.Enumeration; import
 * java.util.HashSet; import java.util.Iterator; import java.util.List; import
 * java.util.ListIterator; import java.util.Set; import java.util.Vector; import
 * java.util.concurrent.ThreadLocalRandom;
 * 
 * import javax.persistence.criteria.CriteriaBuilder.In;
 * 
 * //collection //collections //list //al vs ar -- al vs vector //iterator vs
 * listiterator vs enum //practical.
 * 
 * 
 * 
 * public class Itearbles {
 * 
 * //print(10+10+"A"); 20A //print("X"+10+10+"A"); X1010A
 * 
 * static int val= 65;
 * 
 * static public List<String> getCities(){ Character ch = (char)val;
 * List<String> cities = new ArrayList<String>(); for(int
 * i=1;i<=ThreadLocalRandom.current().nextInt(1,5);i++) { cities.add(ch+""+i); }
 * 
 * val+=1; return cities; }
 * 
 * 
 * static public List<Address> getAddressList(){ List<Address> addresses = new
 * ArrayList<Address>(); for(int
 * i=1;i<=ThreadLocalRandom.current().nextInt(1,5);i++) { addresses.add(new
 * Address(getCities(),"Pune"+i,17722+i)); } return addresses; }
 * 
 * 
 * static public List<Student> getDummyStudents(){ List<Student> students = new
 * ArrayList<Student>(); for(int
 * i=1;i<=ThreadLocalRandom.current().nextInt(10,20);i++) { students.add(new
 * Student(100+i, "AAAA"+i, getAddressList())); } return students; } public
 * static void main(String[] args) {
 * 
 * 
 * 
 * 
 * 
 * Set<Integer> numbers = new HashSet<Integer>(); for(int i=0;i<20;i++) {
 * numbers.add(ThreadLocalRandom.current().nextInt(1,99)); }
 * 
 * System.out.println(numbers);
 * 
 * //why to iterate-->
 * System.out.println("\n**********************************************");
 * System.out.println("Using For Loop -- All");
 * 
 * for(int i=0;i<numbers.size();i++) { int num = numbers.get(i); if(num%3==0)
 * System.out.print(num+","); //read/write numbers.set(i, num*2); //add --
 * append ...get--retrive ...set---update --insert -- new element at specific
 * position }
 * 
 * System.out.println("\n**********************************************");
 * System.out.println("Using For each loop -- All");
 * 
 * 
 * for(int num:numbers) { if(num%5==0) System.out.print(num+","); //read only }
 * 
 * 
 * System.out.println("\n**********************************************");
 * System.out.
 * println("Using Iterable - only on Collection hierarchy but not on map--or any other"
 * );
 * 
 * 
 * 
 * Iterator<Integer> numitr = numbers.iterator(); //iterator() -- iterable
 * interface-- java.lang -- returns--Iteraror-- java.util
 * while(numitr.hasNext()) { //to check next element present or not Integer num
 * = numitr.next(); //to fetch System.out.println(num);//print }
 * 
 * 
 * System.out.println("\n**********************************************");
 * System.out.println("Using ListIterator-- only on list implemented classes");
 * ListIterator<Integer> lintr = numbers.listIterator(); for(int i=0;i<15;i++) {
 * lintr.next(); // cursor -- will be at 14 index position -- element 15 }
 * System.out.println("previous---"); while(lintr.hasPrevious()) { int curno =
 * lintr.previous();
 * 
 * int num = ThreadLocalRandom.current().nextInt(1,99); if(num>90) {
 * lintr.next(); System.out.println("Generated --"+num); }
 * 
 * System.out.println(curno);
 * 
 * if(num>70 && num<80) { lintr.add(8888);
 * System.out.println("generated for update"+num+",Tobeupdated--"+curno); }
 * 
 * }
 * 
 * System.out.println(numbers); System.out.println(numbers.size());
 * System.out.println("\n**********************************************");
 * System.out.
 * println("Using Enumeration-- only on legacy -- [STACK/VECTOR/HASHTABLE/DICT/PROP]"
 * ); System.out.println("\n**********************************************");
 * 
 * System.exit(0); List<Student> students = getDummyStudents();
 * System.out.println(students);
 * System.out.println("---------------------------------");
 * 
 * Iterator<Student> stuItr = students.iterator(); while(stuItr.hasNext()) {
 * Student st = stuItr.next(); Iterator<Address> addreses =
 * st.getAddresses().iterator(); while(addreses.hasNext()) { Address adr =
 * addreses.next(); Iterator<String> cityItr = adr.getCitites().iterator();
 * while(cityItr.hasNext()) { String city = cityItr.next();
 * if(city.contains("1")) { System.out.println(st.getStudName() +"->" +city); }
 * }
 * 
 * 
 * } }
 * 
 * 
 * System.exit(0); Vector<Integer> numbers = new Vector<Integer>(); for(int
 * i=0;i<20;i++) { numbers.add(ThreadLocalRandom.current().nextInt(1,99)); }
 * 
 * 
 * Enumeration<Integer> enumItr = numbers.elements();
 * 
 * //vector/stack/hashtable/prop/dict while(enumItr.hasMoreElements()) { Integer
 * num = enumItr.nextElement(); System.out.println(num); } }
 * 
 * }
 * 
 * 
 * 
 * 
 * class Student{ private int studId; private String studName; private
 * List<Address> addresses; public Student(int studId, String studName,
 * List<Address> addresses) { super(); this.studId = studId; this.studName =
 * studName; this.addresses = addresses; }
 * 
 * @Override public String toString() { return "\n [studId=" + studId +
 * ", studName=" + studName + ", addresses=" + addresses + "]"; } public int
 * getStudId() { return studId; } public void setStudId(int studId) {
 * this.studId = studId; } public String getStudName() { return studName; }
 * public void setStudName(String studName) { this.studName = studName; } public
 * List<Address> getAddresses() { return addresses; } public void
 * setAddresses(List<Address> addresses) { this.addresses = addresses; }
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * class Address{ private List<String> citites; private int pincode; private
 * String state;
 * 
 * public Address(List<String> citites,String state,int pincode) { super();
 * this.citites = citites; this.state=state; this.pincode=pincode; }
 * 
 * @Override public String toString() { return "\n [pincode=" + pincode +
 * ", state=" + state + ",citites="+ citites + "]"; }
 * 
 * 
 * public Address(List<String> citites, int pincode, String state) { super();
 * this.citites = citites; this.pincode = pincode; this.state = state; }
 * 
 * public List<String> getCitites() { return citites; }
 * 
 * public void setCitites(List<String> citites) { this.citites = citites; }
 * 
 * 
 * 
 * 
 * }
 */