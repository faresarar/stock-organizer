package controler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hichem
 */
import java.text.*;

public class ArabicNumberToWords {
  public static final String[] dizaineNames = {
    "",
    "",
    "عشرون",
    "ثلاثون",
    "أربعون",
    "خمسون",
    "ستون",
    "سبعون",
    "تمانون",
    "تسعون"
  };

  public static final String[] uniteNames1 = {
    "",
    "واحد",
    "إثنان",
    "ثلاثة",
    "أربعة",
    "خمسة",
    "ستة",
    "سبعة",
    "ثمانية",
    "تسعة",
    "عشرة",
    "إحدى عشر",
    "إثنا عشر",
    "ثلاثة عشر",
    "أربعة عشر",
    "خمسة عشر",
    " ستةعشر",
    " سبعةعشر",
    " ثمانيةعشر",
    " تسعةعشر"
  };

  private static final String[] uniteNames2 = {
    "",
    "",
    "إثنان",
    "ثلاثة",
    "أربعة",
    "خمسة",
    "ستة",
    "سبعة",
    "ثمانية",
    "تسعة",
    "عشرة"
  };

  public ArabicNumberToWords() {}

  public static String convertZeroToHundred(int number) {

    int laDizaine = number / 10;
    int lUnite = number % 10;
    String resultat = " ";

    switch (laDizaine) {
    case 1 : lUnite = lUnite + 10;
    //case 7 :
    //case 9 :
     //
     // break;
    default:
    }

    // séparateur "-" "et"  ""
    String laLiaison = " ";
    if (laDizaine > 1) {
      laLiaison = " و ";
    }
    // cas particuliers
    switch (lUnite) {
    case 0:
      laLiaison = " ";
      break;
    case 1 :
      if (laDizaine == 8) {
        laLiaison = " و ";
      }
      else {
        laLiaison = " و ";
      }
      break;
    case 11 :
      if (laDizaine==7) {
        laLiaison = " و ";
      }
      break;
    default:
    }

    // dizaines en lettres
    switch (laDizaine) {
    case 0:
      resultat = uniteNames1[lUnite];
      break;
    case 8 :
      if (lUnite == 0) {
        resultat = dizaineNames[laDizaine];
      }
      else {
        resultat = 
                              uniteNames1[lUnite]+ laLiaison +dizaineNames[laDizaine];
      }
      break;
    default :
      resultat = uniteNames1[lUnite] 
                              + laLiaison +dizaineNames[laDizaine];
    }
    return resultat;
  }

  private static String convertLessThanOneThousand(int number) {

    int lesCentaines = number / 100;
    int leReste = number % 100;
    String sReste = convertZeroToHundred(leReste);

    String resultat;
    switch (lesCentaines) {
    case 0:
      resultat = sReste;
      break;
    case 1 :
      if (leReste > 0) {
        resultat = "مئة و " + sReste;
      }
      else {
        resultat =   " مئة ";
      }
      break;
          case 2 :
      if (leReste > 0) {
        resultat = " مئتان و " + sReste;
      }
      else {
        resultat = " مئتان ";
      }
      break;
    default :
      if (leReste > 0) {
        resultat = uniteNames2[lesCentaines] + " مئة و " + sReste;
      }
      else {
        resultat = uniteNames2[lesCentaines] + " مئة ";
      }
    }
    return resultat;
  }

  public static String convert(double number) {
    // 0 à 999 999 999 999
    if (number == 0) { return "صفر"; }

    String snumber = Double.toString(number);

    // pad des "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);
    System.out.println("df="+snumber);

    // XXXnnnnnnnnn
    int lesMilliards = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int lesMillions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int lesCentMille = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int lesMille = Integer.parseInt(snumber.substring(9,12));

    String tradMilliards;
    switch (lesMilliards) {
    case 0:
      tradMilliards = " ";
      break;
    case 1 :
         if(lesMille>0)
      tradMilliards = convertLessThanOneThousand(lesMilliards)
         + " مليار و ";
         else   tradMilliards = convertLessThanOneThousand(lesMilliards)
         + " مليار  ";
      break;
        
         case 2 : if(lesMille>0)
      tradMilliards = 
          " ملياران و ";
         else  tradMilliards = 
          " ملياران  ";
      break;
        
    default :
           if((lesMilliards>=3)&&(lesMilliards<=10)&&(lesMille>0))
      tradMilliards = convertLessThanOneThousand(lesMilliards)
         + " ملايير و ";
     else  if((lesMilliards>=3)&&(lesMilliards<=10)&&(lesMille==0))
           tradMilliards = convertLessThanOneThousand(lesMilliards)
         + " ملايير  ";
           
     else if((lesMilliards>10)&&(lesMille>0)) tradMilliards = convertLessThanOneThousand(lesMilliards)+" مليار و ";
 
            
     else  tradMilliards = convertLessThanOneThousand(lesMilliards)
         + " مليار  ";     
    }
    String resultat =  tradMilliards;

    String tradMillions;
    switch (lesMillions) {
    case 0:
      tradMillions = " ";
      break;
    case 1 :
          if(lesMille>0)
      tradMillions = convertLessThanOneThousand(lesMillions)
         + " مليون و ";
          else  tradMillions = convertLessThanOneThousand(lesMillions) + " مليون ";
     
      break;
   
         case 2 :
              if(lesMille>0)
      tradMillions = " مليونان و ";
              else  tradMillions = " مليونان ";
        
      break;
        
    default :
        if((lesMillions>=3)&&(lesMillions<=10)&&(lesMille>0))
             tradMillions = convertLessThanOneThousand(lesMillions)
         + " ملايين و ";
     else  if((lesMillions>=3)&&(lesMillions<=10)&&(lesMille==0))
           tradMillions = convertLessThanOneThousand(lesMillions)
         + " ملايين  ";
           
     else if((lesMillions>10)&&(lesMille>0)) tradMillions = convertLessThanOneThousand(lesMillions)
 
             + " مليون و ";
     else  tradMillions = convertLessThanOneThousand(lesMillions)
         + " مليون  ";
    }
    resultat =  resultat + tradMillions;

    String tradCentMille;
  //  System.out.println("lesCentMille="+lesCentMille);
    // System.out.println("lesMille="+lesMille);
    switch (lesCentMille) {
    case 0:
      tradCentMille = " ";
      break;
    case 1 :
        if(lesMille>0)
     tradCentMille = " ألف و ";else  tradCentMille = " ألف ";
      break;
          case 2 :
        if(lesMille>0)
     tradCentMille = " ألفان و ";else tradCentMille = " ألفان ";
      break;
        
    default :
        if(lesCentMille>=11&&lesMille>0)
             tradCentMille = convertLessThanOneThousand(lesCentMille)+" ألف و ";
         else if(lesCentMille>=11&&lesMille==0)
               tradCentMille = convertLessThanOneThousand(lesCentMille)+" ألف ";
     else if(lesMille>0)
     tradCentMille = convertLessThanOneThousand(lesCentMille)+" آلاف و " ;
                else
      tradCentMille = convertLessThanOneThousand(lesCentMille)+" آلاف ";
        
    }
    resultat =  resultat + tradCentMille;

    String tradMille;
    tradMille = convertLessThanOneThousand(lesMille);
    resultat =  resultat + tradMille;

    return resultat;
  }

/*  public static void main(String[] args) {
    System.out.println("*** " + ArabicNumberToWords.convert(0));
    System.out.println("*** " + ArabicNumberToWords.convert(9));
    System.out.println("*** " + ArabicNumberToWords.convert(14));
    System.out.println("*** " + ArabicNumberToWords.convert(21));
    System.out.println("*** " + ArabicNumberToWords.convert(28));
    System.out.println("*** " + ArabicNumberToWords.convert(71));
    System.out.println("*** " + ArabicNumberToWords.convert(72));
    System.out.println("*** " + ArabicNumberToWords.convert(80));
    System.out.println("*** " + ArabicNumberToWords.convert(81));
    System.out.println("*** " + ArabicNumberToWords.convert(89));
    System.out.println("*** " + ArabicNumberToWords.convert(90));
    System.out.println("*** " + ArabicNumberToWords.convert(91));
    System.out.println("*** " + ArabicNumberToWords.convert(97));
    System.out.println("*** " + ArabicNumberToWords.convert(100));
    System.out.println("*** " + ArabicNumberToWords.convert(101));
    System.out.println("*** " + ArabicNumberToWords.convert(110));
    System.out.println("*** " + ArabicNumberToWords.convert(120));
    System.out.println("*** " + ArabicNumberToWords.convert(200));
    System.out.println("*** " + ArabicNumberToWords.convert(201));
    System.out.println("*** " + ArabicNumberToWords.convert(232));
    System.out.println("*** " + ArabicNumberToWords.convert(999));
    System.out.println("*** " + ArabicNumberToWords.convert(2000));
    System.out.println("*** " + ArabicNumberToWords.convert(2001));
    System.out.println("*** " + ArabicNumberToWords.convert(3040));
    System.out.println("*** " + ArabicNumberToWords.convert(10001));
    System.out.println("*** " + ArabicNumberToWords.convert(100000));
    System.out.println("*** " + ArabicNumberToWords.convert(2000000));
    System.out.println("*** " + ArabicNumberToWords.convert(3000000000L));
    System.out.println("*** " + ArabicNumberToWords.convert(2147483647));
    /*
     *** OUTPUT
     *** zéro
     *** neuf
     *** dix-neuf
     *** vingt et un
     *** vingt-huit
     *** soixante et onze
     *** soixante-douze
     *** quatre-vingt
     *** quatre-vingt-un
     *** quatre-vingt-neuf
     *** quatre-vingt-dix
     *** quatre-vingt-onze
     *** quatre-vingt-dix-sept
     *** cent
     *** cent un
     *** cent dix
     *** cent vingt
     *** deux cents
     *** deux cent un
     *** deux cent trente-deux
     *** neuf cent quatre-vingt-dix-neuf
     *** mille
     *** mille un
     *** dix mille
     *** dix mille un
     *** cent mille
     *** deux millions
     *** trois milliards
     *** deux milliards cent quarante-sept millions
     **          quatre cent quatre-vingt-trois mille six cent quarante-sept
     */
 // }
}

