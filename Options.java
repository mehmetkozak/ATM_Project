package atmproject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account {

    Scanner input=new Scanner(System.in);

    DecimalFormat moneyFormat =new DecimalFormat("'$'###,##0.00");

    boolean flag=true;

    HashMap<Integer,Integer> data=new HashMap<>();

    public void login(){
        System.out.println("Kozak Bank ATM2ye Hoşgeldiniz");
        do {
            data.put(12345,1234);
            data.put(23456,2345);
            data.put(34567,3456);
            data.put(45678,4567);

            try {
                System.out.println("Hesap numaranızı giriniz");
                setAccountNumber(input.nextInt());
                System.out.println("Pin numaranızı giriniz");
                setPinNumber(input.nextInt());
            }catch (Exception e){
                System.out.println("Yanlış karakter girdiniz. Lütfen sadece rakam giriniz veya Q ile çıkabilirsiniz");
                input.nextLine();
                String exit=input.next();
                if (exit.equalsIgnoreCase("Q")){
                    flag=false;
                }
            }

            int count=0;
            for (Map.Entry<Integer,Integer> w:data.entrySet()){
                if (w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())){
                    getAccountTypes();
                }else {
                    count++;
                }
            }
            if (count==data.size()){
                System.out.println("Yanlış hesap veya pin numarası girdiniz");
            }


        }while (flag);



    }



    //Checking Hesap İşlemleri-Vadeli hesap işlemleri
    public void checkingOperations(){

        do {
           displayMessage();

            int option=input.nextInt();

            if (option==4){
                break;
            }
            switch (option){
                case 1:
                    System.out.println("Checking hesabınızda kalan bakiye"+moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWitdraw();
                    break;
                case 3:
                    getCheckingDeposit();
                    break;
                default:
                    System.out.println("Yanlış seçenek! Lütfen 1,2,3 veya 4'ü seçiniz");
            }

        }while(true);
        getAccountTypes();//İşlemler bitince Ana menüye geri dönemesini sağlıyoruz

    }

    //Vadeli hesap işlemleri
    public void savingOperations(){

        do {
           displayMessage();
            int option=input.nextInt();

            if (option==4){
                break;
            }
            switch (option){
                case 1:
                    System.out.println("Saving hesabınızda kalan bakiye"+moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    getSavingWitdraw();
                    break;
                case 3:
                    getSavingDeposit();
                    break;
                default:
                    System.out.println("Yanlış seçenek! Lütfen 1,2,3 veya 4'ü seçiniz");
            }
        }while (true);
        getAccountTypes();//İşlemler bitince Ana menüye geri dönemesini sağlıyoruz
    }

    //Ilgili hesabı seçiyorsunuz
    public void getAccountTypes(){
        System.out.println("İşlem yapmak istediğiniz hesabı seçiniz");
        System.out.println("1:Checking hesap");
        System.out.println("2:Saving hesap");
        System.out.println("3:Quit");

        int option=input.nextInt();

        switch (option){
            case 1:
                System.out.println("Checking/Vadesiz Hesabınızdasınız");
                checkingOperations();
                break;
            case 2:
                System.out.println("Saving/Vadeli Hesabınızdasınız");
                savingOperations();
                break;
            case 3:
                System.out.println("ATM makinemizi kullandığınız için teşekkür ederiz");
                flag=false;
                break;
            default:
                System.out.println("Yanlış seçenek! Lütfen 1,2 veya 3'ü  seçiniz");
        }
    }

    //kişi için seçenekleri görüntüle
    public void displayMessage(){

        System.out.println("Option seçiniz:");
        System.out.println("1: View Balance");//Bakiyeyi göster
        System.out.println("2: Withdraw");//Para Çekme İşlemleri
        System.out.println("3: Deposit");//Para Yatırma İşlemleri
        System.out.println("4: Exit");//İşlemi Sonlandır

    }
}
