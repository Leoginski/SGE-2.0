-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20-Abr-2017 às 02:38
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sge`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `codAdministrador` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`codAdministrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `administrador`
--

INSERT INTO `administrador` (`codAdministrador`, `nome`, `dataNascimento`, `email`, `senha`) VALUES
(1, 'Luiz Filipy', '01011997', 'lipe@lipe', '123'),
(2, 'Leonardo', '12111995', 'leo@leo', '1234'),
(3, 'Matheus', '01041997', 'matsouzaleao@gmail.com', '012345'),
(4, 'Stela', '12012009', 'stela@stela', '1234567'),
(111, 'nome', '10/10/2010', 'email', '12345');

-- --------------------------------------------------------

--
-- Estrutura da tabela `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `idAlbum` int(11) NOT NULL,
  `desricao` varchar(45) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `Galeria_id` int(11) NOT NULL,
  PRIMARY KEY (`idAlbum`),
  KEY `fk_Album_Galeria1_idx` (`Galeria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE IF NOT EXISTS `aluno` (
  `idAluno` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idAluno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`idAluno`, `nome`, `email`, `dataNascimento`, `senha`) VALUES
(1, '1', '1', '1', '1'),
(3, 'RAmones', 'ramon@ramon', '19122011', '123'),
(76, 'mak', 'ksksk', '18828282993012', 'aks'),
(150, 'Nicolal', 'nick@nick', 'maquiavel69', '02141996'),
(160, 'Henry', 'henry@henry', '321', '22111900'),
(8778787, 'f', 'f', 'f', 'f');

-- --------------------------------------------------------

--
-- Estrutura da tabela `certificado`
--

CREATE TABLE IF NOT EXISTS `certificado` (
  `codAutencidade` varchar(30) NOT NULL,
  `descricao` varchar(60) DEFAULT NULL,
  `Inscricao_codInscricao` int(11) NOT NULL,
  PRIMARY KEY (`codAutencidade`),
  KEY `fk_Certificado_Inscricao1_idx` (`Inscricao_codInscricao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

CREATE TABLE IF NOT EXISTS `evento` (
  `idEvento` int(11) NOT NULL,
  `nomeEvento` varchar(45) DEFAULT NULL,
  `duracao` varchar(10) DEFAULT NULL,
  `tema` varchar(50) DEFAULT NULL,
  `dataInicioEvento` varchar(45) DEFAULT NULL,
  `dataFimEvento` varchar(45) DEFAULT NULL,
  `dataInicioInscricao` varchar(45) DEFAULT NULL,
  `dataFimInscricao` varchar(45) DEFAULT NULL,
  `Administrador_codAdministrador` int(11) NOT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `fk_Evento_Administrador1_idx` (`Administrador_codAdministrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `evento`
--

INSERT INTO `evento` (`idEvento`, `nomeEvento`, `duracao`, `tema`, `dataInicioEvento`, `dataFimEvento`, `dataInicioInscricao`, `dataFimInscricao`, `Administrador_codAdministrador`) VALUES
(1, 'Semana Do Tecnico', '7 dias', 'Informatica e Sociedade', '27092016', '04102016', '20092016', '27092016', 1),
(2, 'SECITEC', '1 semana', 'Informatica e Sociedade', '19112016', '19112016', '29112016', '29112016', 1),
(3, '4', '4', '4', '4', '4', '4', '4', 4),
(57665, '6', '6', '6', '66', '6', '6', '6', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `externo`
--

CREATE TABLE IF NOT EXISTS `externo` (
  `idExterno` int(11) NOT NULL,
  `conhecimento` varchar(30) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idExterno`)
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

CREATE TABLE IF NOT EXISTS `fotos` (
  `idFoto` int(11) NOT NULL,
  `Album_id` int(11) NOT NULL,
  `arquivo` blob NOT NULL,
  PRIMARY KEY (`idFoto`),
  KEY `fk_Fotos_Album1_idx` (`Album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `galeria`
--

CREATE TABLE IF NOT EXISTS `galeria` (
  `idGaleria` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `Evento_id` int(11) NOT NULL,
  PRIMARY KEY (`idGaleria`),
  KEY `fk_Galeria_Evento1_idx` (`Evento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gerente`
--

CREATE TABLE IF NOT EXISTS `gerente` (
  `codGerente` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`codGerente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `gerente`
--

INSERT INTO `gerente` (`codGerente`, `nome`, `email`, `dataNascimento`, `senha`) VALUES
(1, 'Leoginsk', 'leo@leo', '11091996', '123'),
(2, 'Pedro Petigrou', 'pedro@pedro', '12071995', '4321'),
(3, 'Math', 'k', 'mkmk', 'asasas'),
(4, '5', '5', '5', '5'),
(11231, 'p', 'p', 'p', 'p');

-- --------------------------------------------------------

--
-- Estrutura da tabela `inscricao`
--

CREATE TABLE IF NOT EXISTS `inscricao` (
  `codInscricao` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `frequencia` tinyint(1) DEFAULT NULL,
  `Proposta_id` int(11) NOT NULL,
  `Externo_id` int(11) NOT NULL,
  `Aluno_matricula` int(11) NOT NULL,
  PRIMARY KEY (`codInscricao`),
  KEY `fk_Inscricao_Proposta1_idx` (`Proposta_id`),
  KEY `fk_Inscricao_Externo1_idx` (`Externo_id`),
  KEY `fk_Inscricao_Aluno1_idx` (`Aluno_matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `local`
--

CREATE TABLE IF NOT EXISTS `local` (
  `idLocal` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `capacidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLocal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `local`
--

INSERT INTO `local` (`idLocal`, `descricao`, `capacidade`) VALUES
(1, 'Auditório', 50),
(2, 'Auditorio do Bloco A', 300),
(78, '7878', 78787),
(12312, 'p', 800);

-- --------------------------------------------------------

--
-- Estrutura da tabela `noticia`
--

CREATE TABLE IF NOT EXISTS `noticia` (
  `idNoticia` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `descricao` varchar(60) DEFAULT NULL,
  `Evento_idEvento` int(11) NOT NULL,
  PRIMARY KEY (`idNoticia`),
  KEY `fk_Noticia_Evento1_idx` (`Evento_idEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `noticia`
--

INSERT INTO `noticia` (`idNoticia`, `data`, `descricao`, `Evento_idEvento`) VALUES
(1, '27092016', 'Uma descricao qualquer', 1),
(2, '29092016', 'Procura-se Lipy', 2),
(3, '3', '3', 1),
(12321, 'p', 'p', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `proposta`
--

CREATE TABLE IF NOT EXISTS `proposta` (
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
  `dataFim` varchar(11) NOT NULL,
  PRIMARY KEY (`idProposta`),
  KEY `fk_Proposta_Gerente1_idx` (`gerente_codGerente`),
  KEY `fk_Proposta_Local1_idx` (`local_id`),
  KEY `fk_Proposta_Evento1_idx` (`evento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `proposta`
--

INSERT INTO `proposta` (`idProposta`, `proponente`, `emailProponente`, `tipoAtividade`, `tituloAtividade`, `finalidadeAtividade`, `cargaHoraria`, `vagasAtividade`, `nomeConvidado`, `emailConvidado`, `formacaoConvidado`, `origem`, `informacoesComplementares`, `diaria`, `estado`, `publico_alvo`, `publico_todos`, `publico_informatica`, `publico_edificacoes`, `publico_eletromecanica`, `publico_eletrotecnica`, `publico_mecanica`, `publico_metalurgia`, `publico_eventos`, `publico_secretariado`, `publico_designMoveis`, `publico_eletronica`, `publico_transacoesImobiliarias`, `publico_transporteFerroviario`, `publico_sistemasInformacao`, `publico_engMecatronica`, `publico_engMetalurgica`, `publico_fisica`, `segunda`, `terca`, `quarta`, `quinta`, `sexta`, `sabado`, `gerente_codGerente`, `local_id`, `evento_id`, `dataInicio`, `dataFim`) VALUES
(1, 'Marco', 'marco@marco', 'Palestra', 'Como dar um esporro que faça seu aluno chorar', 'Ensinar os alunos a darem esporro quando se tornarem professores, e oprimir os alunos.', '6', 15, 'Marco ', 'marco@marco', 'Não cabe nesse tamanho de campo', 'importa?', 'Nenhuma', 0, '', '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, '', ''),
(2, 'Proponente do Evento', 'pro@nente.com.br', 'Palestra', 'Programacao em python', 'Ensinar.', '6:00', 10, 'Marco', 'marco@marco', 'Chingador de aluno', 'Marte', 'Mudanca', 0, '', '', 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, '10/10/1000', '01/01/2000'),
(3, '3', '3', '3', '3', '3', '3', 3, '3', '3', '3', '3', '3', 3, '3', 'livre', 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 3, '3', '3'),
(8, '8', '8', '8', '8', '88', '8', 8, '8', '8', '8', '8', '8', 88, '8', 'livre', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, '8', '8'),
(77, '7', '7', '7', '7', '7', '7', 7, '7', '7', '7', '7', '7', 7, '7', 'livre', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, '7', '7'),
(888, '8', '8', '8', '8', '8', '8', 8, '8', '8', '8', '8', '8', 8, '8', 'preferencial', 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, '8', '8'),
(67676, '6', '6', '6', '6', '6', '6', 6, '6', '66', '6', '6', '6', 6, '6', 'livre', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, '6', '6');

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
  ADD CONSTRAINT `fk_Proposta_Evento1` FOREIGN KEY (`Evento_id`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Proposta_Gerente1` FOREIGN KEY (`Gerente_codGerente`) REFERENCES `gerente` (`codGerente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Proposta_Local1` FOREIGN KEY (`Local_id`) REFERENCES `local` (`idLocal`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
