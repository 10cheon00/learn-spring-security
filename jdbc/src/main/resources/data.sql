INSERT INTO users(username, password, is_enabled, role)
VALUES ("user1",
        "{bcrypt}$2a$10$cvqN0id5okYG66mePOySmuycTRQbm22Ecmi82dTMLiyjDcg2xxlyG",
        1,
        "ROLE_USER");
INSERT INTO users(username, password, is_enabled, role)
VALUES ("admin",
        "{bcrypt}$2a$10$2TQLRh018/JwqJ14sEVfwuAunDEWGjSJ38PSau7BRZRgFX.t6cswy",
        1,
        "ROLE_ADMIN");