CREATE TABLE Express(
    id INT NOT NULL  PRIMARY KEY,
    productId INT NOT NULL,
    productName VARCHAR(50) NOT NULL,
    quantity LONG NOT NULL,
    status VARCHAR(50) NOT NULL,
    buyer VARCHAR(50) NOT NULL,
    couier VARCHAR(50) NOT NULL,
    constraint `productId_for` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`) on delete cascade on update cascade
) engine=InnoDB DEFAULT CHARSET = utf8;

--  private Long Id;
--     private Long productId;
--     private String productName;
--     private Long quantity;
--     private List<ExpressHalfway> halfway;
--     private String status;
-- //    private Date time;
--     private String buyer;
--     private String courier;