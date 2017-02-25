/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbms;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Suhas
 */
public class DBMS extends ShowGui {

    /**
     * @param args the command line arguments
     */
    static DBMS demo = new DBMS();
    public DBMS()
    {
        super();
    }
    public void putToFile() throws IOException
        {
            System.out.println("In Method puttoFile");
            String fname, surname, age;
            fname = demo.getFName();
            surname = demo.getSName();
            age = demo.getAge();
            
            System.out.println(fname+" "+surname+" "+age);
            try
            {
                System.out.println("In Try block");
                FileOutputStream fp = new FileOutputStream("dbms.txt", true);
                PrintWriter pr = new PrintWriter(fp);
                //pr.println("");
                pr.append(fname+"\t|\t");
                pr.append(surname+"\t|\t");
                pr.append(age+"\n");
                System.out.println("End of Try block");
                pr.flush();
                pr.close();
                fp.close();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    public void queryExists()
    {
        String query;
        query = demo.getQuery();
        System.out.println("Query:"+query);
        if(query.equals(""))
            JOptionPane.showMessageDialog(null,"Enter a valid name");
        else
        {
            BufferedReader bufferedReader = null;
            try {
            String sCurrentLine;
            int flag=0;
            bufferedReader = new BufferedReader(new FileReader("dbms.txt"));
            //FileReader bufferedReader = new FileReader("dbms.txt");
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                //System.out.println(sCurrentLine);
                StringTokenizer st = new StringTokenizer(sCurrentLine,"|");
                while(st.hasMoreTokens())
                {
                    //System.out.println(st.nextToken().trim());
                    if(query.toUpperCase().equals( st.nextToken().trim().toUpperCase()))
                    {
                        System.out.println("Match Found! "+sCurrentLine);
                        JOptionPane.showMessageDialog(null,"Match Found!\n"+sCurrentLine);
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==0)
                JOptionPane.showMessageDialog(null,"Match Not Found!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                }   
            finally {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(DBMS.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
        }
    }
            
            
            
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hi");
        //ShowGui s = new ShowGui();
        demo.setVisible(true);
        
        
    }
    
}
