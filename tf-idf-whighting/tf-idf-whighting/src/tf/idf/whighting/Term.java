/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tf.idf.whighting;
//hello
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class Term {
    public ArrayList<Integer> appare = new ArrayList<>();
    
    public float tf ( String docement ,String term )
    {// tf لوحدها 
        int counter[] = new int[100];
       int counter2=0  , i ;
       float freq; 
       int max = 0 ; 
       ArrayList<String> words = new ArrayList<>();
       words.addAll(Arrays.asList(docement.split("\\s+")));
       
       for( i =0 ; i < words.size(); i++)
           for(int j = 0 ;j <words.size() ; j ++)
           {
               if( words.get(i).equals(words.get(j)))
                       {
                          counter[i] ++ ;  
                       }  
           }
       for (String x : words)
           if( term.equals(x))
               counter2 ++ ;
       
       for ( i= 0  ; i < words.size(); i ++ )
       {
           if(counter[i] > max)
               max = counter[i];
       }
       if(max ==0)
           return 0;
       else 
       {
         float tf =  (float) counter2/max;
          
         return tf;
         
       } 
        
    }
    
    public float frequency (String docement , String term )
    {// tf باللوج 
       
       int counter[] = new int[100];
       int counter2=0  , i ;
       float freq; 
       int max = 0 ; 
       ArrayList<String> words = new ArrayList<>();
       words.addAll(Arrays.asList(docement.split("\\s+")));
       
       for( i =0 ; i < words.size(); i++)
           for(int j = 0 ;j <words.size() ; j ++)
           {
               if( words.get(i).equals(words.get(j)))
                       {
                          counter[i] ++ ; 
                          
                       }  
           }
       for (String x : words)
           if( term.equals(x))
               counter2 ++ ;
       
       for ( i= 0  ; i < words.size(); i ++ )
       {
           if(counter[i] > max)
               max = counter[i];
       }
       if(max ==0)
           return 0;
       else 
       {
         float tf =  (float) counter2/max;
         freq =  (float) (1 + Math.log10(tf));
         if (freq <=0)
             freq = 0 ; 
         return freq;
         
       } 
       
    }
    
    public float sumOfreq (String term ,String[]docements  , int n )
      {//دي موجوده في السلايدز بس ملقتلهاش استخدام 
           
        int i ;
        float sum = 0 ;
        ArrayList<String> words = new ArrayList<>();
        //words.addAll(Arrays.asList(docements[0].split("\\s+")));
        for(i = 0 ; i < n; i ++ )
        {
            
        
         //System.out.println(term + "  " + words);
          sum = sum + frequency(docements[i], term);
          //System.out.println(frequency(words.toString(), term));
          
         
          words.clear();
        }
    
          
      return sum; 
      }
    
    public float IDF (String term ,String[]docements  , int n)
    {
       
        int i ;
        int counter = 0 ,counter2 = 0  ;
        ArrayList<String> words = new ArrayList<>();
        //words.addAll(Arrays.asList(docements[0].split("\\s+")));
        for(i = 0 ; i < n; i ++ )
        {
            
         words.addAll(Arrays.asList(docements[i].split("\\s+")));
         for(String x : words)
         {
            // System.out.println(x);
             if(term.equals(x))
             {
                 counter2 ++ ; 
                 break ; 
                
             }
         }
         if(counter2 >0)
         {
             counter ++ ; 
             counter2 = 0 ; 
         }
         
          
         
          words.clear();
        }// end for 
       // System.out.println(counter);
        if(n==0 )
        {
            return 0;
        }
        else 
        {
            float df  = (float) n / (float) counter;
            //System.out.println(df);
           float idf = (float) Math.log10(df);
           
           return  idf ; 
        }
        
    }
    
    public void  tf_idf (String term ,String[]docements  , int n)
    {
        float idf = IDF(term, docements, n);
        
        int i ;
        
        
        for(i = 0 ; i < n; i ++ )
        {
            
        
         System.out.println("the tf-idf of term :" + term+
               " in docement:  "+ (i+1) +" = "+
                frequency(docements[i], term)*idf );
           frequency(docements[i], term);
          //System.out.println(frequency(words.toString(), term));
          
         
         
        }
         
        
        
    }
    
    
}
