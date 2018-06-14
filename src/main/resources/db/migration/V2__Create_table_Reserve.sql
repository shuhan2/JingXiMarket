CREATE TABLE Reserve(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL,
    productName VARCHAR(50) NOT NULL,
    quantity INT NOT NULL
--     constraint `Id_for` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`) on delete cascade on update cascade
) engine=InnoDB DEFAULT CHARSET = utf8;
