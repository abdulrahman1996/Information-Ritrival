/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tf.idf.whighting;

   import java.util.Scanner;
   import java.util.HashMap;
   import java.util.ArrayList;
   import java.util.Arrays;
   
//import javax.print.DocFlavor;


public class TfIdfWhighting {
    
    public static void main(String[] args) {
        String numberOfDocemnts = new String();
        String query = new String();
        String Docemnts [] = new String[20];
        ArrayList<String>  Terms= new ArrayList<>();
        ArrayList <String> TermsAtquery =  new ArrayList<>();
        HashMap <String,Integer> termsindocs = new HashMap<>();
        HashMap<String , Integer>  termsinquery= new HashMap<>();
        
        Term term = new Term();
        System.out.println("Enter the number of docement you want to enter \n");
        Scanner sc  = new Scanner(System.in);
        numberOfDocemnts = sc.nextLine();
        int i , n ;
        //System.out.print("hhshdgfhg "+Math.log10(4/3));
        n = Integer.parseInt(numberOfDocemnts);
        for( i = 0 ; i < n ; i++){
            System.out.println("Enter the content of decement :" + (i+1) + "\n");
            Docemnts[i] = sc.nextLine(); 
        }
       
       for(i=0 ; i < n ; i ++ )// print first 3 thing in file description 
       {
           
           Terms.addAll(Arrays.asList(Docemnts[i].split("\\s+")));
           //termsa.addAll(Arrays.asList(Docemnts[i].split("\\s+")));

         
               for(String s : Terms)
               {
                    System.out.println(s);
                    System.out.println("the idf of "+s+"= "+term.IDF(s, Docemnts, n));
                    for(int j  = 0 ; j < n ; j++)
                    {
                        System.out.println("tf of " + s + " at doc"+ (j+1) + ": "
                                + term.tf(Docemnts[j], s));
                    }
                     term.tf_idf(s, Docemnts, n);
               }
              
               
                    Terms.clear();
                    
                    
       }
      
        System.out.println("Enter the query \n");
        query = sc.nextLine();
        TermsAtquery.addAll(Arrays.asList(query.split("\\s+")));
       
//         for(i=0 ; i < n ; i ++ )// print first 3 thing in file description 
//       {
//           //Terms.addAll(Arrays.asList(Docemnts[i].split("\\s+")));
//         
               for(String s : TermsAtquery)
               {
                    System.out.println(s);
                    System.out.println("the idf of "+s+"= "+term.IDF(s, Docemnts, n));
                    for(int j  = 0 ; j < n ; j++)
                    {
                        System.out.println("tf of " + s + " at doc"+ (j+1) + ": "
                                + term.tf(Docemnts[j], s));
                    }
                     term.tf_idf(s, Docemnts, n);
               }
              
               
                    //Terms.clear();
                    
                    
       //}
      /* for(String s : TermsAtquery)/// find ti-ifd for terms in docements
       {
            
            term.tf_idf(s, Docemnts, n);
            
       }*/
        /*ArrayList<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(Docemnts[1].split("\\s+")));
        for(String w : words)
        {
            System.out.println(w);
        }*/
        
        
        
        
        
        
    }
    
}
