import java.util.Arrays;
import java.util.*;

public class chocolaProblem {
    public static void main(String args[]){
        int n=4; int m=6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0; int v=0;
        int hp=1; int vp=1;
        int cost = 0;
        while(h<costHor.length && v<costVer.length){
            if(costHor[h] <= costVer[v]){ //Vertical Cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }else{ ///horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
        }

        while(h<costHor.length){
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while(v<costVer.length){
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum Cost = " + cost);
    }
}
