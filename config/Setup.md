# Configuração do ambiente

1º Passo &rarr; Execute o script "Kanban.sql" no seu Database Manager de preferência para criar as tabelas e Procedures usado no projeto

2º Passo  &rarr; Renomeie o arquivo "config.properties.example.txt" para "config.properties", nesse arquivo você deverá inserir as credenciais de login (usuário e senha) para o acesso ao MySQL.

3º Passo &rarr; Mova o arquivo "config.properties" para src/main/resources.

4º Passo &rarr; Abra o projeto na sua IDE de preferência e rode o programa através do botão Executar. O sistema lerá suas configurações automaticamente (Observação: se for testar rodando diretamente o arquivo executável .jar, lembre-se de realizar um "Clean and Build" no Mavem antes para que sua senha seja embutida na build).

5º Passo &rarr; Como o banco de banco de dados está limpo, ao iniciar o sistema, ele detectará a ausência de usuários e criará um Administrador Padrão automaticamente. Utilize as seguintes credenciais para acessar:
- Usuário: Admin
- Senha: admin123

6º Passo &rarr; Use o programa à vontade!

