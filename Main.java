import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String imie;
    static String nazwisko;
    static String email;
    static String haslo;
    public static void main(String[] args) {
        pobierz();
        if(walidacja()){
            System.out.println("super");
        }

    }

    public static void pobierz(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        imie = sc.nextLine();
        System.out.println("Podaj nazwisko: ");
        nazwisko = sc.nextLine();
        System.out.println("Podaj email: ");
        email = sc.nextLine();
        System.out.println("Podaj haslo: ");
        haslo = sc.nextLine();

        imie = imie.trim();
        nazwisko = nazwisko.trim();
        email = email.trim();
        haslo = haslo.trim();
    }

    public static boolean walidacja(){
        if(imie.isEmpty() || nazwisko.isEmpty() || email.isEmpty() || haslo.isEmpty()){
            System.out.println("wypelnij wszystkie pola!!!");
            return false;
        }else{
            if(!email.contains("@") || !email.contains(".")){
                System.out.println("zly email");
                return false;
            }else{
                if(haslo.length() < 8 || !haslo.matches(".*[a-z].*") || !haslo.matches(".*[A-Z].*") || !haslo.matches(".*[^a-zA-Z0-9]*.")){
                    System.out.println("tragiczne haslo");
                    return false;
                }
            }
        }
        return true;


    }


}
