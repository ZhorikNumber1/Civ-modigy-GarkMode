CREATE TABLE IF NOT EXISTS units_civilian (
                                          id             SERIAL PRIMARY KEY,
                                          unit_type      VARCHAR(255) DEFAULT '-1',
                                          name_photo     VARCHAR(255) DEFAULT '-1',
                                          cost           INT DEFAULT -1,
                                          base_moves     INT DEFAULT -1,
                                          maintenance    INT DEFAULT -1,
                                          name           VARCHAR(255) DEFAULT '-1',
                                          description    VARCHAR(255) DEFAULT '-1',
                                          prereq_tech    VARCHAR(255) DEFAULT '-1',
                                          name_mod       VARCHAR(255),
                                          author         VARCHAR(255)
);
