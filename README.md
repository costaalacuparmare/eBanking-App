# eBanking Application with minimal functionality implementing Design Patterns

> usage: java -jar eBanking.jar <exchange_rates_path> <stock_values_path> <input_path>

> List of commands:
>
> CREATE USER <email> <firstname> <lastname> <address>
>
>ADD FRIEND <emailUser> <emailFriend>
> 
>ADD ACCOUNT <email> <currency>
> 
>ADD MONEY <email> <currency> <amount>
> 
>EXCHANGE MONEY <email> <sourceCurrency> <destinationCurrency> <amount>
> 
>TRANSFER MONEY <email> <friendEmail> <currency> <amount>
> 
>BUY STOCKS <email> <company> <noOfStocks>
> 
>RECOMMEND STOCKS
> 
>LIST USER <email>
> 
>LIST PORTFOLIO <email>
> 
> BUY PREMIUM <email>


### Constantinescu Vlad

The source folder contains:

- Account.java: contains the Account interface and its methods
- AccountCAD - AccountUSD: contain implementations of the Account interface for
  the Factory Pattern
- AccountFactory.java: contains the AccountFactory class and its methods
- AddAccountCommand.java: contains the AddAccountCommand class and its methods
- AddFriendCommand.java: contains the AddFriendCommand class and its methods
- AddMoneyCommand.java: contains the AddMoneyCommand class and its methods
- BuyPremiumCommand.java: contains the BuyPremiumCommand class and its methods
- BuyStockCommand.java: contains the BuyStockCommand class and its methods
- CreateUserCommand.java: contains the CreateUserCommand class and its methods
- ExchangeMoneyCommand.java: contains the ExchangeMoneyCommand class and its
  methods
- ListPortfolioCommand.java: contains the ListPortfolioCommand class and its
  methods
- ListUsersCommand.java: contains the ListUsersCommand class and its methods
- RecommendStockCommand.java: contains the RecommendStockCommand class and its
  methods
- TransferMoneyCommand.java: contains the TransferMoneyCommand class and its
  methods
- Command.java: contains the Command interface and its methods used for the
  Command Pattern
- BankingApp.java: contains the BankingApp class and its methods used for Singleton
  Pattern
- Constants.java: contains the Constants interface and constants used in the
  application
- ExchangeRates.java: contains the ExchangeRates class and its methods used for
  the Singleton Pattern and memorizing the exchange rates
- StockValues.java: contains the StockValues class and its methods used for the
  Singleton Pattern and memorizing the stock values
- User.java: contains the User class, its methods and the UserBuilder class used
  for the Builder Pattern
- Main.java: contains the main method and the implementation of the application

## General Implementation
```     
- The application is implemented using the Singleton Pattern for the ExchangeRates
  and StockValues classes, the Factory Pattern for the AccountFactory class, the
  Command Pattern for the Command interface and its implementations, and the
  Builder Pattern for the User class
- The main class uses BankApp to create the application and read the input
- The input is read using a BufferedReader and the commands are parsed using a
  switch statement
- The information is stored in a HashMap of Users and a HashMap of Accounts
- The commands are stored in a list and executed in the order they were read
```

## Classes and Methods

- `Main` contains the main method and handles input/output, leaving the
  implementation of the application to the `BankingApp` class


- `BankingApp` implements the Singleton Pattern for managing the application,
  containing the storage for the users and accounts, and the list of commands
  parsed with a switch statement as well as memorizing the exchange rates and stock values


- `Constants` contains the constants used in the application


- `ExchangeRates` implements the Singleton Pattern for managing exchange rates,
  containing the exchange rates and methods for getting and setting them


- `StockValues` implements the Singleton Pattern for managing stock values,


- `Account` contains the Account interface and its methods, correlating to the other
  classes implementing the interface: `AccountCAD`, `AccountEUR`, `AccountGBP`, `AccountJPY`, `AccountUSD`
  and the `AccountFactory` class


- `Command` contains the Command interface and its methods used for the Command
  Pattern, correlating to the other classes implementing the interface:
  `AddAccountCommand`, `AddFriendCommand`, `AddMoneyCommand`, `BuyPremiumCommand`, `BuyStockCommand`,
  `CreateUserCommand`, `ExchangeMoneyCommand`, `ListPortfolioCommand`, `ListUsersCommand`, `RecommendStockCommand`,
  `TransferMoneyCommand`


- `User` contains all the information about a user and its accounts, and the
  `UserBuilder` class used for the Builder Pattern

## Command List and Implementation Details

- `CreateUserCommand` creates a new user with the given email, first name, last
  name and address, and adds it to the users hashmap


- `AddFriendCommand` adds a friend to the user with the given email, if the
  friend exists, and adds the user to the friend's list of friends


- `AddAccountCommand` adds an account to the user with the given email, if the
  user exists, and adds the account to the user's list of accounts


- `AddMoneyCommand` adds money to the account of the user with the given email,


- `ExchangeMoneyCommand` exchanges money from the account of the user with the
  given email, if the user exists, and adds the exchanged money to the account
  of the user. If the amount to be exchanged exceeds 50% of the source account
  value, a 1% commission is applied to the transfer


- `TransferMoneyCommand` transfers money from the account of the user with the 
  given email to the account of the friend with the given email, if the user
  and the friend exist, and adds the transferred money to the account of the
  friend


- `BuyStockCommand` buys stocks from the company with the given name for the user
  with the given email, if the user exists, and adds the bought stocks to the
  user's list of stocks (always done from the USD account)


- `RecommendStocksCommand` recommends stocks to the user with the given email, based on
  a simplified version of the Simple Moving Average (SMA) Crossover Strategy


- `ListUserCommand` lists the user in the application


- `ListPortfolioCommand` lists the portfolio of the user with the given email


## Bonus

### Premium Account Option

- `BuyPremiumCommand` buys a premium account for the user with the given email,
  if the user exists, and adds the premium feature to all accounts. The premium
  feature costs 100 USD and is bought from the USD account and has the following 
  advantages: no commission for the exchange of currency and a 5% discount for the
  purchase of stocks recommended by the application