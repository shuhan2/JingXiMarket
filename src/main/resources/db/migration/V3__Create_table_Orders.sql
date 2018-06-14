CREATE TABLE Orders(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL,
    productName VARCHAR(50)NOT NULL,
    quantity INT NOT NULL,
    totalPrice INT NOT NULL,
    status VARCHAR(100) NOT NULL,
    buyer VARCHAR(50) NOT NULL,
    createTime DATETIME NOT NULL,
    payTime DATETIME ,
    cancelTime DATETIME,
    finishTime DATETIME,
    address VARCHAR(100) NOT NULL,
    expressId INT,
    constraint `product_Id_for` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`) on delete cascade on update cascade
) engine=InnoDB DEFAULT CHARSET = utf8;

