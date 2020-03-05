package com.cvezga.codechallenge.morganandastring;

import java.io.BufferedReader;

public class Solution
{
    static String morganAndString( String a, String b )
    {
        StringBuilder ans = new StringBuilder();

        int idxA = 0;
        int idxB = 0;

        while ( idxA < a.length() && idxB < b.length() )
        {

            if ( a.charAt( idxA ) < b.charAt( idxB ) )
            {
                ans.append( a.charAt( idxA++ ) );
            }
            else if ( a.charAt( idxA ) > b.charAt( idxB ) )
            {
                ans.append( b.charAt( idxB++ ) );
            }
            else
            {
                int[] k = comp( a, b, idxA, idxB );
                if ( k[0] < 0 )
                {
                    ans.append( a,idxA, k[1] );
                    idxA=k[1];
                }
                else if ( k[0] > 0 )
                {
                    ans.append( b, idxB,k[2] );
                    idxB=k[2];
                }
                else
                {
                    ans.append( a.charAt( idxA++ ) );
                }
            }
        }

        if ( idxA < a.length() )
        {
            ans.append( a.substring( idxA ) );
        }

        if ( idxB < b.length() )
        {
            ans.append( b.substring( idxB ) );
        }

       
        return ans.toString();
    }

    private static int[] comp( String a, String b, int idxA, int idxB )
    {
        int len1 = a.length() - idxA;
        int len2 = b.length() - idxB;
        int lim = Math.min( len1, len2 );

        int k = 0;
        while ( k < lim )
        {
            char c1 = a.charAt( idxA++ );
            char c2 = b.charAt( idxB++ );
            if ( c1 != c2 )
            {
                return new int[] {c1 - c2,idxA,idxB};
            }
            k++;
        }
        
        if( len1 > len2 ) return new int[] {-1,idxA,idxB};
        if( len1 < len2 ) return new int[] {1,idxA,idxB};
        
        return new int[] {0,idxA,idxB};
    }
}
