INSERT INTO roles(name) VALUES ("ROLE_USER");
INSERT INTO roles(name) VALUES ("ROLE_ADMIN");

INSERT INTO users(username, password, is_enabled)
VALUES ("user1",
        "{bcrypt}$2a$10$cvqN0id5okYG66mePOySmuycTRQbm22Ecmi82dTMLiyjDcg2xxlyG",
        1);
INSERT INTO users(username, password, is_enabled)
VALUES ("admin",
        "{bcrypt}$2a$10$2TQLRh018/JwqJ14sEVfwuAunDEWGjSJ38PSau7BRZRgFX.t6cswy",
        1);

INSERT INTO user_roles(users_id, roles_id) VALUES(1, 1);
INSERT INTO user_roles(users_id, roles_id) VALUES(2, 2);
