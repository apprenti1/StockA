-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 15 jan. 2024 à 10:59
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `stocka`
--

-- --------------------------------------------------------

--
-- Structure de la table `commandefourniture`
--

DROP TABLE IF EXISTS `commandefourniture`;
CREATE TABLE IF NOT EXISTS `commandefourniture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valid` int NOT NULL,
  `raison` text NOT NULL,
  `etat` int NOT NULL,
  `ref_utilisateur` int NOT NULL,
  `ref_fournisseur` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_utilisateurcommandefourniture` (`ref_utilisateur`),
  KEY `FK_fournisseurcommandefournisseur` (`ref_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commandefourniturecomportefourniture`
--

DROP TABLE IF EXISTS `commandefourniturecomportefourniture`;
CREATE TABLE IF NOT EXISTS `commandefourniturecomportefourniture` (
  `quantite` int NOT NULL,
  `ref_CommandeFourniture` int NOT NULL,
  `ref_fourniture` int NOT NULL,
  KEY `FK_commandeFourniture` (`ref_CommandeFourniture`),
  KEY `FK_commandefourniturecomportefourniture` (`ref_fourniture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `demandefourniture`
--

DROP TABLE IF EXISTS `demandefourniture`;
CREATE TABLE IF NOT EXISTS `demandefourniture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valid` tinyint(1) NOT NULL,
  `raison` varchar(100) NOT NULL,
  `etat` int NOT NULL,
  `ref_utilisateur` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_utilisateur_demandefourniture` (`ref_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `demandefourniturecomportefourniture`
--

DROP TABLE IF EXISTS `demandefourniturecomportefourniture`;
CREATE TABLE IF NOT EXISTS `demandefourniturecomportefourniture` (
  `quantite` int NOT NULL,
  `ref_fourniture` int NOT NULL,
  `ref_demandeFourniture` int NOT NULL,
  KEY `FK_fourniture` (`ref_fourniture`),
  KEY `FK_demandefourniture` (`ref_demandeFourniture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `dossier`
--

DROP TABLE IF EXISTS `dossier`;
CREATE TABLE IF NOT EXISTS `dossier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `filliere` varchar(15) NOT NULL,
  `motivation` text NOT NULL,
  `ref_utilisateur` int NOT NULL,
  `ref_etudiant` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_etudiant` (`ref_etudiant`),
  KEY `FK_utilisateur` (`ref_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dernier_diplome` varchar(15) NOT NULL,
  `tel` int NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `ref_utilisateur` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_utiliasateur` (`ref_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  `tel` int NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fournitpar`
--

DROP TABLE IF EXISTS `fournitpar`;
CREATE TABLE IF NOT EXISTS `fournitpar` (
  `prix` int NOT NULL,
  `ref_fournisseur` int NOT NULL,
  `ref_fourniture` int NOT NULL,
  KEY `FK_fournitparFournitpar` (`ref_fourniture`),
  KEY `FK_fournisseur` (`ref_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fourniture`
--

DROP TABLE IF EXISTS `fourniture`;
CREATE TABLE IF NOT EXISTS `fourniture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` int NOT NULL,
  `libelle` int NOT NULL,
  `qte_stock` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `ref_utilisateur` int NOT NULL,
  `ref_salle` int NOT NULL,
  `ref_dossier` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_utiliasateur_rdv` (`ref_utilisateur`),
  KEY `FK_salle` (`ref_salle`),
  KEY `ref_dossier` (`ref_dossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `roles` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commandefourniture`
--
ALTER TABLE `commandefourniture`
  ADD CONSTRAINT `FK_fournisseurcommandefournisseur` FOREIGN KEY (`ref_fournisseur`) REFERENCES `fournisseur` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_utilisateurcommandefourniture` FOREIGN KEY (`ref_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `commandefourniturecomportefourniture`
--
ALTER TABLE `commandefourniturecomportefourniture`
  ADD CONSTRAINT `FK_commandeFourniture` FOREIGN KEY (`ref_CommandeFourniture`) REFERENCES `commandefourniture` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_commandefourniturecomportefourniture` FOREIGN KEY (`ref_fourniture`) REFERENCES `fourniture` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `demandefourniture`
--
ALTER TABLE `demandefourniture`
  ADD CONSTRAINT `FK_utilisateur_demandefourniture` FOREIGN KEY (`ref_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `demandefourniturecomportefourniture`
--
ALTER TABLE `demandefourniturecomportefourniture`
  ADD CONSTRAINT `FK_demandefourniture` FOREIGN KEY (`ref_demandeFourniture`) REFERENCES `demandefourniture` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_fourniture` FOREIGN KEY (`ref_fourniture`) REFERENCES `fourniture` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `dossier`
--
ALTER TABLE `dossier`
  ADD CONSTRAINT `FK_etudiant` FOREIGN KEY (`ref_etudiant`) REFERENCES `etudiant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_utilisateur` FOREIGN KEY (`ref_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK_utiliasateur` FOREIGN KEY (`ref_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `fournitpar`
--
ALTER TABLE `fournitpar`
  ADD CONSTRAINT `FK_fournisseur` FOREIGN KEY (`ref_fournisseur`) REFERENCES `fournisseur` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_fournitparFournitpar` FOREIGN KEY (`ref_fourniture`) REFERENCES `fourniture` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `FK_salle` FOREIGN KEY (`ref_salle`) REFERENCES `salle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_utiliasateur_rdv` FOREIGN KEY (`ref_utilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `ref_dossier` FOREIGN KEY (`ref_dossier`) REFERENCES `dossier` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
