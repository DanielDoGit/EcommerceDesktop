CREATE TABLE formaDePagamento (
  id INTEGER   NOT NULL ,
  descricao VARCHAR(45)    ,
  lancamentoCaixa CHAR(1)      ,
PRIMARY KEY(id));



CREATE TABLE versaoBanco (
  id INTEGER   NOT NULL ,
  numeroVersao INTEGER    ,
  autenticacao CHAR(1)      ,
PRIMARY KEY(id));



CREATE TABLE permissao (
  id INTEGER   NOT NULL ,
  descricao VARCHAR(60)      ,
PRIMARY KEY(id)  );


CREATE UNIQUE INDEX permissao_descricao_un ON permissao (descricao);



CREATE TABLE cidade (
  id INTEGER   NOT NULL ,
  nome VARCHAR(45)    ,
  uf VARCHAR(2)      ,
PRIMARY KEY(id)  );


CREATE UNIQUE INDEX cidade_nome_un ON cidade (nome);



CREATE TABLE funcionario (
  id INTEGER   NOT NULL ,
  cidade_id INTEGER   NOT NULL ,
  nome VARCHAR(255)    ,
  cpf VARCHAR(11)    ,
  login VARCHAR(50)    ,
  senha VARCHAR(50)    ,
  celular VARCHAR(12)    ,
  telefone VARCHAR(12)    ,
  rua VARCHAR(45)    ,
  numerorua VARCHAR(4)      ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(cidade_id)
    REFERENCES cidade(id));


CREATE INDEX Funcionario_cidade_FK ON funcionario (cidade_id);
CREATE UNIQUE INDEX Funcionario_un ON funcionario (cpf, login, senha);

CREATE INDEX IFK_Rel_04 ON funcionario (cidade_id);


CREATE TABLE estabelecimento (
  id INTEGER   NOT NULL ,
  cidade_id INTEGER   NOT NULL ,
  nomefantasia VARCHAR(60)    ,
  apelidoRazao VARCHAR(60)    ,
  telefone VARCHAR(12)    ,
  celular VARCHAR(12)    ,
  rua VARCHAR(45)    ,
  numeroRua VARCHAR(4)      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(cidade_id)
    REFERENCES cidade(id));


CREATE INDEX estabelecimento_FKIndex1 ON estabelecimento (cidade_id);

CREATE INDEX IFK_Rel_18 ON estabelecimento (cidade_id);


CREATE TABLE cliente (
  id INTEGER   NOT NULL ,
  cidade_id INTEGER   NOT NULL ,
  nome VARCHAR(255)    ,
  celular VARCHAR(12)    ,
  telefone VARCHAR(12)    ,
  cpfcnpj VARCHAR(14)    ,
  rua VARCHAR(100)    ,
  numerodarua VARCHAR(4)      ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(cidade_id)
    REFERENCES cidade(id));


CREATE UNIQUE INDEX cliente_un ON cliente (cpfcnpj);
CREATE INDEX cliente_cidade_FK ON cliente (cidade_id);

CREATE INDEX IFK_Rel_03 ON cliente (cidade_id);


CREATE TABLE fornecedor (
  id INTEGER   NOT NULL ,
  cidade_id INTEGER   NOT NULL ,
  nome VARCHAR(255)    ,
  celular VARCHAR(12)    ,
  telefone VARCHAR(12)    ,
  cpfCnpj VARCHAR(14)    ,
  rua VARCHAR(45)    ,
  numeroRua VARCHAR(4)      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(cidade_id)
    REFERENCES cidade(id));


CREATE INDEX Fornecedor_FKIndex1 ON fornecedor (cidade_id);

CREATE INDEX IFK_Rel_08 ON fornecedor (cidade_id);


CREATE TABLE venda (
  id INTEGER   NOT NULL ,
  funcionario_id INTEGER   NOT NULL ,
  cliente_id INTEGER   NOT NULL ,
  valorDesconto NUMERIC(5,3)    ,
  valorTotal NUMERIC(5,3)    ,
  valorAcrescimo NUMERIC(5,3)      ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(cliente_id)
    REFERENCES cliente(id),
  FOREIGN KEY(funcionario_id)
    REFERENCES funcionario(id));


CREATE INDEX Venda_FKIndex1 ON venda (cliente_id);
CREATE INDEX Venda_FKIndex2 ON venda (funcionario_id);

CREATE INDEX IFK_Rel_05 ON venda (cliente_id);
CREATE INDEX IFK_Rel_06 ON venda (funcionario_id);


CREATE TABLE permissaofuncionario (
  id INTEGER   NOT NULL ,
  permissao_id INTEGER   NOT NULL ,
  funcionario_id INTEGER   NOT NULL   ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(funcionario_id)
    REFERENCES funcionario(id),
  FOREIGN KEY(permissao_id)
    REFERENCES permissao(id));


CREATE INDEX permissaofuncionario_FKIndex1 ON permissaofuncionario (funcionario_id);
CREATE INDEX permissaofuncionario_FKIndex2 ON permissaofuncionario (permissao_id);

CREATE INDEX IFK_Rel_16 ON permissaofuncionario (funcionario_id);
CREATE INDEX IFK_Rel_17 ON permissaofuncionario (permissao_id);


CREATE TABLE recebimento (
  id INTEGER   NOT NULL ,
  cliente_id INTEGER   NOT NULL ,
  formaDePagamento_id INTEGER   NOT NULL ,
  venda_id INTEGER   NOT NULL ,
  valor NUMERIC(5,3)    ,
  dataRecebimento DATE      ,
PRIMARY KEY(id)      ,
  FOREIGN KEY(venda_id)
    REFERENCES venda(id),
  FOREIGN KEY(formaDePagamento_id)
    REFERENCES formaDePagamento(id),
  FOREIGN KEY(cliente_id)
    REFERENCES cliente(id));


CREATE INDEX recebimento_venda_FK ON recebimento (venda_id);
CREATE INDEX recebimento_formapagamento_FKIndex2 ON recebimento (formaDePagamento_id);
CREATE INDEX recebimento_cliente_FK ON recebimento (cliente_id);

CREATE INDEX IFK_Rel_11 ON recebimento (venda_id);
CREATE INDEX IFK_Rel_12 ON recebimento (formaDePagamento_id);
CREATE INDEX IFK_Rel_13 ON recebimento (cliente_id);


CREATE TABLE produto (
  id INTEGER   NOT NULL ,
  fornecedor_id INTEGER   NOT NULL ,
  descricao VARCHAR(50)    ,
  precocusto NUMERIC(5,3)    ,
  precovenda NUMERIC(5,3)    ,
  estoque NUMERIC(5,3)    ,
  estoquenegativo CHAR(1)      ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(fornecedor_id)
    REFERENCES fornecedor(id));


CREATE INDEX produto_FKIndex1 ON produto (fornecedor_id);
CREATE UNIQUE INDEX produto_descricao_un ON produto (descricao);

CREATE INDEX IFK_Rel_09 ON produto (fornecedor_id);


CREATE TABLE Parcela (
  id INTEGER   NOT NULL ,
  formaDePagamento_id INTEGER   NOT NULL ,
  recebimento_id INTEGER   NOT NULL ,
  valor NUMERIC(5,3)    ,
  datalancamento DATE    ,
  datarecebimento DATE    ,
  descricao VARCHAR(45)    ,
  compensado CHAR(1)      ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(recebimento_id)
    REFERENCES recebimento(id),
  FOREIGN KEY(formaDePagamento_id)
    REFERENCES formaDePagamento(id));


CREATE INDEX Parcela_FKIndex1 ON Parcela (recebimento_id);
CREATE INDEX Parcela_FKIndex2 ON Parcela (formaDePagamento_id);

CREATE INDEX IFK_Rel_14 ON Parcela (recebimento_id);
CREATE INDEX IFK_Rel_15 ON Parcela (formaDePagamento_id);


CREATE TABLE ItemVenda (
  id INTEGER   NOT NULL ,
  produto_id INTEGER   NOT NULL ,
  venda_id INTEGER   NOT NULL ,
  totalUnitario NUMERIC(5,3)    ,
  quantidade NUMERIC(5,3)    ,
  precounitario NUMERIC(5,3)      ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(venda_id)
    REFERENCES venda(id),
  FOREIGN KEY(produto_id)
    REFERENCES produto(id));


CREATE INDEX ItemVenda_FKIndex1 ON ItemVenda (venda_id);
CREATE INDEX ItemVenda_FKIndex2 ON ItemVenda (produto_id);

CREATE INDEX IFK_Rel_07 ON ItemVenda (venda_id);
CREATE INDEX IFK_Rel_10 ON ItemVenda (produto_id);



