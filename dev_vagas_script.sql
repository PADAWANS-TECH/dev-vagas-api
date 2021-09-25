CREATE TABLE ANALISTA (
  ID BIGINT NOT NULL,
  NOME VARCHAR(255) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  TELEFONE VARCHAR(11) NOT NULL,
  PRIMARY KEY (ID)
  );
  
CREATE TABLE SKILL(
	ID BIGINT NOT NULL,
    NOME VARCHAR(255) NOT NULL,
    COR VARCHAR(50) NOT NULL,
    NIVEL_CONHECIMENTO INT NOT NULL,
    DT_ATUALIZACAO DATETIME NULL,
    DT_CRIACAO DATETIME NULL,
    DT_EXCLUSAO DATETIME NULL,
    ID_ANALISTA_CRIACAO BIGINT NULL,
    ID_ANALISTA_EXCLUSAO BIGINT NULL,
    ID_ANALISTA_ATUALIZACAO BIGINT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT ID_ANALISTA_CRIACAO FOREIGN KEY (ID_ANALISTA_CRIACAO) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_EXCLUSAO FOREIGN KEY (ID_ANALISTA_EXCLUSAO) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_ATUALIZACAO FOREIGN KEY (ID_ANALISTA_ATUALIZACAO) REFERENCES ANALISTA(ID)
);

CREATE TABLE PAIS (
  ID BIGINT NOT NULL,
  NOME VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
  );

CREATE TABLE ESTADO (
  ID BIGINT NOT NULL,
  NOME VARCHAR(255) NOT NULL,
  SIGLA VARCHAR(2) NOT NULL,
  ID_PAIS BIGINT NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT ID_PAIS
    FOREIGN KEY (ID_PAIS)
    REFERENCES PAIS (ID)
);

CREATE TABLE CIDADE (
  ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NOME VARCHAR(255) NOT NULL,
  ID_ESTADO BIGINT,
  FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO(ID)
);

CREATE TABLE ENDERECO (
  ID BIGINT NOT NULL,
  LOGRADOURO VARCHAR(255) NOT NULL,
  BAIRRO VARCHAR(255) NOT NULL,
  NUMERO VARCHAR(8) NOT NULL,
  COMPLEMENTO VARCHAR(255) NULL,
  CEP VARCHAR(10) NOT NULL,
  ID_CIDADE BIGINT NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT ID_CIDADE
    FOREIGN KEY (ID_CIDADE)
    REFERENCES CIDADE (ID)
);

CREATE TABLE CANDIDATO(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	NOME VARCHAR(255) NOT NULL,
	TELEFONE VARCHAR(11) NOT NULL,
	DT_NASCIMENTO DATE NOT NULL,
	SEXO VARCHAR(50) NULL,
	NACIONALIDADE VARCHAR(30) NOT NULL,
	ESTADO_CIVIL VARCHAR(30) NOT NULL,
	RG VARCHAR(9) NOT NULL,
	CPF VARCHAR(11) NOT NULL,
	IMAGEM BLOB NULL,
	EMAIL VARCHAR(100) NOT NULL,
	TELEFONE_RECADO VARCHAR(11),
	PONTUACAO INT NULL,
	ID_ENDERECO BIGINT,
	DT_CRIACAO DATETIME NULL,
	DT_ATUALIZACAO DATETIME NULL,
	DT_EXCLUSAO DATETIME NULL,
	ID_USUARIO_CRIACAO BIGINT,
	ID_USUARIO_ATUALIZACAO BIGINT,
	ID_USUARIO_EXCLUSAO BIGINT,
	CONSTRAINT ID_ENDERECO
	FOREIGN KEY(ID_ENDERECO) REFERENCES ENDERECO(ID)
);

CREATE TABLE  (
ID BIGINT NOT NULL,
ID_CANDIDATO BIGINT NOT NULL,
ID_SKILL BIGINT NOT NULL,
PRIMARY KEY(ID), 
	  CONSTRAINT ID_CANDIDATO
		FOREIGN KEY (ID_CANDIDATO) REFERENCES CANDIDATO(ID),
	  CONSTRAINT ID_SKILL
		FOREIGN KEY (ID_SKILL) REFERENCES SKILL(ID)
);

CREATE TABLE EMPRESA (
  ID BIGINT NOT NULL,
  RAZAO_SOCIAL VARCHAR(255) NOT NULL,
  NOME_FANTASIA VARCHAR(255) NOT NULL,
  DESCRICAO VARCHAR(255) NOT NULL,
  CNPJ VARCHAR(20) NOT NULL,
  TELEFONE VARCHAR(11) NOT NULL,
  LOGOTIPO BLOB NULL,
  SITE VARCHAR(100) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  DT_ATUALIZACAO DATETIME NULL,
  DT_CRIACAO DATETIME NULL,
  DT_EXCLUSAO DATETIME NULL,
  ID_ENDERECO BIGINT,
  ID_ANALISTA_CRIACAO BIGINT,
  ID_ANALISTA_EXCLUSAO BIGINT,
  ID_ANALISTA_ATUALIZACAO BIGINT,
  PRIMARY KEY (ID),
  CONSTRAINT ID_ENDERECO_EMPRESA
  FOREIGN KEY (ID_ENDERECO) REFERENCES ENDERECO(ID),
  CONSTRAINT ID_ANALISTA_CRIACAO_EMPRESA
  FOREIGN KEY (ID_ANALISTA_CRIACAO) REFERENCES ANALISTA (ID),
  CONSTRAINT ID_ANALISTA_EXCLUSAO_EMPRESA
  FOREIGN KEY (ID_ANALISTA_EXCLUSAO) REFERENCES ANALISTA (ID),
  CONSTRAINT ID_ANALISTA_ATUALIZACAO_EMPRESA
  FOREIGN KEY (ID_ANALISTA_ATUALIZACAO) REFERENCES ANALISTA (ID)
  );

CREATE TABLE CARGO (
	ID BIGINT NOT NULL,
    NOME VARCHAR(255) NOT NULL,
    DT_CRIACAO DATETIME NULL,
    DT_EXCLUSAO DATETIME NULL,
    ID_EMPRESA BIGINT,
    ID_ANALISTA_CRIACAO BIGINT,
    ID_ANALISTA_EXCLUSAO BIGINT,
    ID_ANALISTA_ATUALIZACAO BIGINT,
    PRIMARY KEY (ID),
	CONSTRAINT ID_EMPRESA FOREIGN KEY (ID_EMPRESA) REFERENCES EMPRESA(ID),
    CONSTRAINT ID_ANALISTA_CRIACAO_CARGO FOREIGN KEY (ID_ANALISTA_CRIACAO) REFERENCES ANALISTA(ID) ,
    CONSTRAINT ID_ANALISTA_EXCLUSAO_CARGO FOREIGN KEY (ID_ANALISTA_EXCLUSAO) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_ATUALIZACAO_CARGO FOREIGN KEY (ID_ANALISTA_ATUALIZACAO) REFERENCES ANALISTA(ID)
);


CREATE TABLE ANALISTA_CARGO (
    ID BIGINT NOT NULL,
    ID_ANALISTA BIGINT NOT NULL,
    ID_CARGO BIGINT NOT NULL,
	PRIMARY KEY(ID), 
	CONSTRAINT ID_ANALISTA_CARGO FOREIGN KEY (ID_ANALISTA) REFERENCES ANALISTA(ID),
	CONSTRAINT ID_CARGO FOREIGN KEY (ID_CARGO) REFERENCES CARGO(ID)
);

CREATE TABLE ANALISTA_EMPRESA_CARGO (
  ID BIGINT NOT NULL,
  ID_ANALISTA BIGINT NOT NULL,
  ID_EMPRESA BIGINT NOT NULL,
  ID_CARGO BIGINT NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT ID_ANALISTA_EMPRESA_CARGO
  FOREIGN KEY (ID_ANALISTA) REFERENCES ANALISTA (ID),
  CONSTRAINT ID_EMPRESA_ANALISTA_CARGO
  FOREIGN KEY (ID_EMPRESA) REFERENCES EMPRESA (ID),
  CONSTRAINT ID_CARGO_EMPRESA_ANALISTA
  FOREIGN KEY (ID_CARGO) REFERENCES CARGO (ID)
  );


CREATE TABLE PROCESSO_SELETIVO (
    ID BIGINT NOT NULL,
    TITULO VARCHAR(255)  NOT NULL,
    DESCRICAO VARCHAR(255)  NOT NULL,
    QUANTIDADE_VAGAS INT NOT NULL,
    DT_INICIO DATE NOT NULL,
    DT_TERMINO DATE NOT NULL,
    DT_ATUALIZACAO DATETIME NULL,
    DT_CRIACAO DATETIME NULL,
    DT_EXCLUSAO DATETIME NULL,
    ID_ANALISTA_CRIACAO BIGINT NULL,
    ID_ANALISTA_EXCLUSAO BIGINT NULL,
    ID_ANALISTA_ATUALIZACAO BIGINT NULL,
	ID_EMPRESA BIGINT NOT NULL,
    ID_CARGO BIGINT NOT NULL,
    ID_ANALISTA BIGINT NOT NULL,
    PRIMARY KEY(ID),
    CONSTRAINT ID_PROCESSO_SELETIVO_EMPRESA
    FOREIGN KEY (ID_EMPRESA) REFERENCES EMPRESA(ID),
    CONSTRAINT ID_PROCESSO_SELETIVO_CARGO
    FOREIGN KEY (ID_CARGO) REFERENCES CARGO(ID),
    CONSTRAINT ID_ANALISTA_PROCESSO_SELETIVO
    FOREIGN KEY (ID_ANALISTA) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_PROCESSO_SELETIVO_CRIACAO
    FOREIGN KEY (ID_ANALISTA_CRIACAO) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_PROCESSO_SELETIVO_EXCLUSAO
    FOREIGN KEY (ID_ANALISTA_EXCLUSAO) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_PROCESSO_SELETIVO_ATUALIZACAO
    FOREIGN KEY (ID_ANALISTA_ATUALIZACAO) REFERENCES ANALISTA(ID)
  );

CREATE TABLE RESPOSTA (
  ID BIGINT NOT NULL,
  TITULO VARCHAR(255) NOT NULL,
  DT_ATUALIZACAO DATETIME NOT NULL,
  DT_CRIACAO DATETIME NOT NULL,
  DT_EXCLUSAO DATETIME NOT NULL,
  ID_ANALISTA_CRIACAO BIGINT,
  ID_ANALISTA_EXCLUSAO BIGINT,
  ID_ANALISTA_ATUALIZACAO BIGINT,
  PRIMARY KEY (ID),
  CONSTRAINT ID_ANALISTA_CRIACAO_RESPOSTA
  FOREIGN KEY (ID_ANALISTA_CRIACAO) REFERENCES ANALISTA (ID),
  CONSTRAINT ID_ANALISTA_EXCLUSAO_RESPOSTA
  FOREIGN KEY (ID_ANALISTA_EXCLUSAO) REFERENCES ANALISTA (ID),
  CONSTRAINT ID_ANALISTA_ATUALIZACAO_RESPOSTA
  FOREIGN KEY (ID_ANALISTA_ATUALIZACAO) REFERENCES ANALISTA (ID)
  );
  

  CREATE TABLE ETAPA (
	ID BIGINT NOT NULL,
    NOME VARCHAR(100) NOT NULL,
    DESCRICAO VARCHAR(255) NOT NULL,
    QUANTIDADE_CANDIDATOS INT NOT NULL,
    DT_INICIO DATETIME NOT NULL,
    DT_FIM DATETIME NOT NULL,
    APROVADOS INT NULL,
    REPROVADOS INT NULL,
    DT_ATUALIZACAO DATETIME NULL,
    DT_CRIACAO DATETIME NULL,
    DT_EXCLUSAO DATETIME NULL,
    ID_ANALISTA_CRIACAO BIGINT,
    ID_ANALISTA_EXCLUSAO BIGINT,
    ID_ANALISTA_ATUALIZACAO BIGINT,
    PRIMARY KEY (ID),
    CONSTRAINT ID_ANALISTA_CRIACAO_ETAPA FOREIGN KEY (ID_ANALISTA_CRIACAO) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_EXCLUSAO_ETAPA FOREIGN KEY (ID_ANALISTA_EXCLUSAO) REFERENCES ANALISTA(ID),
    CONSTRAINT ID_ANALISTA_ATUALIZACAO_ETAPA FOREIGN KEY (ID_ANALISTA_ATUALIZACAO) REFERENCES ANALISTA(ID)
);

CREATE TABLE PROCESSO_SELETIVO_ETAPA (
ID BIGINT NOT NULL,
ID_PROCESSO_SELETIVO BIGINT NOT NULL, 
ID_ETAPA BIGINT NOT NULL,
PRIMARY KEY(ID),
	CONSTRAINT ID_PROCESSO_SELETIVO_ETAPA
		FOREIGN KEY (ID_PROCESSO_SELETIVO) REFERENCES PROCESSO_SELETIVO(ID),
	CONSTRAINT ID_ETAPA_PROCESSO_SELETIVO
		FOREIGN KEY (ID_ETAPA) REFERENCES ETAPA(ID)
);

CREATE TABLE PROCESSO_SELETIVO_SKILL(
	ID BIGINT NOT NULL,
    ID_PROCESSO_SELETIVO BIGINT NOT NULL,
    ID_SKILL BIGINT NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT ID_PROCESSO_SELETIVO_SKILL FOREIGN KEY (ID_PROCESSO_SELETIVO) REFERENCES PROCESSO_SELETIVO(ID),
    CONSTRAINT ID_SKILL_PROCESSO_SELETIVO FOREIGN KEY (ID_SKILL) REFERENCES SKILL(ID)
);

  CREATE TABLE TIPO_QUESTIONARIO(
  ID INT NOT NULL,
  TITULO VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
  );
  
CREATE TABLE QUESTIONARIO(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	TITULO VARCHAR(255) NOT NULL,
	DESCRICAO VARCHAR(255) NULL,
	PESO INT NOT NULL,
	NIVEL VARCHAR(10) NOT NULL,
	DT_ATUALIZACAO DATETIME NULL,
	DT_CRIACAO DATETIME NULL,
	DT_EXCLUSAO DATETIME NULL,
	ID_ETAPA BIGINT NOT NULL,
	ID_TIPO_QUESTIONARIO INT NOT NULL,
	ID_ANALISTA_CRIACAO BIGINT NOT NULL,
	ID_ANALISTA_EXCLUSAO BIGINT NOT NULL,
	ID_ANALISTA_ATUALIZACAO BIGINT NOT NULL,
	CONSTRAINT ID_ETAPA_QUESTIONARIO
	FOREIGN KEY(ID_ETAPA) REFERENCES ETAPA(ID),
	CONSTRAINT ID_TIPO_QUESTIONARIO
	FOREIGN KEY(ID_TIPO_QUESTIONARIO) REFERENCES TIPO_QUESTIONARIO(ID),
	CONSTRAINT ID_ANALISTA_CRIACAO_QUESTIONARIO
	FOREIGN KEY(ID_ANALISTA_CRIACAO) REFERENCES ANALISTA(ID),
	CONSTRAINT ID_ANALISTA_EXCLUSAO_QUESTIONARIO
	FOREIGN KEY(ID_ANALISTA_EXCLUSAO) REFERENCES ANALISTA(ID),
	CONSTRAINT ID_ANALISTA_ATUALIZACAO_QUESTIONARIO
	FOREIGN KEY(ID_ANALISTA_ATUALIZACAO) REFERENCES ANALISTA(ID)
    );


CREATE TABLE TIPO_PERGUNTA (
  ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  TITULO VARCHAR(255) NOT NULL
  );


CREATE TABLE PERGUNTA (
  ID BIGINT NOT NULL,
  TITULO VARCHAR(255) NOT NULL,
  PESO INT NOT NULL,
  NIVEL VARCHAR(10) NOT NULL,
  DT_ATUALIZACAO DATETIME NULL,
  DT_CRIACAO DATETIME NULL,
  DT_EXCLUSAO DATETIME NULL,
  ID_ANALISTA_CRIACAO BIGINT,
  ID_ANALISTA_EXCLUSAO BIGINT,
  ID_ANALISTA_ATUALIZACAO BIGINT,
  ID_TIPO_PERGUNTA BIGINT NOT NULL,
  ID_QUESTIONARIO BIGINT NOT NULL,
  ID_RESPOSTA BIGINT NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT ID_TIPO_PERGUNTA
    FOREIGN KEY (ID_TIPO_PERGUNTA)
    REFERENCES TIPO_PERGUNTA (ID),
  CONSTRAINT ID_QUESTIONARIO_PERGUNTA
    FOREIGN KEY (ID_QUESTIONARIO)
    REFERENCES QUESTIONARIO (ID),
  CONSTRAINT ID_RESPOSTA_PERGUNTA
    FOREIGN KEY (ID_RESPOSTA)
    REFERENCES RESPOSTA (ID),
  CONSTRAINT ID_ANALISTA_CRIACAO_PERGUNTA
    FOREIGN KEY (ID_ANALISTA_CRIACAO)
    REFERENCES ANALISTA (ID),
  CONSTRAINT ID_ANALISTA_EXCLUSAO_PERGUNTA
    FOREIGN KEY (ID_ANALISTA_EXCLUSAO)
    REFERENCES ANALISTA (ID),
  CONSTRAINT ID_ANALISTA_ATUALIZACAO_PERGUNTA
    FOREIGN KEY (ID_ANALISTA_ATUALIZACAO)
    REFERENCES ANALISTA (ID)
  );