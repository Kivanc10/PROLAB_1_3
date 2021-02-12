/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListProject;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
/**
 *
 * @author Kivanc
 */
public class ReadingProcess {
    private String path = "C:\\Users\\Kivanc\\Documents\\NetBeansProjects\\LinkedListProject\\src\\main\\java\\LinkedListProject\\test.txt";
    private Scanner x;
    protected HashMap<String,Integer> map = new HashMap<String, Integer>(); 
    // 
    public void openFileForReading() {
        try {
            x = new Scanner(new File(this.path));
            System.out.println("The file is reading by program");
        } catch (Exception e) {
            System.out.println("Related file did not found");
        }
    }
    public void readFile() {
        try {
            System.out.println("\n------------ The content of file -----\n");
            File fileDir = new File(this.path);
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir),StandardCharsets.UTF_8));
            String temp;
            while((temp = in.readLine()) != null) { // it reads the file until see null
                //System.out.println(temp);
                int key = 1;
                for (String x : temp.split(" ")){
                    if (map.containsKey(x.toLowerCase())){
                        key = map.get(x.toLowerCase())+1;
                        map.put(x.toLowerCase(), key);
                    }
                    else {
                        map.put(x.toLowerCase(), key);
                    }
                }
            }
            in.close();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public HashMap sortHasMap(HashMap m) {
        List list = new LinkedList(m.entrySet());
        Collections.sort(list,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable)((Map.Entry)(o1)).getValue())
                        .compareTo(((Map.Entry)(o2)).getValue());
            }
            
        });
        
        HashMap sortedHm = new LinkedHashMap();
        for(Iterator it = list.iterator();it.hasNext();){
            Map.Entry entry = (Map.Entry)it.next();
            sortedHm.put(entry.getKey(), entry.getValue());
        }
        return sortedHm;
    }
    
    public void showMap() {
        Map<String,Integer> m = this.sortHasMap(map);
       Set set = m.entrySet();
       Iterator iter = set.iterator();
       while (iter.hasNext()){
           Map.Entry me = (Map.Entry) iter.next();
           System.out.print(me.getKey() + ": ");
           System.out.println(me.getValue());
       }
    }
}
