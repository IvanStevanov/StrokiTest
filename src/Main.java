import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String strings = scanner.nextLine();
        char znak;
        String[] dvaOpera;
        if
        (strings.contains(" + ")) {
            dvaOpera = strings.split(" \\+ ");
            znak = '+';
        } else if
        (strings.contains(" - ")) {
            dvaOpera = strings.split(" - ");
            znak = '-';
        } else if
        (strings.contains(" * ")) {
            dvaOpera = strings.split(" \\* ");
            znak = '*';
        } else if
        (strings.contains(" / ")) {
            dvaOpera = strings.split(" / ");
            znak = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (znak == '*' || znak == '/') {
            if (dvaOpera[1].contains("\"")) throw new Exception("Нельзя делить или умножать на строку");
        }
        for
        (int i = 0; i < dvaOpera.length; i++) {
            dvaOpera[i] = dvaOpera[i].trim().replace("\"", "");
        }
        if (dvaOpera[0].length()>10 || dvaOpera[1].length()>10) throw new Exception("Строка должна иметь не больше 10 символов");
        if
        (znak == '+') {
            String sum = dvaOpera[0]+dvaOpera[1];
            sum= sum.replaceAll(" ", "");
            resultat(sum);
        } else if (znak == '-') {
            int index = dvaOpera[0].indexOf(dvaOpera[1]);
            if (index == -1) {
                resultat(dvaOpera[0]);
            } else {
                String minus = dvaOpera[0].substring(0,index);
                minus += dvaOpera[0].substring(index + dvaOpera[1].length());
                resultat(minus);
            }
        } else if (znak== '*') {
            int oper2 = Integer.parseInt(dvaOpera[1]);
            String umn = ("");
            for (int i =0; i<oper2; i++){
                umn+=(dvaOpera[0]);
            }
            if (umn.length()<=40){
                resultat(umn);}
            else if (umn.length()>40){
                umnojenie(umn);}
        } else {
            int index = dvaOpera[0].length()/Integer.parseInt(dvaOpera[1]);
            String del= dvaOpera[0].substring(0,index);
            resultat(del);
        }
    }
    static  void resultat (String a){
        System.out.println("\""+a+"\"");
    }
    static void umnojenie (String a){
        a=a.substring(0,40)+"...";
        System.out.println("\""+a+"\"");
    }

}
