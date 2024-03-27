# Lesson 13

## Homework

* Complete [Applying SOLID principles](#applying-solid-principles-bank-atm) exercise.

## Applying SOLID Principles (Bank ATM)

Your task for this assignment is add enhancements to an ATM simulator. The [BankAtm][bankatm-file] is at the center of the model, allowing us to add one or more `CheckingAccount` instances and make withdrawals or deposits via cash or check. You will need to implement at least two of the following enhancements to the `BankAtm` class WITHOUT adding a new method (you can update existing methods, however).

* We want to support a `SavingsAccount` that works just like the `CheckingAccount`, but doesn't allow you to write checks against the account.
* We want the `BankAtm` class to support the concept of a `BusinessCheckingAccount`. A business account requires that at least one of the owning accounts is a business.
* In addition to supporting checks and cash, we also want to support the concept of another monetary instrument called a `MoneyOrder`. Unlike a `Check`, a `MoneyOrder` withdraws funds from a source account immediately on creation for the purposes of this simulation..

[bank-folder]: ./bank/
