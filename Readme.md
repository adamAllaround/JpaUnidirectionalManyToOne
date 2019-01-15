# Many to One JPA entity mapping with Hibernate

This repository presents how to set up many to one entity mapping with JPA annotations. 
Entity relation between CreditCard and Account classes is the basis of code example. 

*You can find an extensive description about how this mapping works, and why its useful on [allAroundJava blog](https://allaroundjava.com/many-to-one-jpa-hibernate/).*

Code example uses log4j2 library to show what SQL statements are being executed. Feel free to clone the repo and launch the test class to understand how Hibernate handles many to one mapping select and insert queries.