public class Ass1 
{
    public static void main(String[] args) 
    {
        String str = "banana";
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) 
        {
            if (ch[i] == 'a') {
                ch[i] = 'o';
            }
        }

        System.out.println("Modified string: " + new String(ch));
    }
}