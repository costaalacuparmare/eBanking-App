package eBanking_App;

public interface Account {
  void deposit(double amount);
  void withdraw(double amount);
  double getAmount();
  String getCurrency();
  String toString();
}
