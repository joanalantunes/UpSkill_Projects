
INSERT INTO roles(name) VALUES ('Utente');
INSERT INTO roles (name) VALUES('Médico');
INSERT INTO roles (name) VALUES('Responsável de Unidade');
INSERT INTO roles (name) VALUES('Funcionário');

INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('Joao', 'alberto_costa@gmail.com', 'teste5', '126', '1', '2');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('Alberto', 'alberto_costa@gmail.com', 'teste6', '124', '1', '1');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('Bernardo', 'alberto_costa@gmail.com', 'teste7', '546', '1', '2');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('Patricia', 'alberto_costa@gmail.com', 'teste8', '785', '1', '1');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('Ana', 'alberto_costa@gmail.com', 'teste9', '1232', '1', '2');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('Rita', 'alberto_costa@gmail.com', 'teste10', '178', '1', '2');

INSERT INTO medico(numero_cedula, user_id) VALUES ('453365','1');
INSERT INTO medico(numero_cedula, user_id) VALUES ('542369','2');
INSERT INTO medico(numero_cedula, user_id) VALUES ('465148','3');
INSERT INTO medico(numero_cedula, user_id) VALUES ('164751','4');

INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('alberto', 'alberto_costa@gmail.com', 'teste1', '1234', '1', '1');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('felisberto', 'feliz@gmail.com', 'teste2', '1234', '1', '2');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('samara', 'samara@gmail.com', 'teste3', '1234', '1', '3');
INSERT INTO users(nome, email, username, password, enabled, role_id) VALUES ('madalena', 'madalena@gmail.com', 'teste4', '1234', '1', '4');

INSERT INTO especialidade(Nome_Especialidade) VALUES ('Geral');
INSERT INTO especialidade(Nome_Especialidade) VALUES ('Pediatria');
INSERT INTO especialidade(Nome_Especialidade) VALUES ('Ortorrino');
INSERT INTO especialidade(Nome_Especialidade) VALUES ('Cardiologia');


INSERT INTO medico_especialidade(medico_id, especialidade_id) VALUES ('3', '3');
INSERT INTO medico_especialidade(medico_id, especialidade_id) VALUES ('1', '4');
INSERT INTO medico_especialidade(medico_id, especialidade_id) VALUES ('4', '4');


