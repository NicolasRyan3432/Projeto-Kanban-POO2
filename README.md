# Projeto-Kanban-POO2

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

Projeto para conclusão da disciplina de POO2, um sistema de organização de tarefas do dia-a-dia utilizando a metodologia ágil Kanban como base.
Desenvolvido com foco em regras de negócio consistentes, segurança de dados e controle hierárquico de usuários.

---

## Funcionalidades Principais

- **Autenticação Segura &rarr;** Sistema de Login com verificação de usuários ativos e inativos.
- **Criptografia de Senhas &rarr;** Senhas blindadas no banco de dados utilizando algoritimos de Hashing (SHA-512).
- **Controle de Acesso (RBAC) &rarr;** Hierarquia rigorosa entre Administradores e Usuários comuns.
- **Sistema Anti-Bloqueio &rarr;** Travas de segurança que impedem que o único Adminstrador ativo do sistema a rebaixar suas permissões ou se desativar.
- **Gestão de Tarefas (CRUD) &rarr;** Criação, edição, remoção e transição de notas entre as colunas do Kanban.
- **Auditoria e Histórico &rarr;** Rastreamento completo de alterações nas notas usando *Stored Procedures* no MySQL.

---

## Tecnologias e Padrões Utilizados

- **Java 8+ e Mavem &rarr;** como linguagem principal e gerenciador de dependências;
- **Java Swing &rarr;** para a interface gráfica;
- **Banco de Dados &rarr;** MySQL (rodando localmente) usando *Stored Procedures* para transferir a responsabilidade e regras críticas para o SGBD;
- **Padrões de Projeto &rarr;** DAO (*Data Access Object*), MVC simplificado e *try-with-resources* para prevenção de vazamento de memória.

---

## Como o Kanban funciona 

O sistema é baseado na metodologia ágil Kanban, originada em 1947 nas fábricas da Toyota.
O método foi criado pelo engenheiro *Taiichi Ohno* como parte do Sistema Toyota de Produção (TPS).
É dividido em três colunas principais, sendo:
   
**A FAZER** &rarr; é destinado as atividades que SERÃO FEITAS.   
Todas as notas são criadas diretamente nessa coluna. 

**SENDO FEITO** &rarr; é destinado as atividades que ESTÃO SENDO REALIZADAS.   
Ao começar uma atividade, ela passa para essa coluna e fica até ser concluída.   
A nota pode ser modificada de acordo com a necessidade.   

**CONCLUÍDO** &rarr; é destinado as atividades que já FOREM CONCLUÍDAS.

---

## Como Executar o Projeto

Para mais informações detalhadas sobre como configurar o banco de dados local, 
criar a estrutura de tabelas e executar o programa na sua máquina, consulte o guia de instalação:

&rarr; **[Ver Guia de Configuração (Setup.md)](/config/Setup.md)**

---

## Autores

- **[Nícolas Ryan](https://github.com/NicolasRyan3432)** - *Desenvolvedor do Projeto*
- **[Lucas Dantas](https://github.com/IamDantasx)** - *Documentador do Trabalho*
- **[Felipe Sponchiado](https://github.com/Apocalipc)** - *Apresentador do Trabalho*

