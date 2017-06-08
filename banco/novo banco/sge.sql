-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 08-Jun-2017 às 03:54
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sge`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `codAdministrador` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`codAdministrador`, `nome`, `dataNascimento`, `email`, `senha`) VALUES
(1, 'Luiz Filipysasas', '01011997', 'lipe@lipe', '123'),
(2, 'Leonardo', '12111995', 'leo@leo', '1234'),
(3, 'Matheus', '01041997', 'matsouzaleao@gmail.com', '012345'),
(4, 'Stela', '12012009', 'stela@stelaxxxxx', '1234567');

-- --------------------------------------------------------

--
-- Estrutura da tabela `album`
--

CREATE TABLE `album` (
  `idAlbum` int(11) NOT NULL,
  `desricao` varchar(45) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `Galeria_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `idAluno` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`idAluno`, `nome`, `email`, `dataNascimento`, `senha`) VALUES
(1, '1sadasd', '1', '1', '1'),
(3, 'RAmones', 'ramon@ramon', '19122011', '123'),
(55, 'sdddddddd', 'dssssss', 'dsssssss', 'dsssssss'),
(76, 'mak', 'ksksk', '18828282993012', 'aks'),
(150, 'Nicolal', 'nick@nick', 'maquiavel69', '02141996'),
(160, 'Henry', 'henry@henry', '321', '22111900');

-- --------------------------------------------------------

--
-- Estrutura da tabela `certificado`
--

CREATE TABLE `certificado` (
  `codAutencidade` varchar(30) NOT NULL,
  `descricao` varchar(60) DEFAULT NULL,
  `Inscricao_codInscricao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL,
  `nomeEvento` varchar(45) DEFAULT NULL,
  `duracao` varchar(10) DEFAULT NULL,
  `tema` varchar(50) DEFAULT NULL,
  `dataInicioEvento` varchar(45) DEFAULT NULL,
  `dataFimEvento` varchar(45) DEFAULT NULL,
  `dataInicioInscricao` varchar(45) DEFAULT NULL,
  `dataFimInscricao` varchar(45) DEFAULT NULL,
  `Administrador_codAdministrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `evento`
--

INSERT INTO `evento` (`idEvento`, `nomeEvento`, `duracao`, `tema`, `dataInicioEvento`, `dataFimEvento`, `dataInicioInscricao`, `dataFimInscricao`, `Administrador_codAdministrador`) VALUES
(1, 'Semana Do Tecnico', '7 dias', 'Informatica e Sociedade', '27092016', '04102016', '20092016', '27092016', 1),
(2, 'SECITEC', '1 semana', 'Informatica e Sociedade', '19112016', '19112016', '29112016', '29112016', 1),
(3, '4', '4', '4', '4', '4', '4', '4', 4),
(57665, '6asdasddsadas', '6', '6', '66', '6', '6', '6', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `externo`
--

CREATE TABLE `externo` (
  `idExterno` int(11) NOT NULL,
  `conhecimento` varchar(30) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `externo`
--

INSERT INTO `externo` (`idExterno`, `conhecimento`, `nome`, `email`, `dataNascimento`, `senha`) VALUES
(1, 'Nenhum', 'Ramon', 'ramon@ramon', '22081994', '123'),
(2, 'Radio', 'Lucas ChorÃ£o', 'lucas@lucas', '10101910', '1234'),
(3, '4', '4', '4', '4', '4'),
(5, 'Radio', 'Matheus', 'mat@mat', '123', '231201'),
(7, 'radio', 'Nick', 'nick@nick', 'nasceu', '123'),
(8787, 'f', 'f', 'f', 'f', 'f');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fotos`
--

CREATE TABLE `fotos` (
  `idFoto` int(11) NOT NULL,
  `Album_id` int(11) NOT NULL,
  `arquivo` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `galeria`
--

CREATE TABLE `galeria` (
  `idGaleria` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `Evento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gerente`
--

CREATE TABLE `gerente` (
  `codGerente` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `gerente`
--

INSERT INTO `gerente` (`codGerente`, `nome`, `email`, `dataNascimento`, `senha`) VALUES
(1, 'Leoginsk', 'leo@leo', '11091996', '123'),
(2, 'Pedro Petigrou', 'pedro@pedro', '12071995', '4321'),
(3, 'Math', 'k', 'mkmk', 'asasas'),
(11231, 'p', 'p', 'p', 'p');

-- --------------------------------------------------------

--
-- Estrutura da tabela `inscricao`
--

CREATE TABLE `inscricao` (
  `codInscricao` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `frequencia` tinyint(1) DEFAULT NULL,
  `Proposta_id` int(11) NOT NULL,
  `Externo_id` int(11) NOT NULL,
  `Aluno_matricula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `local`
--

CREATE TABLE `local` (
  `idLocal` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `capacidade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `local`
--

INSERT INTO `local` (`idLocal`, `descricao`, `capacidade`) VALUES
(1, 'Auditório', 50),
(2, 'Auditorio do Bloco A', 300),
(11112, 'asdsdasdadsa', 5555),
(12312, 'p', 800);

-- --------------------------------------------------------

--
-- Estrutura da tabela `noticia`
--

CREATE TABLE `noticia` (
  `idNoticia` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `descricao` varchar(60) DEFAULT NULL,
  `Evento_idEvento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `noticia`
--

INSERT INTO `noticia` (`idNoticia`, `data`, `descricao`, `Evento_idEvento`) VALUES
(1, '27092016', 'Uma descricao qualquer', 1),
(2, '29092016', 'Procura-se Lipy', 2),
(3, '3', '3', 1),
(4545, 'etes', 'teste', 1),
(12321, 'p', 'passss', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `proposta`
--

CREATE TABLE `proposta` (
  `idProposta` int(11) NOT NULL,
  `proponente` varchar(45) DEFAULT NULL,
  `emailProponente` varchar(45) DEFAULT NULL,
  `tipoAtividade` varchar(45) DEFAULT NULL,
  `tituloAtividade` varchar(45) DEFAULT NULL,
  `finalidadeAtividade` varchar(100) DEFAULT NULL,
  `cargaHoraria` varchar(45) DEFAULT NULL,
  `vagasAtividade` int(11) DEFAULT NULL,
  `nomeConvidado` varchar(45) DEFAULT NULL,
  `emailConvidado` varchar(45) DEFAULT NULL,
  `formacaoConvidado` varchar(45) DEFAULT NULL,
  `origem` varchar(45) DEFAULT NULL,
  `informacoesComplementares` varchar(100) DEFAULT NULL,
  `diaria` int(5) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `publico_alvo` varchar(20) NOT NULL,
  `publico_todos` int(11) DEFAULT NULL,
  `publico_informatica` int(11) DEFAULT NULL,
  `publico_edificacoes` int(11) DEFAULT NULL,
  `publico_eletromecanica` int(11) DEFAULT NULL,
  `publico_eletrotecnica` int(11) DEFAULT NULL,
  `publico_mecanica` int(11) DEFAULT NULL,
  `publico_metalurgia` int(11) DEFAULT NULL,
  `publico_eventos` int(11) DEFAULT NULL,
  `publico_secretariado` int(11) DEFAULT NULL,
  `publico_designMoveis` int(11) DEFAULT NULL,
  `publico_eletronica` int(11) DEFAULT NULL,
  `publico_transacoesImobiliarias` int(11) DEFAULT NULL,
  `publico_transporteFerroviario` int(11) DEFAULT NULL,
  `publico_sistemasInformacao` int(11) DEFAULT NULL,
  `publico_engMecatronica` int(11) DEFAULT NULL,
  `publico_engMetalurgica` int(11) DEFAULT NULL,
  `publico_fisica` int(11) DEFAULT NULL,
  `segunda` int(11) DEFAULT NULL,
  `terca` int(11) DEFAULT NULL,
  `quarta` int(11) DEFAULT NULL,
  `quinta` int(11) DEFAULT NULL,
  `sexta` int(11) DEFAULT NULL,
  `sabado` int(11) DEFAULT NULL,
  `gerente_codGerente` int(11) NOT NULL,
  `local_id` int(11) NOT NULL,
  `evento_id` int(11) NOT NULL,
  `dataInicio` varchar(11) NOT NULL,
  `dataFim` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `proposta`
--

INSERT INTO `proposta` (`idProposta`, `proponente`, `emailProponente`, `tipoAtividade`, `tituloAtividade`, `finalidadeAtividade`, `cargaHoraria`, `vagasAtividade`, `nomeConvidado`, `emailConvidado`, `formacaoConvidado`, `origem`, `informacoesComplementares`, `diaria`, `estado`, `publico_alvo`, `publico_todos`, `publico_informatica`, `publico_edificacoes`, `publico_eletromecanica`, `publico_eletrotecnica`, `publico_mecanica`, `publico_metalurgia`, `publico_eventos`, `publico_secretariado`, `publico_designMoveis`, `publico_eletronica`, `publico_transacoesImobiliarias`, `publico_transporteFerroviario`, `publico_sistemasInformacao`, `publico_engMecatronica`, `publico_engMetalurgica`, `publico_fisica`, `segunda`, `terca`, `quarta`, `quinta`, `sexta`, `sabado`, `gerente_codGerente`, `local_id`, `evento_id`, `dataInicio`, `dataFim`) VALUES
(7, 't56645', '546654', '45665645', '456654', '456645', '1111', 111, '54665465', '654654', '456654', '456654', '54665', 456, '64546565', 'preferencial', 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, '456465', '456645654'),
(4545, 't56645', '2314432423', '432432', '342432', '234432', '43432432', 234342, '342432432', '423432432', '432432423', '43243432432', '432342432', 3424, '342342342', 'livre', 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 3, 2, 2, '342432', '3243'),
(33333, 'qweqe', 'dsaasdasd', 'saadsdsadsa', 'sdadsasda', 'sasadsdads', '232332', 232332, 'dasadsasddas', 'sdasadds', 'sdasdsadasdas', 'dsadsadsa', 'dsaddsasda', 44444, 'adsds', 'livre', 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 2, 2, 3, '21111', '222222');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`codAdministrador`);

--
-- Indexes for table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`idAlbum`),
  ADD KEY `fk_Album_Galeria1_idx` (`Galeria_id`);

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`idAluno`);

--
-- Indexes for table `certificado`
--
ALTER TABLE `certificado`
  ADD PRIMARY KEY (`codAutencidade`),
  ADD KEY `fk_Certificado_Inscricao1_idx` (`Inscricao_codInscricao`);

--
-- Indexes for table `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`idEvento`),
  ADD KEY `fk_Evento_Administrador1_idx` (`Administrador_codAdministrador`);

--
-- Indexes for table `externo`
--
ALTER TABLE `externo`
  ADD PRIMARY KEY (`idExterno`);

--
-- Indexes for table `fotos`
--
ALTER TABLE `fotos`
  ADD PRIMARY KEY (`idFoto`),
  ADD KEY `fk_Fotos_Album1_idx` (`Album_id`);

--
-- Indexes for table `galeria`
--
ALTER TABLE `galeria`
  ADD PRIMARY KEY (`idGaleria`),
  ADD KEY `fk_Galeria_Evento1_idx` (`Evento_id`);

--
-- Indexes for table `gerente`
--
ALTER TABLE `gerente`
  ADD PRIMARY KEY (`codGerente`);

--
-- Indexes for table `inscricao`
--
ALTER TABLE `inscricao`
  ADD PRIMARY KEY (`codInscricao`),
  ADD KEY `fk_Inscricao_Proposta1_idx` (`Proposta_id`),
  ADD KEY `fk_Inscricao_Externo1_idx` (`Externo_id`),
  ADD KEY `fk_Inscricao_Aluno1_idx` (`Aluno_matricula`);

--
-- Indexes for table `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`idLocal`);

--
-- Indexes for table `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`idNoticia`),
  ADD KEY `fk_Noticia_Evento1_idx` (`Evento_idEvento`);

--
-- Indexes for table `proposta`
--
ALTER TABLE `proposta`
  ADD PRIMARY KEY (`idProposta`),
  ADD KEY `fk_Proposta_Gerente1_idx` (`gerente_codGerente`),
  ADD KEY `fk_Proposta_Local1_idx` (`local_id`),
  ADD KEY `fk_Proposta_Evento1_idx` (`evento_id`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `fk_Album_Galeria1` FOREIGN KEY (`Galeria_id`) REFERENCES `galeria` (`idGaleria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `certificado`
--
ALTER TABLE `certificado`
  ADD CONSTRAINT `fk_Certificado_Inscricao1` FOREIGN KEY (`Inscricao_codInscricao`) REFERENCES `inscricao` (`codInscricao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `fk_Evento_Administrador1` FOREIGN KEY (`Administrador_codAdministrador`) REFERENCES `administrador` (`codAdministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `fotos`
--
ALTER TABLE `fotos`
  ADD CONSTRAINT `fk_Fotos_Album1` FOREIGN KEY (`Album_id`) REFERENCES `album` (`idAlbum`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `galeria`
--
ALTER TABLE `galeria`
  ADD CONSTRAINT `fk_Galeria_Evento1` FOREIGN KEY (`Evento_id`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `inscricao`
--
ALTER TABLE `inscricao`
  ADD CONSTRAINT `fk_Inscricao_Aluno1` FOREIGN KEY (`Aluno_matricula`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Inscricao_Externo1` FOREIGN KEY (`Externo_id`) REFERENCES `externo` (`idExterno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Inscricao_Proposta1` FOREIGN KEY (`Proposta_id`) REFERENCES `proposta` (`idProposta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `noticia`
--
ALTER TABLE `noticia`
  ADD CONSTRAINT `fk_Noticia_Evento1` FOREIGN KEY (`Evento_idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `proposta`
--
ALTER TABLE `proposta`
  ADD CONSTRAINT `fk_Proposta_Evento1` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Proposta_Gerente1` FOREIGN KEY (`gerente_codGerente`) REFERENCES `gerente` (`codGerente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Proposta_Local1` FOREIGN KEY (`local_id`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
