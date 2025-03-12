import java.util.*;

class Assignment2
{

    private static boolean isPrime(int iNo1)
    {
        if (iNo1 < 2)
        {
            return false;
        }
        for (int iCnt = 2; iCnt * iCnt <= iNo1; iCnt++)
        {
            if (iNo1 % iCnt == 0)
            {
                return false;
            }
        }
        return true;
    }

    private static int GCD(int iNo1, int iNo2)
    {
        while (iNo2 != 0)
        {
            int itemp = iNo2;
            iNo2 = iNo1 % iNo2;
            iNo1 = itemp;
        }
        return iNo1;
    }

    private static int findE(int iNo1)
    {
        for (int iCnt = 2; iCnt < iNo1; iCnt++)
        {
            if (GCD(iCnt, iNo1) == 1)
            {
                return iCnt;
            }
        }
        return 2;
    }

    private static int findD(int iNo1, int iNo2)
    {
        int t = 0;
        int newT = 1;
        int r = iNo1;
        int newR = iNo2;

        while (newR != 0)
        {
            int quotient = r / newR;
            int tempT = t;
            t = newT;
            newT = tempT - quotient * newT;
            int tempR = r;
            r = newR;
            newR = tempR - quotient * newR;
        }

        if (r > 1)
        {
            return -1;
        }

        if (t < 0)
        {
            t = t + iNo1;
        }

        return t;
    }

    private static int modExp(int iM, int iNo2, int iNo3)
    {
        int iRet = 1;
        iM = iM % iNo3;
        while (iNo2 > 0)
        {
            if ((iNo2 & 1) == 1)
            {
                iRet = (iRet * iM) % iNo3;
            }
            iNo2 >>= 1;
            iM = (iM * iM) % iNo3;
        }
        return iRet;
    }

    public static void main(String args[])
    {
        int iValue1 = 0;
        int iValue2 = 0;
        int iN = 0;
        int iA = 0;
        int iE = 0;
        int iM = 0;
        int iD = 0;
        int iMod = 0;
        int iEncrypted = 0;
        int iDecrypted = 0;
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter a prime number p: ");
            iValue1 = sc.nextInt();
            if(!isPrime(iValue1))
            {
                System.out.println("p is not prime. Try again.");
                continue;
            }

            System.out.print("Enter another prime number q: ");
            iValue2 = sc.nextInt();

            if(!isPrime(iValue2))
            {
                System.out.println("q is not prime. Try again.");
                continue;

            }
            if(iValue1 != iValue2)
                break;
            else
            {
                System.out.println("p and q should be different. Try again.");
            }
        }

        iN = iValue1 * iValue2;
        iA = (iValue1 - 1) * (iValue2 - 1);
        iE = findE(iA);
        iD = findD(iA, iE);

        System.out.println("The Value of N is  : " + iN);
        System.out.println("The value of phiN is : " + iA);
        System.out.println("The value of E: " + iE);
        System.out.println("The value of D: " + iD);

        System.out.println("Enter the message M: ");
        iM = sc.nextInt();

        iEncrypted = modExp(iM, iE, iN);
        System.out.println("The Encrypted message is: " + iEncrypted);

        iDecrypted = modExp(iEncrypted, iD, iN);
        System.out.println("The Decrypted message is: " + iDecrypted);
    }
}
