delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from usuario_grupo;
delete from oauth_client_details;

insert into permissao (id, nome, descricao) values (1, 'EDITAR', 'Permite editar e criar dados.');
insert into permissao (id, nome, descricao) values (2, 'CONSULTAR', 'Permite consultar dados.');

insert into grupo (id, nome) values (1, 'Adminsitrador'), (2, 'funcionario');

insert into grupo_permissao (grupo_id, permissao_id)
select 1, id from permissao;

insert into grupo_permissao (grupo_id, permissao_id)
select 2, id from permissao where nome like 'CONSULTAR%';


insert into usuario (id, nome, email, senha) values
(1, 'fabricio gestor', 'fabricio.admin@outlook.com.br', '$2y$12$YMjmzVvIwaHsq3V2Xyl/6egjIInf86GFBqGcJjgYv3TYbsRMYNe2W'),
(2, 'Maria funcionario', 'maria.funcionario@outlook.com.br', '$2y$12$YMjmzVvIwaHsq3V2Xyl/6egjIInf86GFBqGcJjgYv3TYbsRMYNe2W'),
(3, 'José funcionario', 'jose.funcionario@outlook.com.br', '$2y$12$YMjmzVvIwaHsq3V2Xyl/6egjIInf86GFBqGcJjgYv3TYbsRMYNe2W');

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 2), (3, 2);

insert into pessoa(id, nome) values(1, 'Fabricio');
insert into pessoa(id, nome) values(2, 'Debora');
insert into pessoa(id, nome) values(3, 'Renata');


insert into oauth_client_details (
  client_id, resource_ids, client_secret,
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'mobile', null, '$2y$12$YMjmzVvIwaHsq3V2Xyl/6egjIInf86GFBqGcJjgYv3TYbsRMYNe2W',
  'READ,WRITE', 'password,refresh_token', null, null,
  60 * 60 * 6, 60 * 24 * 60 * 60, null
);


insert into oauth_client_details (
  client_id, resource_ids, client_secret,
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'appweb', null, '$2y$12$YMjmzVvIwaHsq3V2Xyl/6egjIInf86GFBqGcJjgYv3TYbsRMYNe2W',
  'READ,WRITE', 'authorization_code,refresh_token', 'http://localhost:8080', null,
  null, null, null
);