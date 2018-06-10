CREATE TABLE Product(
    id INT NOT NULL  PRIMARY KEY,
    productName VARCHAR(50) NOT NULL,
    description VARCHAR(100) NOT NULL,
    singlePrice LONG NOT NULL,
    quantity LONG NOT NULL
) engine=InnoDB DEFAULT CHARSET = utf8;

