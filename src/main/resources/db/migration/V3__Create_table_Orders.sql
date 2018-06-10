CREATE TABLE Orders(
    id INT NOT NULL PRIMARY KEY,
    productId INT NOT NULL,
    productName VARCHAR(50)NOT NULL,
    quantity LONG NOT NULL,
    totalPrice LONG NOT NULL,
    status VARCHAR(100) NOT NULL,
    buyer VARCHAR(50) NOT NULL,
    createTime DATETIME NOT NULL,
    payTime DATETIME ,
    cancelTime DATETIME,
    finishTime DATETIME,
    address VARCHAR(100) NOT NULL,
    constraint `product_Id_for` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`) on delete cascade on update cascade
) engine=InnoDB DEFAULT CHARSET = utf8;

