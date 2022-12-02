INSERT INTO chat.users (login, password)
VALUES
('barsik','may'),
('shurup','vint'),
('melkaya','111'),
('troll','12345'),
('admin','admin');

INSERT INTO chat.chatrooms (chatroom_name, chatroom_owner)
VALUES
    ('general', (SELECT id FROM chat.users WHERE login = 'admin')),
    ('random', (SELECT id FROM chat.users WHERE login = 'admin')),
    ('mafia', (SELECT id FROM chat.users WHERE login = 'admin')),
    ('adm', (SELECT id FROM chat.users WHERE login = 'admin')),
    ('java piscine', (SELECT id FROM chat.users WHERE login = 'admin'));

INSERT INTO chat.messages (message_author, message_room, message_text, "message_date/time")
VALUES
    ((SELECT id FROM chat.users WHERE login = 'admin'), (SELECT id FROM chat.chatrooms WHERE chatroom_name = 'general'),         'Welkom to general channel!', (SELECT NOW()::timestamp)),
    ((SELECT id FROM chat.users WHERE login = 'admin'), (SELECT id FROM chat.chatrooms WHERE chatroom_name = 'random'),          'Welkom to random channel!', (SELECT NOW()::timestamp)),
    ((SELECT id FROM chat.users WHERE login = 'admin'), (SELECT id FROM chat.chatrooms WHERE chatroom_name = 'mafia'),           'Welkom to mafia channel!', (SELECT NOW()::timestamp)),
    ((SELECT id FROM chat.users WHERE login = 'admin'), (SELECT id FROM chat.chatrooms WHERE chatroom_name = 'adm'),             'Welkom to adm channel!', (SELECT NOW()::timestamp)),
    ((SELECT id FROM chat.users WHERE login = 'admin'), (SELECT id FROM chat.chatrooms WHERE chatroom_name = 'java piscine'),    'Welkom to java piscine channel!', (SELECT NOW()::timestamp));
