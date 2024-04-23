
--
-- Base de données : `stocka`
--

--
-- Déchargement des données de la table `commandefourniture`
--

INSERT INTO `commandefourniture` (`id`, `valid`, `raison`, `etat`, `ref_utilisateur`, `ref_fournisseur`) VALUES
(1, 1, 'Commande pour la rentrée scolaire', 3, 1, 1),
(2, 1, 'Commande pour le département de Mathématiques', 3, 2, 2),
(3, 1, 'Commande pour le cours de français', 3, 3, 3),
(4, 1, 'Commande pour l\'atelier d\'art', 3, 4, 4),
(5, 1, 'Commande pour le laboratoire de sciences', 3, 5, 5),
(6, 1, 'Commande pour le bureau de l\'infirmerie', 3, 6, 6),
(7, 1, 'Commande pour le département de sociologie', 3, 7, 7),
(8, 1, 'Commande pour le laboratoire de biologie', 3, 8, 8),
(9, 1, 'Commande pour le département d\'informatique', 3, 9, 9),
(10, 1, 'Commande pour l\'atelier de mécanique', 3, 10, 10);

--
-- Déchargement des données de la table `demandefourniture`
--

INSERT INTO `demandefourniture` (`id`, `valid`, `raison`, `etat`, `ref_utilisateur`) VALUES
(1, 1, 'Besoin pour les cours de la rentrée', 3, 1),
(2, 1, 'Demande pour le laboratoire de chimie', 3, 2),
(3, 1, 'Demande pour les ateliers d\'art plastique', 3, 3),
(4, 1, 'Besoin pour les travaux pratiques de physique', 3, 4),
(5, 1, 'Demande pour les fournitures de bureau', 3, 5),
(6, 1, 'Demande pour les fournitures scolaires', 3, 6),
(7, 1, 'Besoin pour les projets informatiques', 3, 7),
(8, 1, 'Demande pour les équipements médicaux', 3, 8),
(9, 1, 'Demande pour le matériel de laboratoire', 3, 9),
(10, 1, 'Besoin pour les outils de mécanique', 3, 10);

--
-- Déchargement des données de la table `dossier`
--

INSERT INTO `dossier` (`id`, `date`, `filiere`, `motivation`, `ref_utilisateur`, `ref_etudiant`) VALUES
(1, '2024-01-10', 'Informatique', 'Passionné par la programmation', 1, 1),
(2, '2024-02-15', 'Économie', 'Intéressé par la finance', 2, 2),
(3, '2024-03-20', 'Littérature', 'Souhaite devenir écrivain', 3, 3),
(4, '2024-04-25', 'Sciences', 'Curieux et avide de découvertes', 4, 4),
(5, '2024-05-30', 'Art', 'Aspiration à devenir artiste', 5, 5),
(6, '2024-06-05', 'Commerce', 'Attiré par le marketing', 6, 6),
(7, '2024-07-10', 'Santé', 'Vocation pour le métier d\'infirmier', 7, 7),
(8, '2024-08-15', 'Social', 'Volonté de travailler dans l\'humanitaire', 8, 8),
(9, '2024-09-20', 'Technologie', 'Intéressé par les nouvelles technologies', 9, 9),
(10, '2024-10-25', 'Mécanique', 'Passion pour la réparation automobile', 10, 10);

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `dernierDiplome`, `tel`, `rue`, `cp`, `ville`, `ref_utilisateur`) VALUES
(1, 'Bac S', '0123456789', 'Rue de la Paix', '75001', 'Paris', 1),
(2, 'Bac ES', '0234567890', 'Avenue des Lilas', '69002', 'Lyon', 2),
(3, 'Bac L', '0345678901', 'Boulevard Voltaire', '13001', 'Marseille', 3),
(4, 'Bac STI2D', '0456789012', 'Rue de la Liberté', '31000', 'Toulouse', 4),
(5, 'Bac Pro', '0567890123', 'Place de la République', '44000', 'Nantes', 5),
(6, 'Bac STMG', '0678901234', 'Avenue Foch', '59000', 'Lille', 6),
(7, 'Bac STL', '0789012345', 'Rue Royale', '67000', 'Strasbourg', 7),
(8, 'Bac ST2S', '0890123456', 'Place Bellecour', '69001', 'Lyon', 8),
(9, 'Bac Techno', '0901234567', 'Rue du Faubourg Saint-Honoré', '75008', 'Paris', 9),
(10, 'Bac Pro', '0012345678', 'Rue de la République', '13002', 'Marseille', 10);

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `libelle`, `tel`, `email`) VALUES
(1, 'Fournisseur A', '0123456789', 'fournisseurA@example.com'),
(2, 'Fournisseur B', '0234567890', 'fournisseurB@example.com'),
(3, 'Fournisseur C', '0345678901', 'fournisseurC@example.com'),
(4, 'Fournisseur D', '0456789012', 'fournisseurD@example.com'),
(5, 'Fournisseur E', '0567890123', 'fournisseurE@example.com'),
(6, 'Fournisseur F', '0678901234', 'fournisseurF@example.com'),
(7, 'Fournisseur G', '0789012345', 'fournisseurG@example.com'),
(8, 'Fournisseur H', '0890123456', 'fournisseurH@example.com'),
(9, 'Fournisseur I', '0901234567', 'fournisseurI@example.com'),
(10, 'Fournisseur J', '0012345678', 'fournisseurJ@example.com');

--
-- Déchargement des données de la table `fourniture`
--

INSERT INTO `fourniture` (`id`, `description`, `libelle`, `qteStock`) VALUES
(1, 'Stylo', 'Stylo noir', 100),
(2, 'Cahier', 'Grand cahier à spirale', 50),
(3, 'Feuille', 'Feuille A4', 200),
(4, 'Crayon', 'Crayon à papier HB', 150),
(5, 'Gomme', 'Gomme blanche', 80),
(6, 'Règle', 'Règle en plastique', 120),
(7, 'Trousse', 'Trousse transparente', 70),
(8, 'Compas', 'Compas métallique', 90),
(9, 'Ciseaux', 'Ciseaux de bureau', 110),
(10, 'Colle', 'Tube de colle liquide', 60);

--
-- Déchargement des données de la table `linkdemmandefourniturefourniture`
--

INSERT INTO `linkdemmandefourniturefourniture` (`id`, `quantite`, `ref_demandeFourniture`, `ref_fourniture`) VALUES
(1, 10, 1, 1),
(2, 20, 2, 2),
(3, 15, 3, 3),
(4, 25, 4, 4),
(5, 30, 5, 5),
(6, 40, 6, 6),
(7, 35, 7, 7),
(8, 45, 8, 8),
(9, 50, 9, 9),
(10, 60, 10, 10);

--
-- Déchargement des données de la table `linkfourniturecommandefourniture`
--

INSERT INTO `linkfourniturecommandefourniture` (`id`, `quantite`, `ref_fourniture`, `ref_commandeFourniture`) VALUES
(1, 10, 1, 1),
(2, 20, 2, 1),
(3, 30, 3, 1),
(4, 15, 4, 2),
(5, 25, 5, 2),
(6, 35, 6, 2),
(7, 40, 7, 3),
(8, 5, 8, 3),
(9, 45, 9, 3),
(10, 50, 10, 4),
(11, 10, 1, 1),
(12, 20, 2, 1),
(13, 30, 3, 1),
(14, 15, 4, 2),
(15, 25, 5, 2),
(16, 35, 6, 2),
(17, 40, 7, 3),
(18, 5, 8, 3),
(19, 45, 9, 3),
(20, 50, 10, 4);

--
-- Déchargement des données de la table `linkfourniturefournisseur`
--

INSERT INTO `linkfourniturefournisseur` (`id`, `prix`, `ref_fourniture`, `ref_fournisseur`) VALUES
(1, 1.5, 1, 1),
(2, 2, 2, 2),
(3, 1.8, 3, 3),
(4, 1.2, 4, 4),
(5, 1, 5, 5),
(6, 1.3, 6, 6),
(7, 1.7, 7, 7),
(8, 1.4, 8, 8),
(9, 1.6, 9, 9),
(10, 1.1, 10, 10),
(11, 1.5, 1, 1),
(12, 2, 2, 2),
(13, 1.8, 3, 3),
(14, 1.2, 4, 4),
(15, 1, 5, 5),
(16, 1.3, 6, 6),
(17, 1.7, 7, 7),
(18, 1.4, 8, 8),
(19, 1.6, 9, 9),
(20, 1.1, 10, 10);

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `libelle`) VALUES
(1, 'Salle A'),
(2, 'Salle B'),
(3, 'Salle C'),
(4, 'Salle D'),
(5, 'Salle E'),
(6, 'Salle F'),
(7, 'Salle G'),
(8, 'Salle H'),
(9, 'Salle I'),
(10, 'Salle J');

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `email`, `mdp`, `roles`) VALUES
(1, 'Dupont', 'Jean', 'jean.dupont@example.com', 'motdepasse123', 1),
(2, 'Martin', 'Sophie', 'sophie.martin@example.com', 'mdp456', 2),
(3, 'Dubois', 'Pierre', 'pierre.dubois@example.com', 'pass1234', 1),
(4, 'Lefevre', 'Marie', 'marie.lefevre@example.com', 'mdp789', 3),
(5, 'Moreau', 'Paul', 'paul.moreau@example.com', 'password', 1),
(6, 'Garcia', 'Lucie', 'lucie.garcia@example.com', 'secret123', 2),
(7, 'Roux', 'Thomas', 'thomas.roux@example.com', 'mdp123', 1),
(8, 'Bonnet', 'Emma', 'emma.bonnet@example.com', 'abc123', 3),
(9, 'Berger', 'Antoine', 'antoine.berger@example.com', 'passpass', 1),
(10, 'Leroy', 'Julie', 'julie.leroy@example.com', 'letmein', 2),
(11, 'Dupont', 'Jean', 'jean.dupont@example.com', 'motdepasse123', 1),
(12, 'Martin', 'Sophie', 'sophie.martin@example.com', 'mdp456', 2),
(13, 'Dubois', 'Pierre', 'pierre.dubois@example.com', 'pass1234', 1),
(14, 'Lefevre', 'Marie', 'marie.lefevre@example.com', 'mdp789', 2),
(15, 'Moreau', 'Paul', 'paul.moreau@example.com', 'password', 1),
(16, 'Garcia', 'Lucie', 'lucie.garcia@example.com', 'secret123', 2),
(17, 'Roux', 'Thomas', 'thomas.roux@example.com', 'mdp123', 3),
(18, 'Bonnet', 'Emma', 'emma.bonnet@example.com', 'abc123', 2),
(19, 'Berger', 'Antoine', 'antoine.berger@example.com', 'passpass', 1),
(20, 'Leroy', 'Julie', 'julie.leroy@example.com', 'letmein', 2),
(21, 'adms', 'aedmin', 'a', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 4);
COMMIT;

