delete from pizza_order_pizzas;
delete from pizza_ingredients;
delete from pizza;
delete from pizza_order;
delete from ingredient;

insert into ingredient (id, name, type) values ('FLTO', 'Flour Tortilla', 'CRUST');
insert into ingredient (id, name, type) values ('COTO', 'Corn Tortilla', 'CRUST');
insert into ingredient (id, name, type) values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into ingredient (id, name, type) values ('CARN', 'Carnitas', 'PROTEIN');
insert into ingredient (id, name, type) values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into ingredient (id, name, type) values ('LETC', 'Lettuce', 'VEGGIES');
insert into ingredient (id, name, type) values ('CHED', 'Cheddar', 'CHEESE');
insert into ingredient (id, name, type) values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into ingredient (id, name, type) values ('SLSA', 'Salsa', 'SAUCE');
insert into ingredient (id, name, type) values ('SRCR', 'Sour Cream', 'SAUCE');
