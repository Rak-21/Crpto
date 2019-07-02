import java.util.*;
public class Crypto {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Text to be Encrypted  :   ");
        String Str = input.nextLine();
        System.out.print("Enter the Shift value   :   ");
        int Shift = input.nextInt();
        System.out.print("Enter the Grouping size  :   ");
        int GroupSize = input.nextInt();
        Str = EncryptString(Str,Shift,GroupSize);
        System.out.println(Str);
    }
    public static String Normalise(String Str)
    {
        Str = Str.replaceAll("\\p{Space}","");          //  Str.replaceAll(" ","");
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
}
