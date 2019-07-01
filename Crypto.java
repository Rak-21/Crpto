import java.util.*;
public class Crypto {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Text to be Encrypted  :   ");
        String Str = input.nextLine();
        System.out.print("Enter the no. by which the Alphabets need to be shifted   :   ");
        int Shift = input.nextInt();
        System.out.print("Enter the Group size  :   ");
        int GroupSize = input.nextInt();
        Str = EncryptString(Str,Shift,GroupSize);
        System.out.println(Str);
//        Str = UnGroupify(Str);
//        System.out.println(Str);
//        Str = UnCaesearify(Str,Shift);
//        System.out.println(Str);

//        String Str = "My name is Khan and I'm not a terrorist";
//        System.out.println(Str);
//        Str = Normalise(Str);
//        System.out.println(Str);
//        Str = Obify(Str);
//        System.out.println(Str);
//        Str = Caesarify(Str,2);
//        System.out.println(Str);
//        Str = Groupify(Str,2);
//        System.out.println(Str);


    }
    public static String Normalise(String Str)
    {
//        Str.replaceAll(" ","");
        Str = Str.replaceAll("\\p{Space}","");
        Str = Str.replaceAll("\\p{Punct}","");
        Str = Str.toUpperCase();
        return Str;
    }
    public static String Obify(String Str)
    {
        String St = "";

        for(int i=0; i< Str.length(); i++)
        {
            char Ch = Str.charAt(i);
            if(Ch == 'A' || Ch == 'E' || Ch == 'I' || Ch == 'O' || Ch == 'U' || Ch == 'Y')
            {
                St = St + "OB" + Ch;
            }
            else
                St = St + Ch;
        }
        return St;
    }

    public static String Caesarify(String Str, int Shift)
    {
        String St = "";

        for(int i=0; i< Str.length(); i++)
        {
            int ch = (int)Str.charAt(i) + Shift;

            if(ch < 65)
            {
                ch = ch +26;
            }
            else if(ch > 90)
            {
                ch = ch - 26;
            }

            St = St + (char)ch;
        }
        return St;
    }

    public static String Groupify(String Str, int G)
    {
        String St = "";

        if(Str.length()%G != 0)
        {
            while(Str.length()%G != 0)
            {
                Str = Str + "x";
            }
        }

        for(int i = 0; i <Str.length(); i= i+G)
        {
            St = St + Str.substring(i,i+G) + " ";
        }
        St = St.trim();
        return St;
    }
    public static String EncryptString(String Str,int Shift,int GroupSize)
    {
        Str = Normalise(Str);
        Str = Obify(Str);
        Str = Caesarify(Str,Shift);
        Str = Groupify(Str,GroupSize);
        return Str;
    }
    public static String UnGroupify(String Str)
    {
        Str = Str.replaceAll("\\p{Space}","");
        return Str;
    }
    public static String UnCaesearify(String Str, int Shift)
    {
        String St = "";

        for(int i=0; i< Str.length(); i++)
        {
            int ch = (int)Str.charAt(i) - Shift;

            if(ch < 65)
            {
                ch = ch +26;
            }
            else if(ch > 90)
            {
                ch = ch - 26;
            }

            St = St + (char)ch;
        }
        return St;
    }
    public static String UnObify(String Str)
    {
        Str = Str.replaceAll("OB","");
        return Str;
    }
    public static String DecryptStrng(String Str,int Shift)
    {
        Str = UnGroupify(Str);
        Str = UnCaesearify(Str,Shift);
        Str = UnObify(Str);
        return Str;
    }

//    public static StringBuffer Encrypt(String Str,int Shift)
//    {
//        StringBuffer temp = new StringBuffer();
//        for(int i=0; i<Str.length();i++)
//        {
//            if(Character.isUpperCase(Str.charAt(i)))
//            {
//                char ch = (char)(((int)Str.charAt(i)+Shift-65)%26 + 65);
//                temp.append(ch);
//            }
//            else
//            {
//                char ch = (char)(((int)Str.charAt(i)+Shift-97)%26 + 97);
//                temp.append(ch);
//            }
//        }
//        return temp;
//    }
//    public static String shiftAlphabet(int Shift)
//    {
//        int Start = 0;
//
//        if(Shift < 0)
//        {
//            Start = (int)'Z'+Shift+1;
//        }
//        else
//        {
//            Start = (int)'A'+Shift;
//        }
//        String result = "";
//        char Ch = (char)Start;
//
//        for(; Ch<='Z'; Ch++)
//        {
//            result = result + Ch;
//        }
//
//        if(result.length() < 26)
//        {
//            for(char C = 'A'; result.length() < 26; C++)
//            {
//                result = result + C;
//            }
//        }
//        return  result;
//    }
}