public class permutation {

    public static void permut(String str , String per , int idx){

        if(str.length()==0){
            System.out.println(per);
            return;
        }
        for (int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0,i) + str.substring(i+1);
            permut(newstr, per+curr, idx+1);
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        permut(str ,"",0);
    }
}
// full code 