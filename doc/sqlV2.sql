-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 20 fév. 2024 à 08:29
-- Version du serveur : 8.0.31
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_lprs_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `demande_fournitures`
--

DROP TABLE IF EXISTS `demande_fournitures`;
CREATE TABLE IF NOT EXISTS `demande_fournitures` (
  `id_demande` int NOT NULL AUTO_INCREMENT,
  `nom_fourniture` varchar(30) NOT NULL,
  `quantite_demander` int NOT NULL,
  `ref_prof` int NOT NULL,
  `ref_gestionaire` int DEFAULT NULL,
  `raison` varchar(20) NOT NULL,
  PRIMARY KEY (`id_demande`),
  KEY `fk_demande_prof` (`ref_prof`),
  KEY `fk_demande_gestionaire` (`ref_gestionaire`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `demande_fournitures`
--

INSERT INTO `demande_fournitures` (`id_demande`, `nom_fourniture`, `quantite_demander`, `ref_prof`, `ref_gestionaire`, `raison`) VALUES
(1, 'Gomme', 1, 4, NULL, 'Je sais pas'),
(2, 'Crai', 2, 4, NULL, 'j\'ai oublier'),
(3, 'Crai', 1, 6, NULL, 'Askip c\'est gratui');

-- --------------------------------------------------------

--
-- Structure de la table `dossier_inscription`
--

DROP TABLE IF EXISTS `dossier_inscription`;
CREATE TABLE IF NOT EXISTS `dossier_inscription` (
  `id_dossier` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `heure` time DEFAULT NULL,
  `filiere` varchar(40) NOT NULL,
  `motivation` varchar(40) NOT NULL,
  `ref_fiche` int NOT NULL,
  PRIMARY KEY (`id_dossier`),
  KEY `fk_dossier_etudiant` (`ref_fiche`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dossier_inscription`
--

INSERT INTO `dossier_inscription` (`id_dossier`, `date`, `heure`, `filiere`, `motivation`, `ref_fiche`) VALUES
(5, '2023-03-14 14:08:25', NULL, 'STMG', 'C\'est bien askip', 1);

-- --------------------------------------------------------

--
-- Structure de la table `fiche_etudiant`
--

DROP TABLE IF EXISTS `fiche_etudiant`;
CREATE TABLE IF NOT EXISTS `fiche_etudiant` (
  `id_fiche` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `diplome` varchar(30) NOT NULL,
  `telephone` int NOT NULL,
  `rue` varchar(30) NOT NULL,
  `cp` int NOT NULL,
  `ville` varchar(50) NOT NULL,
  `ref_utilisateur` int NOT NULL,
  PRIMARY KEY (`id_fiche`),
  KEY `fk_etudiant_user` (`ref_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fiche_etudiant`
--

INSERT INTO `fiche_etudiant` (`id_fiche`, `nom`, `prenom`, `email`, `diplome`, `telephone`, `rue`, `cp`, `ville`, `ref_utilisateur`) VALUES
(1, 'JIJI', 'Amar', 'jiji@gmail.com', 'BTS', 788191572, '12 mooulin bas', 75014, 'Paris', 6),
(2, 'LOPES', 'Hugo', 'hugo@gmail.com', 'Master', 788191572, '12 avenue foch', 75016, 'Paris', 4);

-- --------------------------------------------------------

--
-- Structure de la table `fiche_fourniture`
--

DROP TABLE IF EXISTS `fiche_fourniture`;
CREATE TABLE IF NOT EXISTS `fiche_fourniture` (
  `id_fiche_fourniture` int NOT NULL AUTO_INCREMENT,
  `prix` varchar(20) NOT NULL,
  `ref_fournisseur` int NOT NULL,
  `ref_fourniture` int NOT NULL,
  `ref_utilisateur` int NOT NULL,
  PRIMARY KEY (`id_fiche_fourniture`),
  KEY `fk_fiche_fourniture_fournisseur` (`ref_fournisseur`),
  KEY `fk_fiche_fourniture_fourniture` (`ref_fourniture`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fiche_fourniture`
--

INSERT INTO `fiche_fourniture` (`id_fiche_fourniture`, `prix`, `ref_fournisseur`, `ref_fourniture`, `ref_utilisateur`) VALUES
(1, '5.0', 1, 2, 0),
(2, '5.0', 1, 3, 5);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id_fournisseur` int NOT NULL AUTO_INCREMENT,
  `nom_entreprise` varchar(20) NOT NULL,
  `rue` varchar(20) NOT NULL,
  `cp` int NOT NULL,
  `ville` varchar(20) NOT NULL,
  `ref_utilisateur` int NOT NULL,
  PRIMARY KEY (`id_fournisseur`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id_fournisseur`, `nom_entreprise`, `rue`, `cp`, `ville`, `ref_utilisateur`) VALUES
(1, 'Stabillo', '12 Rue Masser', 94150, 'Chatou', 0);

-- --------------------------------------------------------

--
-- Structure de la table `fourniture`
--

DROP TABLE IF EXISTS `fourniture`;
CREATE TABLE IF NOT EXISTS `fourniture` (
  `id_fourniture` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `stock` int NOT NULL,
  `ref_utilisateur` int NOT NULL,
  PRIMARY KEY (`id_fourniture`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fourniture`
--

INSERT INTO `fourniture` (`id_fourniture`, `nom`, `stock`, `ref_utilisateur`) VALUES
(1, 'Gomme', 400, 0),
(2, 'Crai', 800, 0),
(3, 'Colle', 5000, 0);

-- --------------------------------------------------------

--
-- Structure de la table `logs`
--

DROP TABLE IF EXISTS `logs`;
CREATE TABLE IF NOT EXISTS `logs` (
  `id_logs` int NOT NULL AUTO_INCREMENT,
  `ref_compte` int NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `adresse_ip` varchar(200) NOT NULL,
  PRIMARY KEY (`id_logs`),
  KEY `fk_logs_utilisateur` (`ref_compte`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `logs`
--

INSERT INTO `logs` (`id_logs`, `ref_compte`, `date`, `adresse_ip`) VALUES
(1, 3, '2023-03-06 12:22:02', '172.19.112.1'),
(2, 3, '2023-03-06 12:55:16', '172.19.112.1'),
(3, 3, '2023-03-06 15:50:27', '172.19.112.1'),
(4, 3, '2023-03-06 16:13:06', '172.19.112.1'),
(5, 3, '2023-03-06 16:15:05', '172.19.112.1'),
(6, 3, '2023-03-06 16:29:54', '172.19.112.1'),
(7, 3, '2023-03-06 22:07:48', '172.19.112.1'),
(8, 4, '2023-03-06 22:11:51', '172.19.112.1'),
(9, 4, '2023-03-06 22:13:12', '172.19.112.1'),
(10, 4, '2023-03-06 22:19:38', '172.19.112.1'),
(11, 4, '2023-03-06 22:30:58', '172.19.112.1'),
(12, 4, '2023-03-06 22:33:23', '172.19.112.1'),
(13, 4, '2023-03-06 22:40:09', '172.19.112.1'),
(14, 4, '2023-03-06 22:48:12', '172.19.112.1'),
(15, 4, '2023-03-07 12:15:21', '172.19.112.1'),
(16, 4, '2023-03-07 12:49:42', '172.19.112.1'),
(17, 4, '2023-03-07 12:53:19', '172.19.112.1'),
(18, 4, '2023-03-07 12:56:01', '172.19.112.1'),
(19, 4, '2023-03-07 14:16:13', '172.19.112.1'),
(20, 4, '2023-03-07 15:05:04', '172.19.112.1'),
(21, 4, '2023-03-07 15:06:30', '172.19.112.1'),
(22, 4, '2023-03-08 11:54:48', '172.19.112.1'),
(23, 3, '2023-03-08 11:56:20', '172.19.112.1'),
(24, 4, '2023-03-08 12:40:30', '172.19.112.1'),
(25, 4, '2023-03-08 19:05:11', '172.19.112.1'),
(26, 4, '2023-03-08 19:08:53', '172.19.112.1'),
(27, 4, '2023-03-08 19:11:03', '172.19.112.1'),
(28, 4, '2023-03-08 19:16:42', '172.19.112.1'),
(29, 4, '2023-03-08 19:19:11', '172.19.112.1'),
(30, 4, '2023-03-08 19:24:02', '172.19.112.1'),
(31, 4, '2023-03-08 19:25:17', '172.19.112.1'),
(32, 4, '2023-03-08 19:28:04', '172.19.112.1'),
(33, 4, '2023-03-08 19:30:29', '172.19.112.1'),
(34, 4, '2023-03-08 19:33:37', '172.19.112.1'),
(35, 4, '2023-03-08 19:35:58', '172.19.112.1'),
(36, 4, '2023-03-08 19:37:55', '172.19.112.1'),
(37, 4, '2023-03-08 19:39:36', '172.19.112.1'),
(38, 4, '2023-03-08 20:08:29', '172.19.112.1'),
(39, 4, '2023-03-08 20:24:01', '172.19.112.1'),
(40, 3, '2023-03-08 20:24:35', '172.19.112.1'),
(41, 5, '2023-03-08 20:28:00', '172.19.112.1'),
(42, 4, '2023-03-11 11:15:40', '172.19.112.1'),
(43, 4, '2023-03-11 11:17:12', '172.19.112.1'),
(44, 4, '2023-03-11 11:23:30', '172.19.112.1'),
(45, 4, '2023-03-11 11:26:47', '172.19.112.1'),
(46, 4, '2023-03-11 11:29:47', '172.19.112.1'),
(47, 4, '2023-03-11 13:49:14', '172.19.112.1'),
(48, 4, '2023-03-12 12:10:50', '172.19.112.1'),
(49, 3, '2023-03-12 12:26:41', '172.19.112.1'),
(50, 3, '2023-03-12 12:41:35', '172.19.112.1'),
(51, 3, '2023-03-12 22:30:03', '172.19.112.1'),
(52, 3, '2023-03-12 22:53:49', '172.19.112.1'),
(53, 3, '2023-03-12 22:58:51', '172.19.112.1'),
(54, 3, '2023-03-12 22:59:53', '172.19.112.1'),
(55, 3, '2023-03-13 09:00:03', '172.19.112.1'),
(56, 3, '2023-03-13 09:22:07', '172.19.112.1'),
(57, 3, '2023-03-13 09:42:35', '172.19.112.1'),
(58, 3, '2023-03-13 09:53:13', '172.19.112.1'),
(59, 3, '2023-03-13 10:20:13', '172.19.112.1'),
(60, 3, '2023-03-13 10:29:29', '172.19.112.1'),
(61, 3, '2023-03-13 10:33:14', '172.19.112.1'),
(62, 3, '2023-03-13 10:35:57', '172.19.112.1'),
(63, 4, '2023-03-13 11:34:47', '172.19.112.1'),
(64, 3, '2023-03-13 11:37:35', '172.19.112.1'),
(65, 4, '2023-03-13 11:38:17', '172.19.112.1'),
(66, 4, '2023-03-13 11:41:50', '172.19.112.1'),
(67, 4, '2023-03-13 11:47:17', '172.19.112.1'),
(68, 4, '2023-03-13 11:53:04', '172.19.112.1'),
(69, 4, '2023-03-13 11:54:43', '172.19.112.1'),
(70, 4, '2023-03-13 14:08:04', '172.19.112.1'),
(71, 3, '2023-03-13 19:48:34', '172.19.112.1'),
(72, 3, '2023-03-13 19:54:27', '172.19.112.1'),
(73, 3, '2023-03-13 20:08:09', '172.19.112.1'),
(74, 3, '2023-03-13 20:11:23', '172.19.112.1'),
(75, 3, '2023-03-13 20:17:16', '172.19.112.1'),
(76, 3, '2023-03-14 12:00:06', '172.19.112.1'),
(77, 3, '2023-03-14 12:05:24', '172.19.112.1'),
(78, 3, '2023-03-14 12:13:25', '172.19.112.1'),
(79, 3, '2023-03-14 14:18:49', '172.19.112.1'),
(80, 3, '2023-03-14 14:20:09', '172.19.112.1'),
(81, 3, '2023-03-14 15:02:57', '172.19.112.1'),
(82, 3, '2023-03-14 15:04:06', '172.19.112.1'),
(83, 3, '2023-03-14 15:05:20', '172.19.112.1'),
(84, 3, '2023-03-14 15:11:25', '172.19.112.1'),
(85, 4, '2023-03-17 19:29:19', '192.168.56.1'),
(86, 4, '2023-03-17 19:31:07', '192.168.56.1'),
(87, 5, '2023-03-17 19:32:08', '192.168.56.1'),
(88, 5, '2023-03-17 19:36:20', '192.168.56.1'),
(89, 5, '2023-03-18 09:06:21', '192.168.56.1'),
(90, 5, '2023-03-18 23:52:55', '192.168.56.1'),
(91, 3, '2023-03-18 23:57:15', '192.168.56.1'),
(92, 3, '2023-03-19 12:14:45', '192.168.56.1'),
(93, 6, '2023-03-20 09:19:41', '192.168.56.1'),
(94, 6, '2023-03-20 09:26:02', '192.168.56.1'),
(95, 6, '2023-03-20 09:30:43', '192.168.56.1'),
(96, 4, '2023-03-20 11:44:31', '192.168.56.1'),
(97, 3, '2023-03-20 15:53:23', '192.168.56.1'),
(98, 3, '2023-03-20 15:54:15', '192.168.56.1'),
(99, 3, '2023-03-20 15:57:06', '192.168.56.1'),
(100, 3, '2023-03-20 16:02:18', '192.168.56.1'),
(101, 4, '2023-03-20 16:04:15', '192.168.56.1'),
(102, 4, '2023-03-20 16:09:30', '192.168.56.1'),
(103, 4, '2023-03-20 16:10:42', '192.168.56.1'),
(104, 4, '2023-03-20 16:11:37', '192.168.56.1'),
(105, 3, '2023-03-20 22:55:49', '192.168.56.1'),
(106, 6, '2023-03-20 23:31:19', '192.168.56.1'),
(107, 6, '2023-03-20 23:37:08', '192.168.56.1'),
(108, 6, '2023-03-20 23:39:08', '192.168.56.1'),
(109, 6, '2023-03-20 23:41:51', '192.168.56.1'),
(110, 6, '2023-03-20 23:45:00', '192.168.56.1'),
(111, 6, '2023-03-20 23:51:59', '192.168.56.1'),
(112, 3, '2023-03-21 00:34:45', '192.168.56.1'),
(113, 3, '2023-03-21 01:12:00', '192.168.56.1'),
(114, 3, '2023-03-21 01:14:18', '192.168.56.1'),
(115, 3, '2023-03-21 01:29:26', '192.168.56.1'),
(116, 3, '2023-03-21 01:31:19', '192.168.56.1'),
(117, 3, '2023-03-21 01:44:39', '192.168.56.1'),
(118, 3, '2023-03-21 01:46:16', '192.168.56.1'),
(119, 3, '2023-03-21 01:50:06', '192.168.56.1'),
(120, 3, '2023-03-21 11:45:45', '192.168.56.1'),
(121, 3, '2023-03-21 11:47:22', '192.168.56.1'),
(122, 3, '2023-03-21 11:59:06', '192.168.56.1'),
(123, 3, '2023-03-25 22:35:45', '192.168.56.1'),
(124, 5, '2023-03-25 22:56:17', '192.168.56.1'),
(125, 4, '2023-03-25 23:02:46', '192.168.56.1'),
(126, 6, '2023-03-25 23:07:02', '192.168.56.1'),
(127, 3, '2023-03-25 23:09:34', '192.168.56.1'),
(128, 3, '2023-03-25 23:18:27', '192.168.56.1'),
(129, 3, '2023-03-25 23:42:31', '192.168.56.1'),
(130, 3, '2023-03-26 00:27:52', '192.168.56.1'),
(131, 3, '2023-03-26 00:29:16', '192.168.56.1'),
(132, 3, '2023-03-26 00:33:30', '192.168.56.1'),
(133, 6, '2023-03-30 20:26:00', '192.168.56.1'),
(134, 5, '2023-03-31 15:57:07', '192.168.56.1'),
(135, 5, '2023-03-31 15:59:49', '192.168.56.1');

-- --------------------------------------------------------

--
-- Structure de la table `rendez-vous`
--

DROP TABLE IF EXISTS `rendez-vous`;
CREATE TABLE IF NOT EXISTS `rendez-vous` (
  `id_rdv` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `ref_salle` int NOT NULL,
  `ref_prof` int NOT NULL,
  `ref_dossier` int NOT NULL,
  PRIMARY KEY (`id_rdv`),
  KEY `fk_rdv_prof` (`ref_prof`),
  KEY `fk-rdv_salle` (`ref_salle`),
  KEY `fk-rdv_dossier` (`ref_dossier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `Batiment` varchar(20) NOT NULL,
  PRIMARY KEY (`id_salle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mdp` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `role` tinyint NOT NULL,
  `ref_admin` int NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `fk_utilisateur_admin` (`ref_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_user`, `nom`, `prenom`, `email`, `mdp`, `role`, `ref_admin`) VALUES
(3, 'gbahe taho', 'laurine', 'meganetaho@gmail.com', 'azerty1', 1, 3),
(4, 'POP', 'Go', 'go@gmail.com', '7682fe272099ea26efe39c890b33675b', 2, 3),
(5, 'LA FONTAI', 'Gérard', 'dlfg@gmail.com', '7682fe272099ea26efe39c890b33675b', 4, 3),
(6, 'MOPU', 'Manomano', 'mano@gmail.com', '7682fe272099ea26efe39c890b33675b', 3, 3),
(7, 'uygtguyhij', 'yuhuinij', 'jnuinkj', '03f3458c32c385976cfc0bc58be6331c', 3, 3),
(8, 'azed', 'zrfzrf', 'zrfz', '611c7bca376f88d4b516b377de9b718f', 1, 3),
(9, 'fatmi', 'imane', 'megane@gmail.com', 'ANgenathalie21!!', 1, 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `demande_fournitures`
--
ALTER TABLE `demande_fournitures`
  ADD CONSTRAINT `fk_demande_gestionaire` FOREIGN KEY (`ref_gestionaire`) REFERENCES `utilisateur` (`id_user`),
  ADD CONSTRAINT `fk_demande_prof` FOREIGN KEY (`ref_prof`) REFERENCES `utilisateur` (`id_user`);

--
-- Contraintes pour la table `dossier_inscription`
--
ALTER TABLE `dossier_inscription`
  ADD CONSTRAINT `fk_dossier_etudiant` FOREIGN KEY (`ref_fiche`) REFERENCES `fiche_etudiant` (`id_fiche`);

--
-- Contraintes pour la table `fiche_etudiant`
--
ALTER TABLE `fiche_etudiant`
  ADD CONSTRAINT `fk_etudiant_user` FOREIGN KEY (`ref_utilisateur`) REFERENCES `utilisateur` (`id_user`);

--
-- Contraintes pour la table `fiche_fourniture`
--
ALTER TABLE `fiche_fourniture`
  ADD CONSTRAINT `fiche_fourniture_ibfk_1` FOREIGN KEY (`ref_fourniture`) REFERENCES `fourniture` (`id_fourniture`);

--
-- Contraintes pour la table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `fk_logs_utilisateur` FOREIGN KEY (`ref_compte`) REFERENCES `utilisateur` (`id_user`);

--
-- Contraintes pour la table `rendez-vous`
--
ALTER TABLE `rendez-vous`
  ADD CONSTRAINT `fk-rdv_dossier` FOREIGN KEY (`ref_dossier`) REFERENCES `dossier_inscription` (`id_dossier`),
  ADD CONSTRAINT `fk-rdv_salle` FOREIGN KEY (`ref_salle`) REFERENCES `salle` (`id_salle`),
  ADD CONSTRAINT `fk_rdv_prof` FOREIGN KEY (`ref_prof`) REFERENCES `utilisateur` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
