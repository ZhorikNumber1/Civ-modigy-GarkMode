DELETE FROM Units_civilian;
INSERT INTO Units_civilian  (name_photo,                    cost,   base_moves, Name,           id, unit_type,              combat, ranged_combat)
values                      ("Settler_(Civ6).png",          80,     2,          "Поселенец",    0,  "UNIT_SETTLER",             -1,      -1),
                            ("Builder_(Civ6).png",          50,     2,          "Строитель",    1,  "UNIT_BUILDER",             -1,      -1),
                            ("Archaeologist_(Civ6).png",    400,    4,          "Археолог",     2,  "UNIT_ARCHAEOLOGIST",       -1,      -1),
                            ("Warrior_(Civ6).png",          100,    2,          "Воин",         3,  "UNIT_WARRIOR",             20,      -1),
                            ("Scout_(Civ6).png",            30,     3,          "Разведчик",    4,  "UNIT_SCOUT",               10,      -1),
                            ("Slinger_(Civ6).png",          35,     2,          "Пращик",       5,  "UNIT_SLINGER",              5,      15);
