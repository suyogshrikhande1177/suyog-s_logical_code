package StringCode;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class digitToString {
    static final Map<Integer, String> numWord = Map.ofEntries(
        Map.entry(0, ""),
        Map.entry(1, "One"),
        Map.entry(2, "Two"),
        Map.entry(3, "Three"),
        Map.entry(4, "Four"),
        Map.entry(5, "Five"),
        Map.entry(6, "Six"),
        Map.entry(7, "Seven"),
        Map.entry(8, "Eight"),
        Map.entry(9, "Nine"),
        Map.entry(10, "Ten"),
        Map.entry(11, "Eleven"),
        Map.entry(12, "Twelve"),
        Map.entry(13, "Thirteen"),
        Map.entry(14, "Fourteen"),
        Map.entry(15, "Fifteen"),
        Map.entry(16, "Sixteen"),
        Map.entry(17, "Seventeen"),
        Map.entry(18, "Eighteen"),
        Map.entry(19, "Nineteen")
);

    static final Map<Integer,String> tens = Map.of(
            2,"Twenty",
            3,"Thirty",
            4,"Forty",
            5,"Fifty",
            6,"Sixty",
            7,"Seventy",
            8,"Eighty",
            9,"Ninety"
    );

    public static StringBuffer digitToString(int Digits){

        
        String stringDigit = Integer.toString(Digits);

        StringBuffer result = new StringBuffer();

        Integer temp =0;
        
        int dLength = stringDigit.length();
         List<Integer> dList = new CopyOnWriteArrayList<>();
         dList =  stringDigit
         .chars()  // Convert to IntStream
         .mapToObj(c -> c - '0') // Convert char to int
         .collect(Collectors.toList());
        
           for( Integer degit :dList) {
            if (dLength==9) {
                if (degit==1 && temp == 0) {
                    result.append(" ").append(numWord.get(Integer.parseInt(stringDigit.length()-9+""+dList.get(stringDigit.length()-8)))).append(" Crore");
                    temp = degit;
                  }else{
                    result.append(" ").append(tens.get(degit));
                  }
            }else if (dLength==8) {
                if (temp != 0) {
                    temp=0;
                    dLength--;
                    continue;
                }else{
                     result.append(" ").append(numWord.get(degit)).append(" Crore");
                }
             }else if (dLength==7) {
                    if (degit==1 && temp == 0) {
                        result = result.append(" ").append(numWord.get(Integer.parseInt(dList.get(stringDigit.length()-7)+""+dList.get(stringDigit.length()-6)))).append(" Lakh");
                        temp = degit;
                      }else{
                        result.append(" ").append(tens.get(degit));
                      }
                }else if (dLength==6) {
                    if (temp != 0) {
                        temp=0;
                        dLength--;
                        continue;
                    }else{
                        result.append(" ").append(numWord.get(degit)).append(" Lakh");
                    }
                }else if (dLength==5) {
                    if (degit==1 && temp == 0) {
                         result.append(" ").append(numWord.get(Integer.parseInt(dList.get(stringDigit.length()-5)+""+dList.get(stringDigit.length()-4)))).append(" Thousand ");
                        temp = degit;
                      }else{
                        result.append(" ").append(tens.get(degit));
                      }
                }else if (dLength==4) {
                    if (temp != 0) {
                        temp=0;
                        dLength--;
                        continue;
                    }else{
                         result.append(" ").append(numWord.get(degit)).append(" Thousand ");
                    }
                }else if (dLength==3) {
                 result.append(numWord.get(degit)).append(" Hundred");
                }else if (dLength==2) {
                    if (degit==1) {
                    result.append(" ").append(numWord.get(Integer.parseInt(dList.get(stringDigit.length()-2)+""+dList.get(stringDigit.length()-1))));
                      break;
                    }else{
                    result.append(" ").append(tens.get(degit));
                    }   
                }else if(dLength==1){
                    result.append(" ").append(numWord.get(degit));
                }

              dLength--;  
            }
    
    
        return result;
        
     }       
    public static void main(String[] args) {
        System.out.println("Enter Number between 1 to 999,999,999 with or without comma");
        System.out.print("Number to Words Converter - Indian Rupees:- ");
        Scanner sc = new Scanner(System.in); 
         try{
            int digitCurrancy = Integer.parseInt(sc.next());
         System.out.println("Indian Rupees in Words:-"+digitToString.digitToString(digitCurrancy));
        }catch(RuntimeException re){
            //re.printStackTrace();
            System.out.println("Enter Correct Integer Value!!");
        }
    }
    
}
