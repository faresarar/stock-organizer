-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 04 déc. 2024 à 11:56
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion`
--

USE `gestion`;

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

CREATE TABLE `achat` (
  `num_bon_réception` int(255) NOT NULL DEFAULT 0,
  `date_achat` date DEFAULT NULL,
  `nom_prénom_fournisseur` varchar(255) DEFAULT NULL,
  `prix_achat` double DEFAULT 0,
  `quantité` int(255) DEFAULT 0,
  `id` int(255) NOT NULL,
  `temp_achat` varchar(222) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `somme_versé` double NOT NULL DEFAULT 0,
  `remise` double NOT NULL DEFAULT 0,
  `idf` int(11) NOT NULL DEFAULT 0,
  `désignation` varchar(50) NOT NULL,
  `id_produit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `caisse`
--

CREATE TABLE `caisse` (
  `num_caisse` int(11) NOT NULL,
  `montant` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `caisse`
--

INSERT INTO `caisse` (`num_caisse`, `montant`) VALUES
(1, 0);


-- --------------------------------------------------------

--
-- Structure de la table `caisse_op`
--

CREATE TABLE `caisse_op` (
  `id` int(11) NOT NULL,
  `num_caisse` int(11) NOT NULL,
  `montant` double NOT NULL,
  `date` date NOT NULL,
  `heure` varchar(20) NOT NULL,
  `user` varchar(30) NOT NULL,
  `déscription` varchar(255) NOT NULL,
  `type_op` varchar(15) NOT NULL,
  `num_facture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` varchar(100) NOT NULL,
  `nom_prénom_client` varchar(100) NOT NULL,
  `type_client` varchar(100) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `num_tel1` varchar(100) DEFAULT NULL,
  `num_tel2` varchar(100) DEFAULT NULL,
  `num_reg_commerce` varchar(100) DEFAULT NULL,
  `num_id_fiscale` varchar(100) DEFAULT NULL,
  `num_article_imposition` varchar(100) DEFAULT NULL,
  `RIB_C` varchar(40) DEFAULT NULL,
  `id_c` int(100) NOT NULL,
  `crédit` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_prénom_client`, `type_client`, `adresse`, `email`, `num_tel1`, `num_tel2`, `num_reg_commerce`, `num_id_fiscale`, `num_article_imposition`, `RIB_C`, `id_c`, `crédit`) VALUES
('C0', 'Passager', 'detail', '', '', '', '', '', '', '', '', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `codebarre`
--

CREATE TABLE `codebarre` (
  `id` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `code` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commandefournisseur`
--

CREATE TABLE `commandefournisseur` (
  `num_commande` int(11) NOT NULL,
  `num_bon` int(11) NOT NULL,
  `date` date NOT NULL,
  `nom_prénom_fournisseur` varchar(50) NOT NULL,
  `désignation` varchar(50) NOT NULL,
  `quantité` int(11) NOT NULL,
  `temp` varchar(20) NOT NULL,
  `user` varchar(20) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `idf` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `couleur`
--

CREATE TABLE `couleur` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `dépence`
--

CREATE TABLE `dépence` (
  `année` int(4) DEFAULT NULL,
  `mois` varchar(20) DEFAULT NULL,
  `depence` varchar(100) DEFAULT NULL,
  `montant` double DEFAULT 0,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id_employe` varchar(50) NOT NULL DEFAULT '',
  `nom_prénom_employe` varchar(255) DEFAULT NULL,
  `type_employe` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `num_tel1` varchar(23) DEFAULT NULL,
  `id_e` int(222) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

CREATE TABLE `famille` (
  `valeur` varchar(50) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id_fournisseur` varchar(100) NOT NULL,
  `nom_prenom_fournisseur` varchar(100) DEFAULT NULL,
  `entreuprise` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `num_tel1` varchar(100) DEFAULT NULL,
  `num_tel2` varchar(100) DEFAULT NULL,
  `num_reg` varchar(100) DEFAULT NULL,
  `num_id_fiscale` varchar(100) DEFAULT NULL,
  `num_article_imposition` varchar(100) DEFAULT NULL,
  `RIB_F` varchar(40) DEFAULT NULL,
  `id_f` int(100) NOT NULL,
  `dette` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `fournisseur`
--



-- --------------------------------------------------------

--
-- Structure de la table `images_article`
--

CREATE TABLE `images_article` (
  `image_id` int(11) NOT NULL,
  `id_produit` int(11) DEFAULT NULL,
  `imageURL` varchar(100) DEFAULT NULL,
  `principal_image` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `inventaire`
--

CREATE TABLE `inventaire` (
  `id` int(11) NOT NULL,
  `num_inv` int(10) NOT NULL,
  `date` date NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `désignation` varchar(100) NOT NULL,
  `qte_t` float NOT NULL,
  `qte_p` float NOT NULL,
  `equart_qte` float NOT NULL,
  `prix_achat_ttc` double NOT NULL,
  `temp_inv` varchar(15) NOT NULL,
  `user` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `marques`
--

CREATE TABLE `marques` (
  `valeur` varchar(50) DEFAULT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `paramaitres`
--

CREATE TABLE `paramaitres` (
  `nom_magasin` varchar(255) NOT NULL,
  `adresse_p` varchar(255) NOT NULL,
  `num_tel_fax_fix_p` varchar(255) NOT NULL,
  `num_tel1_p` varchar(255) NOT NULL,
  `num_tel2_p` varchar(255) NOT NULL,
  `NIS` varchar(222) NOT NULL,
  `NRC` varchar(40) NOT NULL,
  `NIF` varchar(40) NOT NULL,
  `RIB` varchar(40) NOT NULL,
  `ID` int(11) NOT NULL,
  `activite` varchar(100) NOT NULL,
  `message` varchar(240) NOT NULL,
  `apercu_ticket` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `paramaitres`
--

INSERT INTO `paramaitres` (`nom_magasin`, `adresse_p`, `num_tel_fax_fix_p`, `num_tel1_p`, `num_tel2_p`, `NIS`, `NRC`, `NIF`, `RIB`, `ID`, `activite`, `message`, `apercu_ticket`) VALUES
('Coding market', '', '', '', '', '', '', '', '', 1, 'Alimentation général', '\nmerci pour votre visite\nتابعونا على الفايسبوك\n\n', 0);

-- --------------------------------------------------------

--
-- Structure de la table `pertes`
--

CREATE TABLE `pertes` (
  `num_perte` int(11) NOT NULL,
  `date` date NOT NULL,
  `heure` varchar(50) NOT NULL,
  `type_perte` varchar(40) NOT NULL,
  `désignation` varchar(50) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `prix_achat` double NOT NULL,
  `quantité` float NOT NULL,
  `quantité_stock` int(11) NOT NULL DEFAULT 0,
  `obsérvation` varchar(100) NOT NULL,
  `user` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='obsérvation';

-- --------------------------------------------------------

--
-- Structure de la table `pointure`
--

CREATE TABLE `pointure` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `famille` varchar(40) DEFAULT NULL,
  `unite` varchar(40) DEFAULT NULL,
  `marque` varchar(40) DEFAULT NULL,
  `image` varchar(120) DEFAULT NULL,
  `référence` varchar(20) DEFAULT NULL,
  `désignation` varchar(40) DEFAULT NULL,
  `étagére` varchar(40) DEFAULT NULL,
  `id_f` int(11) DEFAULT NULL,
  `remarque` varchar(222) DEFAULT NULL,
  `prix_achat` double DEFAULT 0,
  `prix_vente_detail` double DEFAULT 0,
  `prix_vente_gros` double DEFAULT 0,
  `prix_special` double DEFAULT 0,
  `quantité` float NOT NULL,
  `stock_alert` int(11) DEFAULT 0,
  `jour_alert` int(11) DEFAULT 0,
  `tva` float DEFAULT 0,
  `date_premption` date DEFAULT NULL,
  `date_achat` date DEFAULT NULL,
  `taille` varchar(10) DEFAULT NULL,
  `pointure` varchar(10) DEFAULT NULL,
  `couleur` varchar(20) DEFAULT NULL,
  `saisie_par` varchar(20) NOT NULL,
  `code_bare_packet` varchar(20) NOT NULL DEFAULT '',
  `prix_vente_packet` double NOT NULL DEFAULT 0,
  `nbre_produit_packet` int(11) NOT NULL DEFAULT 0,
  `vente_packet` tinyint(1) NOT NULL DEFAULT 0,
  `favorite` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produit_paramaitre`
--

CREATE TABLE `produit_paramaitre` (
  `désignation` tinyint(1) NOT NULL DEFAULT 1,
  `code_barre` tinyint(1) NOT NULL DEFAULT 1,
  `famille` tinyint(1) NOT NULL DEFAULT 1,
  `unite` tinyint(1) NOT NULL DEFAULT 0,
  `marque` tinyint(1) NOT NULL DEFAULT 0,
  `étagére` tinyint(1) NOT NULL DEFAULT 0,
  `remarque` tinyint(1) NOT NULL DEFAULT 0,
  `prix_achat` tinyint(1) NOT NULL DEFAULT 1,
  `prix_vente_detail` tinyint(1) NOT NULL DEFAULT 1,
  `prix_vente_gros` tinyint(1) NOT NULL DEFAULT 0,
  `prix_special` tinyint(1) NOT NULL DEFAULT 0,
  `quantité` tinyint(1) NOT NULL DEFAULT 1,
  `stock_alert` tinyint(1) NOT NULL DEFAULT 0,
  `jour_alert` tinyint(1) NOT NULL DEFAULT 0,
  `tva` tinyint(1) NOT NULL DEFAULT 0,
  `date_premption` tinyint(1) NOT NULL DEFAULT 1,
  `date_achat` tinyint(1) NOT NULL DEFAULT 0,
  `taille` tinyint(1) NOT NULL DEFAULT 0,
  `pointure` tinyint(1) NOT NULL DEFAULT 0,
  `couleur` tinyint(1) NOT NULL DEFAULT 0,
  `saisie_par` tinyint(1) NOT NULL DEFAULT 1,
  `nbre_produit_packet` tinyint(1) NOT NULL DEFAULT 0,
  `prix_vente_packet` tinyint(1) NOT NULL DEFAULT 0,
  `code_bare_packet` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produit_paramaitre`
--

INSERT INTO `produit_paramaitre` (`désignation`, `code_barre`, `famille`, `unite`, `marque`, `étagére`, `remarque`, `prix_achat`, `prix_vente_detail`, `prix_vente_gros`, `prix_special`, `quantité`, `stock_alert`, `jour_alert`, `tva`, `date_premption`, `date_achat`, `taille`, `pointure`, `couleur`, `saisie_par`, `nbre_produit_packet`, `prix_vente_packet`, `code_bare_packet`) VALUES
(1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `salaire_employe`
--

CREATE TABLE `salaire_employe` (
  `id_salaire` int(255) NOT NULL,
  `nom_prenom` varchar(100) DEFAULT '',
  `type_versement` varchar(255) DEFAULT NULL,
  `id_employe` varchar(255) DEFAULT NULL,
  `date_versement` date DEFAULT NULL,
  `montant` double UNSIGNED NOT NULL DEFAULT 0,
  `remarque` varchar(200) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `taille`
--

CREATE TABLE `taille` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `typeclient`
--

CREATE TABLE `typeclient` (
  `type` varchar(222) DEFAULT NULL,
  `id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `typedepence`
--

CREATE TABLE `typedepence` (
  `id_depence` int(255) NOT NULL,
  `depence` varchar(111) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `typedepence`
--

INSERT INTO `typedepence` (`id_depence`, `depence`) VALUES
(5, 'eau'),
(6, 'Elécticité');

-- --------------------------------------------------------

--
-- Structure de la table `typeemploye`
--

CREATE TABLE `typeemploye` (
  `id_fonction` int(255) NOT NULL,
  `type` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `type_perte`
--

CREATE TABLE `type_perte` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `type_perte`
--

INSERT INTO `type_perte` (`ID`, `valeur`) VALUES
(6, 'article cassé'),
(7, 'produit périmé');

-- --------------------------------------------------------

--
-- Structure de la table `unites`
--

CREATE TABLE `unites` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `unites`
--

INSERT INTO `unites` (`ID`, `valeur`) VALUES
(2, 'kg'),
(5, 'piece'),
(7, 'mg'),
(8, 'g'),
(9, 'ml'),
(10, 'l'),
(11, 'll');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `date_vente` date DEFAULT NULL,
  `nom_prénom_client` varchar(255) DEFAULT NULL,
  `TVA` float DEFAULT 0,
  `désignation` varchar(255) DEFAULT NULL,
  `prix_achat` double DEFAULT 0,
  `prix_vente` double DEFAULT 0,
  `quantité_vente` float NOT NULL DEFAULT 0,
  `montantTTC` double DEFAULT 0,
  `montantHT` double DEFAULT 0,
  `id_vente` int(255) NOT NULL,
  `temp_vente` varchar(222) DEFAULT NULL,
  `user` varchar(222) DEFAULT NULL,
  `id_produit` int(11) DEFAULT NULL,
  `idc` int(10) NOT NULL DEFAULT 0,
  `somme_versé` double NOT NULL DEFAULT 0,
  `remise` double NOT NULL DEFAULT 0,
  `num_bon` int(11) NOT NULL DEFAULT 0,
  `Message` varchar(250) NOT NULL DEFAULT '',
  `rendu` double NOT NULL DEFAULT 0,
  `code` varchar(14) NOT NULL DEFAULT '',
  `etat` varchar(15) NOT NULL DEFAULT 'valide'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `versement_client`
--

CREATE TABLE `versement_client` (
  `num_versement` int(222) NOT NULL,
  `nom_prénom_client` varchar(255) DEFAULT NULL,
  `date_versement` date DEFAULT NULL,
  `montant_versé` double DEFAULT 0,
  `id_c` int(255) DEFAULT 0,
  `etat` varchar(10) NOT NULL,
  `num_bon_réception` int(11) NOT NULL DEFAULT 0,
  `remarque` varchar(100) NOT NULL,
  `regler_par` varchar(50) NOT NULL,
  `ancien_dette` double NOT NULL DEFAULT 0,
  `rendu` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `versement_fournisseur`
--

CREATE TABLE `versement_fournisseur` (
  `num_versement` int(222) NOT NULL,
  `nom_prénom_fournisseur` varchar(255) DEFAULT NULL,
  `date_versement` date DEFAULT NULL,
  `montant_versé` double DEFAULT 0,
  `id_f` int(255) DEFAULT NULL,
  `etat` varchar(10) NOT NULL,
  `num_bon_réception` int(11) NOT NULL,
  `remarque` varchar(100) NOT NULL,
  `regler_par` varchar(50) NOT NULL,
  `ancien_dette` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `achat`
--
ALTER TABLE `achat`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `caisse`
--
ALTER TABLE `caisse`
  ADD PRIMARY KEY (`num_caisse`);

--
-- Index pour la table `caisse_op`
--
ALTER TABLE `caisse_op`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_c`);

--
-- Index pour la table `codebarre`
--
ALTER TABLE `codebarre`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `const1` (`id_produit`);

--
-- Index pour la table `commandefournisseur`
--
ALTER TABLE `commandefournisseur`
  ADD PRIMARY KEY (`num_commande`);

--
-- Index pour la table `couleur`
--
ALTER TABLE `couleur`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `dépence`
--
ALTER TABLE `dépence`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id_e`);

--
-- Index pour la table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id_f`);

--
-- Index pour la table `images_article`
--
ALTER TABLE `images_article`
  ADD PRIMARY KEY (`image_id`);

--
-- Index pour la table `inventaire`
--
ALTER TABLE `inventaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `marques`
--
ALTER TABLE `marques`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `paramaitres`
--
ALTER TABLE `paramaitres`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `pertes`
--
ALTER TABLE `pertes`
  ADD PRIMARY KEY (`num_perte`);

--
-- Index pour la table `pointure`
--
ALTER TABLE `pointure`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `référence` (`référence`),
  ADD KEY `référence_2` (`référence`);

--
-- Index pour la table `salaire_employe`
--
ALTER TABLE `salaire_employe`
  ADD PRIMARY KEY (`id_salaire`);

--
-- Index pour la table `taille`
--
ALTER TABLE `taille`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `typeclient`
--
ALTER TABLE `typeclient`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `typedepence`
--
ALTER TABLE `typedepence`
  ADD PRIMARY KEY (`id_depence`);

--
-- Index pour la table `typeemploye`
--
ALTER TABLE `typeemploye`
  ADD PRIMARY KEY (`id_fonction`);

--
-- Index pour la table `type_perte`
--
ALTER TABLE `type_perte`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `unites`
--
ALTER TABLE `unites`
  ADD PRIMARY KEY (`ID`) USING BTREE;

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id_vente`);

--
-- Index pour la table `versement_client`
--
ALTER TABLE `versement_client`
  ADD PRIMARY KEY (`num_versement`);

--
-- Index pour la table `versement_fournisseur`
--
ALTER TABLE `versement_fournisseur`
  ADD PRIMARY KEY (`num_versement`),
  ADD KEY `const2` (`num_bon_réception`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `achat`
--
ALTER TABLE `achat`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `caisse_op`
--
ALTER TABLE `caisse_op`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_c` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `codebarre`
--
ALTER TABLE `codebarre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `commandefournisseur`
--
ALTER TABLE `commandefournisseur`
  MODIFY `num_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `couleur`
--
ALTER TABLE `couleur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `dépence`
--
ALTER TABLE `dépence`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id_e` int(222) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `famille`
--
ALTER TABLE `famille`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id_f` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `images_article`
--
ALTER TABLE `images_article`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `inventaire`
--
ALTER TABLE `inventaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `marques`
--
ALTER TABLE `marques`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `pertes`
--
ALTER TABLE `pertes`
  MODIFY `num_perte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `pointure`
--
ALTER TABLE `pointure`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `salaire_employe`
--
ALTER TABLE `salaire_employe`
  MODIFY `id_salaire` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `taille`
--
ALTER TABLE `taille`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `typeclient`
--
ALTER TABLE `typeclient`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `typedepence`
--
ALTER TABLE `typedepence`
  MODIFY `id_depence` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `typeemploye`
--
ALTER TABLE `typeemploye`
  MODIFY `id_fonction` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `type_perte`
--
ALTER TABLE `type_perte`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `unites`
--
ALTER TABLE `unites`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `id_vente` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT pour la table `versement_client`
--
ALTER TABLE `versement_client`
  MODIFY `num_versement` int(222) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `versement_fournisseur`
--
ALTER TABLE `versement_fournisseur`
  MODIFY `num_versement` int(222) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `codebarre`
--
ALTER TABLE `codebarre`
  ADD CONSTRAINT `const1` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
