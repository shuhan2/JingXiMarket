CREATE TABLE Reserve(
    id INT NOT NULL  PRIMARY KEY,
    productName VARCHAR(50) NOT NULL,
    quantity LONG NOT NULL,
    constraint `Id_for` FOREIGN KEY (`id`) REFERENCES `Product` (`id`) on delete cascade on update cascade
) engine=InnoDB DEFAULT CHARSET = utf8;
