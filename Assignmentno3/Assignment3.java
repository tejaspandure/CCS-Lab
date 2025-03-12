import java.util.*;

public class Assignment3 {

    private static boolean isPrime(int iNo1)
    {
        if (iNo1 < 2)
        {
            return false;
        }
        for (int iCnt = 2; iCnt < iNo1; iCnt++)
        {
            if (iNo1 % iCnt == 0)
            {
                return false;
            }
        }
        return true;
    }

    private static int modExp(int base, int exp, int mod)
    {
        int result = 1;
        base = base % mod;
        while (exp > 0)
        {
            if ((exp & 1) == 1)
            {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int iValue1 = 0;
        int iG = 0;
        int iX = 0;
        int iY = 0;


        while(true)
        {
            System.out.println("Enter the prime number");
            iValue1 = sc.nextInt();
            if (!isPrime(iValue1))
            {
                System.out.println("p is not prime. Try again.");
                continue;
            }
            System.out.println("Entered prime no is-->" + iValue1);
            break;
        }

        System.out.println("Enter the primitive root of iValue1");
        iG= sc.nextInt();

        System.out.println("Entered primitive root is" + iG);

        System.out.println("Enter the private key for user A");
        iX = sc.nextInt();

        System.out.println("Entered private key of user A is" + iX);
        System.out.println("Enter the private key for user B");

        iY = sc.nextInt();
        System.out.println("Entered private key of user B is" + iY);

        if (iX < iValue1 && iY < iValue1)
        {
            System.out.println("private key selected");
        }
        else
        {
            System.out.println("private key must be less than prime number P");
        }

        int iA = modExp(iG, iX, iValue1);
        System.out.println("public key for user A is" + iA);

        int iB= modExp(iG, iY, iValue1);
        System.out.println("public key for user B is" + iB);

        int iK = modExp(iB, iX, iValue1);
        System.out.println("Secrete key for user A is" + iK);

        int iK1 = modExp(iA, iY, iValue1);
        System.out.println("Secrete key for user B is" + iK1);

    }
}