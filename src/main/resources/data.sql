INSERT INTO tb_record (id, type, username) VALUES 
(1, 'TP1', 'supervisor1'),
(2, 'TP2', 'supervisor1'),
(3, 'TP2', 'supervisor1'),
(4, 'TP1', 'examinator1'),
(5, 'TP3', 'examinator1');

INSERT INTO tb_document (id, name , location, record_id) VALUES 
(1, 'example1.txt', '/temp/document', 1),
(2, 'example2.txt', '/temp/document', 1),
(3, 'example3.txt', '/temp/document', 2),
(4, 'example4.txt', '/temp/document', 3),
(5, 'example5.txt', '/temp/document', 4),
(6, 'example6.txt', '/temp/document', 5),
(7, 'example7.txt', '/temp/document', 4),
(8, 'example8.txt', '/temp/document', 5);