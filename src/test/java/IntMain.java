public class IntMain {

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println(i); //1
        int j = i++;
        int k = i + (++i) * (i++);
        System.out.println(i); //4
        System.out.println(j); //2
        System.out.println(k); //11
    }

}
