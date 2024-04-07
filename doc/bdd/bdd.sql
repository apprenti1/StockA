-- Création de la base de données StockA
CREATE DATABASE IF NOT EXISTS StockA;

-- Utilisation de la base de données StockA
USE StockA;

-- Définir le moteur de stockage InnoDB par défaut
SET default_storage_engine = InnoDB;

-- Table Utilisateur
CREATE TABLE Utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mdp VARCHAR(1000) NOT NULL,
    roles INT NOT NULL
) ENGINE=InnoDB;

-- Table Etudiant
CREATE TABLE Etudiant (
    id INT PRIMARY KEY,
    dernierDiplome VARCHAR(255) NOT NULL,
    tel VARCHAR(10) NOT NULL,
    rue VARCHAR(255) NOT NULL,
    cp VARCHAR(255) NOT NULL,
    ville VARCHAR(255) NOT NULL,
    ref_utilisateur INT
) ENGINE=InnoDB;

-- Table Dossier
CREATE TABLE Dossier (
    id INT PRIMARY KEY,
    date DATE NOT NULL,
    filiere VARCHAR(255) NOT NULL,
    motivation VARCHAR(255) NOT NULL,
    ref_utilisateur INT,
    ref_etudiant INT
) ENGINE=InnoDB;

-- Table RDV
CREATE TABLE RDV (
    id INT PRIMARY KEY,
    date DATE NOT NULL,
    heure TIME NOT NULL,
    ref_utilisateur INT,
    ref_salle INT,
    ref_dossier INT
) ENGINE=InnoDB;

-- Table Salle
CREATE TABLE Salle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

-- Table DemandeFourniture
CREATE TABLE DemandeFourniture (
    id INT PRIMARY KEY,
    valid BOOLEAN NOT NULL,
    raison VARCHAR(255) NOT NULL,
    etat INT NOT NULL,
    ref_utilisateur INT
) ENGINE=InnoDB;

-- Table LinkDemmandeFournitureFourniture
CREATE TABLE LinkDemmandeFournitureFourniture (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantite INT NOT NULL,
    ref_demandeFourniture INT,
    ref_fourniture INT
) ENGINE=InnoDB;

-- Table Fourniture
CREATE TABLE Fourniture (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    libelle VARCHAR(255) NOT NULL,
    qteStock INT(5) NOT NULL
) ENGINE=InnoDB;

-- Table LinkFournitureFournisseur
CREATE TABLE LinkFournitureFournisseur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    prix FLOAT NOT NULL,
    ref_fourniture INT,
    ref_fournisseur INT
) ENGINE=InnoDB;

-- Table Fournisseur
CREATE TABLE Fournisseur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(255) NOT NULL,
    tel VARCHAR(10) NOT NULL,
    email VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

-- Table LinkFournitureCommandeFourniture
CREATE TABLE LinkFournitureCommandeFourniture (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantite INT NOT NULL,
    ref_fourniture INT,
    ref_commandeFourniture INT
) ENGINE=InnoDB;

-- Table CommandeFourniture
CREATE TABLE CommandeFourniture (
    id INT PRIMARY KEY,
    valid BOOLEAN NOT NULL,
    raison VARCHAR(255) NOT NULL,
    etat INT NOT NULL,
    ref_utilisateur INT,
    ref_fournisseur INT
) ENGINE=InnoDB;

-- Ajout des contraintes de clé étrangère

-- Table Etudiant
ALTER TABLE Etudiant ADD FOREIGN KEY (ref_utilisateur) REFERENCES Utilisateur(id);

-- Table Dossier
ALTER TABLE Dossier ADD FOREIGN KEY (ref_utilisateur) REFERENCES Utilisateur(id);
ALTER TABLE Dossier ADD FOREIGN KEY (ref_etudiant) REFERENCES Etudiant(id);

-- Table RDV
ALTER TABLE RDV ADD FOREIGN KEY (ref_utilisateur) REFERENCES Utilisateur(id);
ALTER TABLE RDV ADD FOREIGN KEY (ref_salle) REFERENCES Salle(id);
ALTER TABLE RDV ADD FOREIGN KEY (ref_dossier) REFERENCES Dossier(id);

-- Table DemandeFourniture
ALTER TABLE DemandeFourniture ADD FOREIGN KEY (ref_utilisateur) REFERENCES Utilisateur(id);

-- Table LinkDemmandeFournitureFourniture
ALTER TABLE LinkDemmandeFournitureFourniture ADD FOREIGN KEY (ref_demandeFourniture) REFERENCES DemandeFourniture(id);
ALTER TABLE LinkDemmandeFournitureFourniture ADD FOREIGN KEY (ref_fourniture) REFERENCES Fourniture(id);

-- Table LinkFournitureFournisseur
ALTER TABLE LinkFournitureFournisseur ADD FOREIGN KEY (ref_fourniture) REFERENCES Fourniture(id);
ALTER TABLE LinkFournitureFournisseur ADD FOREIGN KEY (ref_fournisseur) REFERENCES Fournisseur(id);

-- Table LinkFournitureCommandeFourniture
ALTER TABLE LinkFournitureCommandeFourniture ADD FOREIGN KEY (ref_fourniture) REFERENCES Fourniture(id);
ALTER TABLE LinkFournitureCommandeFourniture ADD FOREIGN KEY (ref_commandeFourniture) REFERENCES CommandeFourniture(id);

-- Table CommandeFourniture
ALTER TABLE CommandeFourniture ADD FOREIGN KEY (ref_utilisateur) REFERENCES Utilisateur(id);
ALTER TABLE CommandeFourniture ADD FOREIGN KEY (ref_fournisseur) REFERENCES Fournisseur(id);
