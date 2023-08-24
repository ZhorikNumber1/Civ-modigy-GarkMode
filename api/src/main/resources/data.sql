DELETE FROM Units_civilian;
INSERT INTO Units_civilian  (name_photo,                    cost,   base_moves, Name,           id, unit_type,              combat)
values                      ("Settler_(Civ6).png",          80,     2,          "Settler",      0,  "UNIT_SETTLER",             -1),
                            ("Builder_(Civ6).png",          50,     2,          "Строитель",    1,  "UNIT_BUILDER",             -1),
                            ("Archaeologist_(Civ6).png",    400,    4,          "Археолог",     2,  "UNIT_ARCHAEOLOGIST",       -1),
                            ("Warrior_(Civ6).png",          100,    2,          "Воин",         3,  "UNIT_WARRIOR",             20);