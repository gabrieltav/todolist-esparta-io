INSERT INTO aluno (nome) VALUES ('Dennis Cesário Gadelha');
INSERT INTO aluno (nome) VALUES ('Mariano Vaz Andrade');
INSERT INTO aluno (nome) VALUES ('Mia Marinho Franco');
INSERT INTO aluno (nome) VALUES ('Willian Espinosa Rabelo');
INSERT INTO aluno (nome) VALUES ('Vladimir Couceiro Melgaço');
INSERT INTO aluno (nome) VALUES ('Aryan Esparteiro Cavalheiro');
INSERT INTO aluno (nome) VALUES ('Dina Basílio Madeira');
INSERT INTO aluno (nome) VALUES ('Ana Valverde Lessa');
INSERT INTO aluno (nome) VALUES ('Elizabeth Mata Oliveira');
INSERT INTO aluno (nome) VALUES ('Alexa Lacerda Souto');

INSERT INTO professor (nome) VALUES ('Joao Pedro');
INSERT INTO professor (nome) VALUES ('Kelton Boto Lago');
INSERT INTO professor (nome) VALUES ('Dominic Bulhões Barreno');
INSERT INTO professor (nome) VALUES ('Amélie Rosa Teves');
INSERT INTO professor (nome) VALUES ('Edir Rei Pinto');

INSERT INTO disciplina (nome) VALUES ('Matematica');
INSERT INTO disciplina (nome) VALUES ('Fisica');
INSERT INTO disciplina (nome) VALUES ('Quimica');
INSERT INTO disciplina (nome) VALUES ('Biologia');
INSERT INTO disciplina (nome) VALUES ('Portugues');
INSERT INTO disciplina (nome) VALUES ('Educacao fisica');
INSERT INTO disciplina (nome) VALUES ('Banco de Dados');

INSERT INTO turma (dia_da_semana, horario, PROFESSOR_id, DISCIPLINA_id, ALUNO_id) VALUES ('Segunda-feira','07:00|08:00',1,1,1);
INSERT INTO turma (dia_da_semana, horario, PROFESSOR_id, DISCIPLINA_id, ALUNO_id) VALUES ('Terça-feira','08:00|09:00',2,2,2);
INSERT INTO turma (dia_da_semana, horario, PROFESSOR_id, DISCIPLINA_id, ALUNO_id) VALUES ('Terca-feira','07:00|08:00',1,1,1);
INSERT INTO turma (dia_da_semana, horario, PROFESSOR_id, DISCIPLINA_id, ALUNO_id) VALUES ('Quarta-feira','09:00|10:00',3,3,3);
INSERT INTO turma (dia_da_semana, horario, PROFESSOR_id, DISCIPLINA_id, ALUNO_id) VALUES ('Quarta-feira','07:00|08:00',1,1,1);
INSERT INTO turma (dia_da_semana, horario, PROFESSOR_id, DISCIPLINA_id, ALUNO_id) VALUES ('Quinta-feira','10:00|11:00',4,4.4);
INSERT INTO turma (dia_da_semana, horario, PROFESSOR_id, DISCIPLINA_id, ALUNO_id) VALUES ('Sexta-feira','11:00|12:00',5,5,5);

INSERT INTO aluno_turma (ALUNO_id, TURMA_id) VALUES (1,1);
INSERT INTO aluno_turma (ALUNO_id, TURMA_id) VALUES (2,1);
INSERT INTO aluno_turma (ALUNO_id, TURMA_id) VALUES (3,1);
INSERT INTO aluno_turma (ALUNO_id, TURMA_id) VALUES (4,1);
INSERT INTO aluno_turma (ALUNO_id, TURMA_id) VALUES (1,2);
INSERT INTO aluno_turma (ALUNO_id, TURMA_id) VALUES (2,2);
INSERT INTO aluno_turma (ALUNO_id, TURMA_id) VALUES (3,3);



--Buscar os nomes de todos os alunos que frequentam alguma turma do professor 'JOAO PEDRO'.
SELECT turma.PROFESSOR_id
FROM turma
INNER JOIN aluno_turma on turma.id = aluno_turma.TURMA_id
inner JOIN professor on turma.PROFESSOR_id = professor.id
where professor.nome = 'Joao Pedro'

-- Buscar os dias da semana que tenham aulas da disciplina 'MATEMATICA'.
SELECT turma.dia_da_semana
FROM turma
INNER JOIN disciplina on turma.disciplina_id = disciplina.id
where disciplina.nome = 'matematica'

-- Buscar todos os alunos que frequentem aulas de 'MATEMATICA' e também 'FISICA'.
SELECT *
FROM turma
INNER JOIN disciplina on turma.disciplina_id = disciplina.id
where disciplina.nome = 'fisica' and 'matematica'

-- Buscar as disciplinas que não tenham nenhuma turma.
SELECT *
FROM turma
INNER JOIN disciplina on turma.disciplina_id != disciplina.id
where disciplina.nome != turma.disciplina_id