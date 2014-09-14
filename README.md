TaxCalculator
=============

A simple java based tax calculator.

#### Tax Due is computed at the following applicable rates:

- 1st 300000 of taxable Income at 7%

- Next 300000 11%

- Next 500000 15%

- Next 500000 19%

- Next 1600000 21%

- Above 3200000 24%

-------
##### For example

- 1,000,000 taxable income (**highest tax bracket 15%**)

- 1,000,000 - 300,000 = 700,000 i.e. tax = 21,000

- 700,000 - 300,000 = 400,000 i.e. tax = 33,000 + 21,000

- 400,000 * 0.15 = 60,000 i.e. tax = 60,000 + 33,000 + 21,000

Thus total tax =  114,000 for 1,000,000 taxable income



