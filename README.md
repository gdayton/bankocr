# BankOCR

https://github.com/testdouble/contributing-tests/wiki/Bank-OCR-kata

## 3 hour partial solution can be found on branch "3hr"

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
java -cp target/bank-ocr-1.0-SNAPSHOT.jar com.testdouble.bankocr.App
```

#### Test

```
mvn test
```