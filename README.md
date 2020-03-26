# BankOCR

https://github.com/testdouble/contributing-tests/wiki/Bank-OCR-kata

### General Overview

The entry point for this application is in the App class.

Planned structure of the App:

                    App
                     |
                 singleton
                     |
                [ BankOCR ]
                     |
                    many
                     |
                 [ Entry ] has interface
                     |
                    many
                     |
                 [ Digit ] has interface

Tests:

- AppTest
- DigitTest
- EntryTest

#### Run

```
mvn package
...
```

#### Test

```
mvn test
```