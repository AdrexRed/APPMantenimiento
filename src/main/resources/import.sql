INSERT INTO area(nom_area) VALUES('Gerencia')
INSERT INTO area(nom_area) VALUES('Comercial y Ventas')
INSERT INTO area(nom_area) VALUES('Contabilidad')
INSERT INTO area(nom_area) VALUES('Financiera')
INSERT INTO area(nom_area) VALUES('Produccion')
INSERT INTO area(nom_area) VALUES('Recursos Humanos')
INSERT INTO area(nom_area) VALUES('IT')

INSERT INTO tipo_mtto(nom_mtto) VALUES('Software')
INSERT INTO tipo_mtto(nom_mtto) VALUES('Hardware')

INSERT INTO estado(nom_estado, fecha_mod, descripcion) VALUES('Abierto', NOW(), 'Es cuando el caso empieza')
INSERT INTO estado(nom_estado, fecha_mod, descripcion) VALUES('Asignado', NOW(), 'Es cuando el caso es asignado a un técnico')
INSERT INTO estado(nom_estado, fecha_mod, descripcion) VALUES('Esperando', NOW(), 'Es cuando el caso esta en espera de un repuesto')
INSERT INTO estado(nom_estado, fecha_mod, descripcion) VALUES('Cerrado', NOW(), 'Es cuando el caso a sido solucionado y terminado')

INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Patricio','Canals Colomer', 1, 'Gerente General','usuario1@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario1');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Jordi','Villalobos Cañas', 2, 'Gerente de ventas','usuario2@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario2');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Rómulo','del Bravo', 2, 'Asistente de Ventas','usuario3@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario3');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Segismundo','Garcia Alegre', 3, 'Gerente Financiera','usuario4@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario4');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('María Teresa','Roda Cuervo', 3, 'Asistente financiero','usuario5@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario5');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Francisco Javier','Lillo Molins', 3, 'Auxiliar contable','usuario6@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario6');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Demetrio','de Granados', 4, 'Gerente de produccion','usuario7@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario7');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Pascual','Olmo Cuéllar', 4, 'Control de produccion','usuario8@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario8');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Cecilia','Galvez Pereira', 4, 'Mantenimiento','usuario9@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario9');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Nando','de Jiménez', 4, 'Almacenista','usuario10@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario10');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Eva María','Almazán-Andrés ', 5, 'Jefe de recursos humanos','usuario11@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario11');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Benigno','de Zurita', 5, 'Administrador de personal','usuario12@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario12');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('José Ángel','Bernardino Cerro', 5, 'Técnico en formación y desarrollo','usuario13@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','usuario13');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('María Ángeles','Prada ', 6, 'Jefe de area TI','admin1@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','admin1');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Amado','Tejero Gomila', 6, 'Ingeniero de Software','tech1@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','tech1');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Benigna','Feliu Román', 6, 'Soporte Técnico','tech2@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','tech2');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Serafina','Escalona Pla', 6, 'Soporte Técnico','tech3@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','tech3');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Marcelo','de Bernat', 6, 'Soporte Técnico','tech4@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','tech4');
INSERT INTO usuarios(nombres, apellidos, area, posicion,email,enabled,password,username) VALUES('Albina','Baena ', 6, 'Soporte Técnico','tech5@correo.com', true,'$2a$10$5Bkj/wbfLkp0cJoJoRwTEuwd6Ea.huI5TuC/2yN.3wArjA.LKYA/u','tech5');

INSERT INTO tecnicos(usuario, casos_asignados, nivel, disponible) VALUES(14, 0, 1, true);
INSERT INTO tecnicos(usuario, casos_asignados, nivel, disponible) VALUES(15, 0, 2, true);
INSERT INTO tecnicos(usuario, casos_asignados, nivel, disponible) VALUES(16, 0, 2, true);
INSERT INTO tecnicos(usuario, casos_asignados, nivel, disponible) VALUES(17, 0, 3, true);
INSERT INTO tecnicos(usuario, casos_asignados, nivel, disponible) VALUES(18, 0, 3, true);
INSERT INTO tecnicos(usuario, casos_asignados, nivel, disponible) VALUES(19, 0, 1, true);

INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('cm8QFYquF2TN', 'ASUS', 'AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 19);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('pjDzJwjKZRiY', 'HP','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 1);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('ztwEYQsaTVDd', 'DELL','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 14);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('opEJtA6PJjHS', 'DELL','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 15);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('9X6qrnBYGChn', 'ACER','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 2);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('ZyMLXpyqsziz', 'LENOVO','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 3);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('MAKBQKu2qzwo', 'LENOVO','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 4);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('dTovoyCLoszV', 'ACER','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 5);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('EVzrc9CXufFt', 'HP','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 6);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('3iKSnR3PtQVR', 'DELL','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 7);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('B9Mu5HihrjPM', 'LENOVO','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 8);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('Md3JXZvMzUPC', 'DELL','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 16);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('Y8LBw4wEQtVj', 'DELL','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 17);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('a8MKy3KekdsF', 'LENOVO','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 9);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('GdSdkwoBthrG', 'ASUS','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 10);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('wzcbR7dHeNHv', 'ASUS','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 11);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('jBd5qQsN6z44', 'ACER','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 12);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('jg8PvuK9mz9z', 'HP','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 13);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('7NS6QQgKSorm', 'HP','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 14);
INSERT INTO equipo(serial, marca, descripcion, asignado) VALUES('B5B8M9qYZVQy', 'DELL','AMD Ryzen™ 5 5600H De 15.6" FHD (1920x1080), IPS, 250 nits, antirreflejos, 16:9, 800:1, 45% NTSC, 170°, Refresh rate 60Hz, DC dimmer Hasta 16GB DDR4-3200 NVIDIA® GeForce® GTX 1650', 18);

INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES('ROLE_TECH');

INSERT INTO usuario_roles(usuario_id,role_id) VALUES(1,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(2,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(3,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(4,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(5,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(6,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(7,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(8,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(9,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(10,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(11,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(12,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(13,1);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(14,2);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(14,3);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(15,3);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(16,3);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(17,3);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(18,3);
INSERT INTO usuario_roles(usuario_id,role_id) VALUES(19,3);
