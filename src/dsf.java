class er{
    public static void main(String[] args)
            throws java.io.IOException{
        int ch,ch1,g,g1;
        System.out.println("Игра крестики нолики");
        boolean t=false,t1=false;
        sow d =new sow();
        char a[][]=new char[3][3];
        int sum=1;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] =(char)('0'+sum);
                sum++;
            }
        }
        int r,r1;
        int r12=1;
        int loser=0;
        while(t==false && t1==false && loser!=a.length*a.length){
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print("| "+a[i][j]+" |");
                }
                System.out.println();
            }
            if (r12%2!=0)
                System.out.println("игрок 1");
            else System.out.println("игрок 2");
            System.out.println("введите кординаты от 0 до 2");
            System.out.println("первые");
            ch=(char)System.in.read();

            do{
                g=(char)System.in.read();
            }while(g!='\n');
            r=Character.getNumericValue(ch);
            System.out.println("вторые");
            ch1=(char)System.in.read();
            do{
                g1=(char)System.in.read();
            }while(g1!='\n');
            r1=Character.getNumericValue(ch1);
            System.out.println();

            if (a[r][r1] !='x' && a[r][r1]!='y'){
                if(r12%2!=0)
                    a[r][r1]='x';
                else a[r][r1]='y';
                loser++;
            }else
            {
                System.out.println("нельзя! ");
            }
            int size=a.length;
            if(r12%2!=0){
                t=d.in(a,size,r12);
            }else {
                t1=d.in(a,size,r12);
            }
            r12++;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("| "+a[i][j]+" |");
            }
            System.out.println();
        }
        if(t==true)
            System.out.println("Игрок 1 победил");
        if (t1==true)
            System.out.println("Игрок 2 победил");
        if(loser==a.length*a.length)
            System.out.println("Никто не победил");

    }
}
class sow{
    static boolean in(char er[][],int er12,int er34){
        char erer=' ';
        int count=0;
        char lok=' ';
        if(er34 % 2!=0)
            lok='x';
        else lok='y';
        for(int i=0;i<er.length;i++){
            if(count==er12)
                break;
            count=0;
            for(int j=0;j<er[i].length;j++){
                erer=er[i][j];
                if(erer==lok){
                    count++;
                }
            }
        }
        if(count==er12)
            return true;

        count=0;
        int x=0,j=0,i=0;
        while(x<er.length){
            for( i=0;i<er.length;i++){
                {
                    erer=er[i][j];
                    if(erer==lok){
                        count++;
                    }
                }
            }
            if(count==er12)
                break;
            count=0;
            x++;
            j++;
        }
        return count==er12;
    }
}