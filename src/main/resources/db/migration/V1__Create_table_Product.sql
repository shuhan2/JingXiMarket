CREATE TABLE Product(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    productName VARCHAR(50) NOT NULL,
    description VARCHAR(100) NOT NULL,
    singlePrice INT NOT NULL,
    quantity INT NOT NULL
) engine=InnoDB DEFAULT CHARSET = utf8;

