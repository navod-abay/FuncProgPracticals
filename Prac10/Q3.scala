class Account(var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    } else if (amount > balance) {
      println("Insufficient funds.")
    } else {
      println("Withdrawal amount must be positive.")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    } else if (amount > balance) {
      println("Insufficient funds for transfer.")
    } else {
      println("Transfer amount must be positive.")
    }
  }

  def checkBalance(): Unit = {
    println(s"Current balance: $$${balance}")
  }
}

class Bank(var accounts: List[Account]) {
  def addAccount(account: Account): Unit = {
    accounts = accounts :+ account
  }

  def accountsWithNegativeBalances(): List[Account] = {
    accounts.filter(account => account.balance < 0)
  }

  def totalBalance(): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterest(): Unit = {
    accounts.foreach { account =>
      if (account.balance > 0) {
        account.balance += account.balance * 0.05
      } else if (account.balance < 0) {
        account.balance += account.balance * 0.1
      }
    }
  }
}


object BankApp extends App {
  val bank = new Bank(List())

  val account1 = new Account(1000.0)
  val account2 = new Account(-200.0)
  val account3 = new Account(1500.0)

  bank.addAccount(account1)
  bank.addAccount(account2)
  bank.addAccount(account3)

  println("Initial balances:")
  account1.checkBalance()
  account2.checkBalance()
  account3.checkBalance()

  println("\nApplying interest to all accounts...")
  bank.applyInterest()

  println("\nBalances after applying interest:")
  account1.checkBalance()
  account2.checkBalance()
  account3.checkBalance()

  println("\nAccounts with negative balances:")
  bank.accountsWithNegativeBalances().foreach(_.checkBalance())

  println(s"\nTotal balance in the bank: $${bank.totalBalance()}")
}