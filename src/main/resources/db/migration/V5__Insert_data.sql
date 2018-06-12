INSERT INTO Product (id,productName,description,singleprice,quantity) VALUES ( 1, 'book','novel',20,1000 );
INSERT INTO Product (id,productName,description,singleprice,quantity) VALUES ( 2, 'milk','puremilk',40,1000 );
INSERT INTO Product (id,productName,description,singleprice,quantity) VALUES ( 3, 'headphone','VerticalVheadphone',100,1000 );

INSERT INTO Reserve (id,productId,productName,quantity) VALUES ( 1,1, 'book',1000 );
INSERT INTO Reserve (id,productId,productName,quantity) VALUES ( 2,2, 'milk',1000 );
INSERT INTO Reserve (id,productId,productName,quantity) VALUES ( 3,3, 'headphone',1000 );

INSERT INTO Orders (id,productId,productName,quantity,totalPrice,status,buyer,createTime,payTime,cancelTime,finishTime,address) VALUES
 ( 1, 1,'book',2,60,'CREATED','ZhangS',now(),null,null,null,'WuH' );
INSERT INTO Orders (id,productId,productName,quantity,totalPrice,status,buyer,createTime,payTime,cancelTime,finishTime,address) VALUES
 ( 2, 2,'milk',2,80,'CREATED','Lis','2018-03-11:11:32:23',null,null,null,'WuH' );
INSERT INTO Orders (id,productId,productName,quantity,totalPrice,status,buyer,createTime,payTime,cancelTime,finishTime,address) VALUES
 ( 3, 1,'book',2,60,'CREATED','WangW','2018-03-23:10:12:53',null,null,null,'WuH' );


