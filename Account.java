package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;//hesap no
    private int pinNumber;//sifre

    private double checkingBalance;//Vadesiz hesap bakiyesi
    private double savingBalance;//Vadeli hesap bakiyesi

    DecimalFormat moneyFormat =new DecimalFormat("'$'###,##0.00");

    Scanner input=new Scanner(System.in);

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    // Checking Balance hesabı için para cekme ==> paraCekmeIslemindenSonraKalanMiktar    amount=miktar
    private double calculateCheckinBalanceAfterWithdraw(double amount){
      checkingBalance=checkingBalance-amount;
      return checkingBalance;
    }

    //Checking Balance hesabı için para yatırma ==> para yatırma işleminden sonra kalan bakiyeyi hesapla
    private double calculateCheckinBalanceAfterDeposit(double amount){
        checkingBalance=checkingBalance+amount;
        return checkingBalance;
    }

    //Saving Balance hesabı içinpara cekme ==> paraCekmeIslemindenSonraKalanMiktar    amount=miktar
    private double calculateSavinBalanceAfterWithdraw(double amount){
        savingBalance=savingBalance-amount;
        return savingBalance;
    }
    //Saving Balance hesabı içinpara cekme ==> paraCekmeIslemindenSonraKalanMiktar    amount=miktar
    private double calculateSavinBalanceAfterDeposit(double amount){
        savingBalance=savingBalance+amount;
        return savingBalance;
    }

    //para çekme(checking):Müşteri ile para çekmek için etkileşime girelim
    public void getCheckingWitdraw(){
        displayCurrentAmount(checkingBalance);
        System.out.println("Çekmek istediğiniz miktari giriniz: ");
        double amount =input.nextDouble();

        if (amount<=0){
            System.out.println("Sıfır veya negatif sayılar geçersizdir!");
            getCheckingWitdraw();//recursive method ==> methodu tekrardan çağırma
        }else if(amount<= checkingBalance){
            calculateCheckinBalanceAfterWithdraw(amount);
            displayCurrentAmount(checkingBalance);
        }else {
            System.out.println("Yetersiz Bakiye!");
        }
    }

    //para yatırma(checking):Müşteri ile para yatırmak için etkileşime girelim
    public void getCheckingDeposit(){
        displayCurrentAmount(checkingBalance);
        System.out.println("Yatırmak istediğiniz miktari giriniz: ");
        double amount =input.nextDouble();

        if (amount<=0){
            System.out.println("Sıfır veya negatif sayılar geçersizdir!");
            getCheckingDeposit();//recursive method ==> methodu tekrardan çağırma
        }else{
            calculateCheckinBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount(checkingBalance);

        }
    }

    //para çekme(saving):Müşteri ile para çekmek için etkileşime girelim
    public void getSavingWitdraw(){
        displayCurrentAmount(savingBalance);
        System.out.println("Çekmek istediğiniz miktari giriniz: ");
        double amount =input.nextDouble();

       if (amount<=0){
           System.out.println("Sıfır veya negatif sayılar geçersizdir!");
           getSavingWitdraw();
       } else if (amount<=savingBalance) {
           calculateSavinBalanceAfterWithdraw(amount);
           displayCurrentAmount(savingBalance);
       }else {
           System.out.println("Yetersiz Bakiye!");
       }
    }

    //para yatırma(saving):Müşteri ile para yatırmak için etkileşime girelim
    public void getSavingDeposit(){
        displayCurrentAmount(savingBalance);
        System.out.println("Yatırmak istediğiniz miktari giriniz: ");
        double amount =input.nextDouble();

        if (amount<=0){
            System.out.println("Sıfır veya negatif sayılar geçersizdir!");
            getSavingDeposit();//recursive method ==> methodu tekrardan çağırma
        }else{
            calculateSavinBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentAmount(savingBalance);
        }
    }



    //son bakiyeyi göster
    public void displayCurrentAmount(double balance){
        System.out.println("Hesabınızda bulunan bakiye: "+ moneyFormat.format(balance));
    }




}
