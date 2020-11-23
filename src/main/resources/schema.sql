create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists Pizza (
    id int,
    name varchar(50) not null,
    createdAt timestamp not null
);

create table if not exists Pizza_Ingredients (
    pizza int not null,
    ingredient varchar(4) not null
);

alter table Pizza_Ingredients add foreign key (pizza) references Pizza(id);
 alter table Pizza_Ingredients add foreign key (ingredient) references Ingredient(id);

create table if not exists Pizza_Order (
    id int,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(2) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Pizza_Order_Pizzas (
    pizzaOrder int not null,
    pizza int not null
);

alter table Pizza_Order_Pizzas add foreign key (pizzaOrder) references Pizza_Order(id);
alter table Pizza_Order_Pizzas add foreign key (pizza) references Pizza(id);

